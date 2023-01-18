package baekjoon_java.P9465;

import java.util.Scanner;

//현재 가질 수 있는 최대값: (직전 스티커의 반대편에서 총 합 + 현재 스티커) or (2 번째 전 스티커 2개 중의 최대값 + 현재 스티커)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int tc = 0; tc < n; tc++) {
            int size = sc.nextInt();
            int[][] sticker = new int[2][size + 1];
            int[][] dp = new int[2][size + 1];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < size; j++) {
                    sticker[i][j] = sc.nextInt();
                }
            }

            dp[0][1] = sticker[0][0];
            dp[1][1] = sticker[1][0];

            for (int j = 2; j <= size; j++) {
                for (int i = 0; i < 2; i++) {
                    if (i == 0) {
                        dp[i][j] = Math.max(dp[i + 1][j - 1], Math.max(dp[i + 1][j - 2], dp[i][j - 2])) + sticker[i][j - 1];
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i][j - 2], dp[i - 1][j - 2])) + sticker[i][j - 1];
                }
            }

            System.out.println(Math.max(dp[0][size], dp[1][size]));

        }
    }
}
