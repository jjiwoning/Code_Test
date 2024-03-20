package baekjoon_java.P14716;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static final int[] dx = new int[] {1, -1, 0, 0, 1, -1, 1, -1};
	private static final int[] dy = new int[] {0, 0, 1, -1, 1, -1, -1, 1};

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

		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		int answer = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					dfs(i, j);
					answer++;
				}
			}
		}

		System.out.println(answer);
	}

	private static void dfs(int x, int y) {
		for (int i = 0; i < 8; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];

			if (mx < 0 || mx >= n || my < 0 || my >= m) {
				continue;
			}

			if (map[mx][my] == 0) {
				continue;
			}

			if (visited[mx][my]) {
				continue;
			}

			visited[mx][my] = true;
			dfs(mx, my);
		}
	}
}
