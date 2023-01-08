package baekjoon_java.P1149;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] dp = new int[n][3];

        dp[0][0] = sc.nextInt();
        dp[0][1] = sc.nextInt();
        dp[0][2] = sc.nextInt();

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int color = sc.nextInt();
                dp[i][j] = color + findMin(i, j, dp);
            }
        }

        int answer = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        System.out.println(answer);
    }

    private static int findMin(int index, int rgbCode, int[][] dp) {
        int beforeIdx = index - 1;
        if (rgbCode == 0) {
            return Math.min(dp[beforeIdx][1], dp[beforeIdx][2]);
        }

        if (rgbCode == 1) {
            return Math.min(dp[beforeIdx][0], dp[beforeIdx][2]);
        }

        if (rgbCode == 2) {
            return Math.min(dp[beforeIdx][0], dp[beforeIdx][1]);
        }

        return 0;
    }
}
