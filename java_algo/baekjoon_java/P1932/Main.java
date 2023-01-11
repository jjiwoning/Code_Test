package baekjoon_java.P1932;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j > 0 && j < i) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + dp[i][j];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j];
                    continue;
                }
                if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j];
                }
            }
        }

        int answer = -1;

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }

        System.out.println(answer);
    }
}
