package Programmers_java.P181186;

public class Solution {

	private final static int MOD_CONST = 1_000_000_007;

	public int solution(int n) {
		long[] dp = new long[n + 1];
		long[] unique4Dp = new long[n + 1]; // 4 -> 7 -> 10 -> 13...
		long[] unique5Dp = new long[n + 1]; // 5 -> 8 -> 11 -> 14...
		long[] unique6Dp = new long[n + 1]; // 6 -> 9 -> 12 -> 15...

		dp[0] = 1L; // dp init

		for (int i = 1; i < n + 1; i++) {
			dp[i] += dp[i - 1]; // 1자 기둥 붙이는 경우의 수
			dp[i] %= MOD_CONST;

			if (i > 1) {
				dp[i] += dp[i - 2] * 2;
				dp[i] %= MOD_CONST;
			}

			if (i > 2) {
				dp[i] += dp[i - 3] * 5;
				dp[i] %= MOD_CONST;
			}

			if (i > 3) {
				long find = (dp[i - 4] * 2) % MOD_CONST;
				unique4Dp[i] = (unique4Dp[i - 3] + find) % MOD_CONST;
				dp[i] += unique4Dp[i];
				dp[i] %= MOD_CONST;
			}

			if (i > 4) {
				long find = (dp[i - 5] * 2) % MOD_CONST;
				unique5Dp[i] = (unique5Dp[i - 3] + find) % MOD_CONST;
				dp[i] += unique5Dp[i];
				dp[i] %= MOD_CONST;
			}

			if (i > 5) {
				long find = (dp[i - 6] * 4) % MOD_CONST;
				unique6Dp[i] = (unique6Dp[i - 3] + find) % MOD_CONST;
				dp[i] += unique6Dp[i];
				dp[i] %= MOD_CONST;
			}
		}

		return (int)(dp[n] % MOD_CONST);
	}
}
