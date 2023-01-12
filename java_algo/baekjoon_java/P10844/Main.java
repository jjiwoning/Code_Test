package baekjoon_java.P10844;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long arr[][] = new long[n + 1][10];
        final long DIV = 1000000000L;

        for (int i = 1; i < 10; i++) {
            arr[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    arr[i][j] = arr[i - 1][j + 1] % DIV;
                    continue;
                }

                if (j == 9) {
                    arr[i][j] = arr[i - 1][j - 1] % DIV;
                    continue;
                }

                arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % DIV;
            }
        }

        long answer = 0;

        for (int i = 0; i < 10; i++) {
            answer += arr[n][i];
        }

        System.out.println(answer % DIV);
    }
}
