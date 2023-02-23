package study.week4.P1562;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][][] dp = new int[10][n][1 << 10];

        System.out.println(findAnswer(n, dp));
    }

    private static int findAnswer(int n, int[][][] dp) {

        if (n < 10) {
            return 0;
        }

        for (int i = 1; i < 10; i++) {
            dp[i][0][1 << i] = 1;
        }


        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < (1 << 10); k++) {
                    if (j == 0) {
                        continue;
                    }
                    if (j == 9) {
                        continue;
                    }
                    System.out.println(k);
                }
            }
        }


        int answer = 0;

        for (int i = 1; i < 10; i++) {

        }

        return answer;
    }
}
