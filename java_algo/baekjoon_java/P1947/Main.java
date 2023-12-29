package baekjoon_java.P1947;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static final int MOD_CONST = 1000000000;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

		if (n == 1) {
			System.out.println(0);
			return;
		}

		long[] dp = new long[n + 1];
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;

		for (int i = 3; i < n + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
			dp[i] *= (i - 1);
			dp[i] %= MOD_CONST;
		}

		System.out.println(dp[n]);
	}
}
