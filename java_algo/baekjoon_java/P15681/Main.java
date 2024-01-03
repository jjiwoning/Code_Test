package baekjoon_java.P15681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static boolean[] visited;
	private static int[] dp;
	private static List<List<Integer>> edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int root = Integer.parseInt(st.nextToken());
		int queryCount = Integer.parseInt(st.nextToken());

		visited = new boolean[n + 1];
		dp = new int[n + 1];
		edges = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			edges.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			edges.get(s).add(e);
			edges.get(e).add(s);
		}

		visited[root] = true;
		dfs(root);

		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < queryCount; i++) {
			int target = Integer.parseInt(br.readLine());
			answer.append(dp[target]).append("\n");
		}

		System.out.println(answer);
	}

	private static void dfs(int root) {

		dp[root] = 1;

		for (Integer num : edges.get(root)) {
			if (!visited[num]) {
				visited[num] = true;
				dfs(num);
				dp[root] += dp[num];
			}
		}
	}
}
