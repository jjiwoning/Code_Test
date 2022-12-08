package Programmers_java.twoxntile;

/**
 * 프로그래머스 - 2 * n 타일링
 */
public class Solution {
    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
            if (dp[i] > 1000000007) {
                dp[i] %= 1000000007;
            }
        }

        return dp[n];
    }
}
