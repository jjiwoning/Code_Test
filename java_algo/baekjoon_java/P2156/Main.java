package baekjoon_java.P2156;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 점화식: (직전 dp값), (2번째 전 dp 값 + 현재 포도주), (3번째 전 dp 값 + 직전 포도주 + 현재 포도주) 중 최대값
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {

            if (i == 1) {
                dp[1] = arr[1] + arr[0];
                continue;
            }

            if (i == 2) {
                dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2])); // 이 경우는 점화식에서 하나가 빠져서 따로 구하기
                continue;
            }

            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }

        System.out.println(dp[n - 1]);
    }
}
