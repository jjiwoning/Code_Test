package baekjoon_java.P1309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        int[][] dp = new int[3][n + 1];

        // dp init
        dp[0][0] = 1;

        for (int i = 1; i < n + 1; i++) {
            dp[0][i] = dp[0][i - 1] + dp[1][i - 1] + dp[2][i - 1];
            dp[1][i] = dp[0][i - 1] + dp[2][i - 1];
            dp[2][i] = dp[0][i - 1] + dp[1][i - 1];

            dp[0][i] %= 9901;
            dp[1][i] %= 9901;
            dp[2][i] %= 9901;
        }

        System.out.println((dp[0][n] + dp[1][n] + dp[2][n]) % 9901);
    }
}
