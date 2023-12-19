package baekjoon_java.P9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static final int[] DX = new int[] {1, -1, 0, 0};
	private static final int[] DY = new int[] {0, 0, 1, -1};
	public static final int MAX = 987654321;

	private static int n;
	private static int m;
	private static char[][] map;
	private static int[][] outerVisited; // doorCount, x, y
	private static int[][] prisoner1Visited; // doorCount, x, y
	private static int[][] prisoner2Visited; // doorCount, x, y

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();

		for (int testCase = 0; testCase < t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken()) + 2;
			m = Integer.parseInt(st.nextToken()) + 2;

			map = new char[n][m];
			Arrays.fill(map[0], '.');
			Arrays.fill(map[n - 1], '.');

			List<Node> prisoners = new ArrayList<>();

			for (int i = 1; i < n - 1; i++) {
				Arrays.fill(map[i], '.');
				char[] chars = br.readLine().toCharArray();
				for (int j = 1; j < m - 1; j++) {
					map[i][j] = chars[j - 1];
					if (chars[j - 1] == '$') {
						prisoners.add(new Node(i, j, 0));
					}
				}
			}

			outerVisited = new int[n][m];
			for (int i = 0; i < n; i++) {
				Arrays.fill(outerVisited[i], MAX);
			}

			prisoner1Visited = new int[n][m];
			for (int i = 0; i < n; i++) {
				Arrays.fill(prisoner1Visited[i], MAX);
			}

			prisoner2Visited = new int[n][m];
			for (int i = 0; i < n; i++) {
				Arrays.fill(prisoner2Visited[i], MAX);
			}

			bfs(new Node(0, 0, 0), outerVisited); // 외부인
			bfs(prisoners.get(0), prisoner1Visited); // 죄수 1
			bfs(prisoners.get(1), prisoner2Visited); // 죄수 2

			int[][] result = new int[n][m];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == '*') {
						result[i][j] = Integer.MAX_VALUE;
						continue;
					}
					if (outerVisited[i][j] == MAX || prisoner1Visited[i][j] == MAX || prisoner2Visited[i][j] == MAX) {
						result[i][j] = Integer.MAX_VALUE;
						continue;
					}
					result[i][j] += outerVisited[i][j] + prisoner1Visited[i][j] + prisoner2Visited[i][j];
					if (map[i][j] == '#') {
						result[i][j] -= 2;
					}
				}
			}

			int find = Integer.MAX_VALUE;

			for (int[] ints : result) {
				for (int num : ints) {
					find = Math.min(find, num);
				}
			}

			answer.append(find).append("\n");
		}

		System.out.println(answer);
	}

	private static void bfs(Node start, int[][] visited) {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.doorCount));

		priorityQueue.add(start);
		visited[start.x][start.y] = 0;

		while (!priorityQueue.isEmpty()) {
			Node node = priorityQueue.poll();

			for (int i = 0; i < 4; i++) {
				int mx = node.x + DX[i];
				int my = node.y + DY[i];

				if (mx < 0 || mx >= n || my < 0 || my >= m) {
					continue;
				}

				if (visited[mx][my] != MAX) {
					continue;
				}

				if (map[mx][my] == '*') {
					continue;
				}

				if (map[mx][my] == '#') {
					visited[mx][my] = node.doorCount + 1;
					priorityQueue.add(new Node(mx, my, node.doorCount + 1));
					continue;
				}

				visited[mx][my] = node.doorCount;
				priorityQueue.add(new Node(mx, my, node.doorCount));
			}
		}
	}
}

class Node {
	int x;
	int y;
	int doorCount;

	public Node(int x, int y, int doorCount) {
		this.x = x;
		this.y = y;
		this.doorCount = doorCount;
	}
}
