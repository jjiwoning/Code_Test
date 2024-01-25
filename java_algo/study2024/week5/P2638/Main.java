package study2024.week5.P2638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

	private static final int[] dx = new int[] {1, -1, 0, 0};
	private static final int[] dy = new int[] {0, 0, 1, -1};

	private int n;

	private int m;

	private int[][] cheese;
	private int[][] melting;
	private boolean[][] visited;
	private boolean[][] cheeseVisited;

	public int solution(int n, int m, int[][] cheese) {
		this.n = n;
		this.m = m;
		this.cheese = cheese;

		int count = 0;

		while (true) {
			melting = new int[n][m];
			visited = new boolean[n][m];
			cheeseVisited = new boolean[n][m];

			dfs(0, 0);

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (cheese[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
					}
				}
			}

			boolean isAllMelting = true;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					cheese[i][j] -= melting[i][j];
					if (cheese[i][j] > 0) {
						isAllMelting = false;
					}
				}
			}

			count++;

			if (isAllMelting) {
				break;
			}
		}

		return count;
	}

	private void dfs(int x, int y) {

		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];

			if (mx < 0 || mx >= n || my < 0 || my >= m) {
				continue;
			}

			if (cheese[mx][my] == 0 && !cheeseVisited[mx][my]) {
				cheeseVisited[mx][my] = true;
				dfs(mx, my);
			}
		}
	}

	private void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			int cnt = 0;

			for (int i = 0; i < 4; i++) {
				int mx = now.x + dx[i];
				int my = now.y + dy[i];

				if (mx < 0 || mx >= n || my < 0 || my >= m) {
					continue;
				}

				if (cheese[mx][my] == 0) {
					if (cheeseVisited[mx][my]) {
						cnt++;
					}
					continue;
				}

				if (visited[mx][my]) {
					continue;
				}

				if (cheese[mx][my] == 1) {
					visited[mx][my] = true;
					queue.add(new Node(mx, my));
				}
			}

			if (cnt >= 2) {
				melting[now.x][now.y]++;
			}
		}
	}
}

class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] cheese = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(new Solution().solution(n, m, cheese));
	}
}
