package Programmers_java.kakao258705;

public class Solution {

	private static final int MOD_CONST = 10007;

	public int solution(int n, int[] tops) {
		int[] dp = new int[2 * n + 2];
		dp[0] = 1;

		for (int i = 1; i <= 2 * n + 1; i++) {
			if (i % 2 == 0) {
				// 삼각형 모양이 역으로 되어있는 경우
				dp[i] += dp[i - 2];
				dp[i] %= MOD_CONST;
				dp[i] += dp[i - 1];
				dp[i] %= MOD_CONST;
				if (tops[i / 2 - 1] == 1) {
					// 뿔이 달린 경우
					dp[i] += dp[i - 1];
					dp[i] %= MOD_CONST;
				}
			}
			if (i % 2 == 1) {
				// 원래의 삼각형 모양
				dp[i] += dp[i - 1];
				if (i - 2 > 0) {
					dp[i] += dp[i - 2];
				}
				dp[i] %= MOD_CONST;
			}
		}

		return dp[2 * n + 1];
	}
}

class Test {
	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution(4, new int[] {1, 1, 0, 1});
	}
}