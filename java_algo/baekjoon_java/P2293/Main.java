package baekjoon_java.P2293;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int wanted = sc.nextInt();

        int[] coins = new int[n];
        int[] dp = new int[wanted + 1];
        dp[0] = 1; // 초기화

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
            for (int j = coins[i]; j <= wanted; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        System.out.println(dp[wanted]);
    }
}
