package study.week4.P1562;

import java.util.Scanner;

public class Main {

    private static int MOD = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][][] dp = new long[10][n][1 << 10];

        System.out.println(findAnswer(n, dp));
    }

    private static long findAnswer(int n, long[][][] dp) {

        if (n < 10) {
            return 0;
        }

        for (int i = 1; i < 10; i++) {
            dp[i][0][1 << i] = 1;
        }


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < (1 << 10); k++) {
                    int now = 1 << j | k;
                    if (j == 0) {
                        dp[j][i][now] += (dp[j + 1][i - 1][k] % MOD);
                        continue;
                    }
                    if (j == 9) {
                        dp[j][i][now] += (dp[j - 1][i - 1][k] % MOD);
                        continue;
                    }
                    dp[j][i][now] += (dp[j - 1][i - 1][k] + dp[j + 1][i - 1][k]) % MOD;
                }
            }
        }


        long answer = 0;

        for (int i = 0; i < 10; i++) {
            answer += dp[i][n - 1][1023];
            answer %= MOD;
        }

        return answer;
    }
}
