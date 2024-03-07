package baekjoon_java.P12919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int answer = 0;
	private static String target;

	public static void main(String[] args) throws IOException {
		final var br = new BufferedReader(new InputStreamReader(System.in));

		target = br.readLine();
		var start = br.readLine();

		dfs(start);

		System.out.println(answer);
	}

	private static void dfs(String now) {
		if (answer == 1) {
			return;
		}

		if (now.equals(target)) {
			answer = 1;
			return;
		}

		if (now.isEmpty()) {
			return;
		}

		if (now.charAt(now.length() - 1) == 'A') {
			dfs(now.substring(0, now.length() - 1));
		}

		if (now.charAt(0) == 'B') {
			String make = new StringBuilder(now).reverse().toString();
			dfs(make.substring(0, make.length() - 1));
		}
	}
}
