package Programmers_java.P154538;

import java.util.Arrays;

import static java.lang.Math.*;

public class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, 12345678);
        dp[x] = 1;

        for (int i = x; i < y + 1; i++) {
            if (i * 2 < y) {
                dp[i * 2] = min(dp[i * 2], dp[i] + 1);
            }
            if (i * 3 < y) {
                dp[i * 3] = min(dp[i * 3], dp[i] + 1);
            }
            if (i + n < y) {
                dp[i + n] = min(dp[i + n], dp[i] + 1);
            }
        }


        if (dp[y] == 12345678) {
            return -1;
        }
        return dp[y];
    }
}
