package baekjoon_java.P1463;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] dp = new int[num + 1];

        for (int i = 2; i < dp.length; i++) {
            if (i % 2 == 0 && i % 3 == 0) {
                dp[i] = Math.min(dp[i - 1], Math.min(dp[i / 2], dp[i / 3])) + 1;
                continue;
            }

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i - 1], dp[i / 2]) + 1;
                continue;
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i - 1], dp[i / 3]) + 1;
                continue;
            }

            dp[i] = dp[i - 1] + 1;
        }

        System.out.println(dp[num]);
    }
}
