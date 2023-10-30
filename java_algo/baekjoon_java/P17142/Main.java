package baekjoon_java.P17142;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int m;

	private static int[][] map;
	private static List<Node> nodes;
	private static boolean[] nodesVisited;
	private static Queue<Node> queue;
	private static int[] dx = new int[] {1, -1, 0, 0};
	private static int[] dy = new int[] {0, 0, 1, -1};
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		nodes = new ArrayList<>();
		answer = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 2) {
					nodes.add(new Node(i, j, 0));
				}
				map[i][j] = num * -1;
			}
		}

		nodesVisited = new boolean[nodes.size()];
		queue = new LinkedList<>();

		dfs(0, -1);

		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(answer);
	}

	private static void dfs(int depth, int index) {
		if (depth == m) {
			int[][] cloneArray = cloneArray(map);
			for (int i = 0; i < nodes.size(); i++) {
				if (nodesVisited[i]) {
					queue.add(new Node(nodes.get(i)));
				}
			}
			answer = Math.min(answer, bfs(cloneArray));
			return;
		}

		for (int i = index + 1; i < nodes.size(); i++) {
			nodesVisited[i] = true;
			dfs(depth + 1, i);
			nodesVisited[i] = false;
		}
	}

	private static int bfs(int[][] cloneMap) {

		int cost = 0;

		while (true) {
			int queueSize = queue.size();

			if (checkArr(cloneMap)) {
				queue.clear();
				return cost;
			}

			if (queueSize == 0) {
				queue.clear();
				return Integer.MAX_VALUE;
			}

			for (int i = 0; i < queueSize; i++) {
				Node now = queue.poll();

				for (int j = 0; j < 4; j++) {
					int mx = now.x + dx[j];
					int my = now.y + dy[j];

					if (mx < 0 || mx >= n || my < 0 || my >= n) {
						continue;
					}

					if (cloneMap[mx][my] == -1 || cloneMap[mx][my] > 0) {
						continue;
					}

					cloneMap[mx][my] = now.cost + 1;
					queue.add(new Node(mx, my, now.cost + 1));
				}

			}

			cost++;
		}
	}

	private static boolean checkArr(int[][] cloneMap) {
		for (int[] ints : cloneMap) {
			for (int num : ints) {
				if (num == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static int[][] cloneArray(int[][] map) {
		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = map[i][j];
			}
		}

		return arr;
	}
}

class Node {
	int x;
	int y;
	int cost;

	public Node(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	public Node(Node node) {
		this.x = node.x;
		this.y = node.y;
		this.cost = 0;
	}
}
