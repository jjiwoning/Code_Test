package baekjoon_java.P12101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static int n;

	private static int m;

	private static int count;

	private static List<Integer> result;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		count = 0;

		dfs(0, new ArrayList<>());

		if (result == null) {
			System.out.println(-1);
			return;
		}

		StringBuilder answer = new StringBuilder();

		for (Integer num : result) {
			answer.append(num).append("+");
		}
		System.out.println(answer.substring(0, answer.length() - 1));
	}

	private static void dfs(int sum, List<Integer> now) {
		if (sum == n) {
			count++;
			if (count == m) {
				result = now;
			}
			return;
		}

		if (sum > n) {
			return;
		}

		if (result != null) {
			return;
		}

		for (int i = 1; i <= 3; i++) {
			List<Integer> make = new ArrayList<>(now);
			make.add(i);
			dfs(sum + i, make);
		}
	}

}
