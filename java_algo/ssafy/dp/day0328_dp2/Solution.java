package ssafy.dp.day0328_dp2;

public class Solution {
    public int solution(int n) {
        int[][] dp = new int[n + 1][3]; // 0: blue, 1: yellow, 2: red

        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[2][2] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i][0] += dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]; // blue
            dp[i][1] += dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]; // yellow
            dp[i][2] += dp[i - 2][0] + dp[i - 2][1] + dp[i - 2][2]; // red
        }

        return dp[n][0] + dp[n][1] + dp[n][2];
    }

}
