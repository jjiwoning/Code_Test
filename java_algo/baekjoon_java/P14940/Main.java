package baekjoon_java.P14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static final int[] dx = new int[] {1, -1, 0, 0};
	private static final int[] dy = new int[] {0, 0, 1, -1};

	private static int n;
	private static int m;

	private static int[][] map;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		Node start = null;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 2) {
					start = new Node(i, j, 0);
				}
				map[i][j] = num * -1;
			}
		}

		bfs(start);

		for (int[] ints : map) {
			StringBuilder sb = new StringBuilder();
			for (int anInt : ints) {
				sb.append(anInt).append(" ");
			}
			System.out.println(sb);
		}
	}

	private static void bfs(Node start) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(start);
		map[start.x][start.y] = 0;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int mx = now.x + dx[i];
				int my = now.y + dy[i];

				if (mx < 0 || mx >= n || my < 0 || my >= m) {
					continue;
				}

				if (map[mx][my] >= 0) {
					continue;
				}

				map[mx][my] = now.distance + 1;
				queue.add(new Node(mx, my, now.distance + 1));
			}
		}
	}
}

class Node {
	int x;
	int y;

	int distance;

	public Node(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
}
