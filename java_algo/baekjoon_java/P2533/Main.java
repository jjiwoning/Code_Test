package baekjoon_java.P2533;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static int[][] dp; // dp[0] : 일반인, dp[1] : 얼리어답터

	private static boolean[] visited;
	private static List<List<Integer>> edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		dp = new int[2][n + 1];
		visited = new boolean[n + 1];
		edges = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			edges.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			edges.get(s).add(e);
			edges.get(e).add(s);
		}

		visited[1] = true;
		dfs(1);

		System.out.println(Math.min(dp[0][1], dp[1][1]));
	}

	private static void dfs(int start) {

		dp[1][start] = 1; // 내가 얼리어답터인 경우 초기화

		for (int next : edges.get(start)) {
			if (!visited[next]) {
				visited[next] = true;
				dfs(next);
				// 내가 일반인 -> 내 다음은 무조건 얼리어답터
				dp[0][start] += dp[1][next];
				// 내가 얼리어답터 -> 내 다음은 아무거나 상관없음 -> min 값을 구하는 문제이니 min으로 초기화
				dp[1][start] += Math.min(dp[1][next], dp[0][next]);
			}
		}
	}
}
