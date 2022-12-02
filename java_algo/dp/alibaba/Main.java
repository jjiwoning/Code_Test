package dp.alibaba;

import java.util.Scanner;

/**
 * DP - 알리바바와 40인의 도둑
 */
public class Main {
    public static void main(String[] args) {
        // 입력부
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = sc.nextInt();
            }
        }

        //로직
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j > 0) {
                    dp[i][j] += dp[i][j - 1];
                    continue;
                }
                if (j == 0 && i > 0) {
                    dp[i][j] += dp[i - 1][j];
                    continue;
                }
                if (i > 0 && j > 0) {
                    int minValue = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] += minValue;
                }
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}
