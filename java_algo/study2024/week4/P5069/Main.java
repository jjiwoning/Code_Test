package study2024.week4.P5069;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static final int[] dx = new int[] {0, 0, 1, -1, 1, -1};
	public static final int[] dy = new int[] {1, -1, 0, 0, 1, -1};

	private static Map<Integer, Map<Integer, Map<Integer, Integer>>> dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < t; i++) {
			dp = new HashMap<>();
			int count = Integer.parseInt(br.readLine());

			dfs(0, 0, count);

			answer.append(dp.get(0).get(0).get(count)).append("\n");
		}

		System.out.println(answer);
	}

	private static int dfs(int x, int y, int count) {
		if (count == 0) {
			if (x == 0 && y == 0) {
				return 1;
			}
			return 0;
		}

		if (!dp.containsKey(x)) {
			dp.put(x, new HashMap<>());
		}
		if (!dp.get(x).containsKey(y)) {
			dp.get(x).put(y, new HashMap<>());
		}
		if (dp.get(x).get(y).containsKey(count)) {
			return dp.get(x).get(y).get(count);
		}

		int result = 0;
		for (int i = 0; i < 6; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			result += dfs(mx, my, count - 1);
		}

		dp.get(x).get(y).put(count, result);
		return result;
	}
}
