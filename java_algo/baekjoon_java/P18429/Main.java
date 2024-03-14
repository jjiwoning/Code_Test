package baekjoon_java.P18429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int answer;
	private static int n;
	private static int k;
	private static int[] values;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		visited = new boolean[n];

		values = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		answer = 0;

		dfs(0, 500);

		System.out.println(answer);
	}

	private static void dfs(int depth, int value) {
		if (value < 500) {
			return;
		}
		if (depth == n) {
			answer++;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(depth + 1, value - k + values[i]);
				visited[i] = false;
			}
		}
	}
}
