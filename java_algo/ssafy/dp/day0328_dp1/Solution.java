package ssafy.dp.day0328_dp1;

import java.util.Scanner;

public class Solution {
    public int solution(int n) {
        int[][] dp = new int[n + 1][2]; // arr[][0] = yellow, arr[][1] = blue

        // init
        dp[1][0] = 1;
        dp[1][1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1]; // yellow는 모든 경우 가능
            dp[i][1] = dp[i - 1][0]; // blue는 직전이 yellow인 경우만 가능
        }

        return dp[n][0] + dp[n][1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] memo = new int[N + 1][2]; // 0이 노랑 1이 파랑 가짓수 저장

        memo[1][0] = 1;
        memo[1][1] = 1;

        for (int i = 1; i < N; i++) {
            memo[i + 1][0] = memo[i][1] + memo[i][0];
            memo[i + 1][1] = memo[i][0];
        }
        int res = 0;
        for (int i = 0; i < 2; i++) {
            res += memo[N][i];
        }
        System.out.println(res);
    }

}
