package baekjoon_java.P1699;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = i;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j * j <= i; j++) {
                int num = dp[i - (j * j)] + 1;
                if (dp[i] > num) {
                    dp[i] = num;
                }
            }
        }

        System.out.println(dp[n]);
    }
}
