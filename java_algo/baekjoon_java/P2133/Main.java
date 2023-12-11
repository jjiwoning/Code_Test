package baekjoon_java.P2133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

		long[] dp = new long[n + 1];

		if (n % 2 == 1) {
			System.out.println(0);
			return;
		}

		// 기본 값 세팅
		dp[0] = 1;
		dp[1] = 0;

		// dp
		for (int i = 2; i < n + 1; i += 2) {
			dp[i] = dp[i - 2] * 3;
			for (int j = i - 4; j >= 0; j -= 2) {
				dp[i] += dp[j] * 2;
			}
		}

		System.out.println(dp[n]);
	}
}
