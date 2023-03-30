package baekjoon_java.P17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][][] dp = new int[3][n][n]; // 0: 가로, 1: 세로, 2: 대각선
        dp[0][0][1] = 1; // 첫 파이프 위치

        for (int y = 2; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (map[x][y] == 1) {
                    continue;
                }
                if (x == 0) {
                    dp[0][x][y] += dp[0][x][y - 1];
                    continue;
                }
                dp[0][x][y] += dp[0][x][y - 1] + dp[2][x][y - 1];
                dp[1][x][y] += dp[1][x - 1][y] + dp[2][x - 1][y];
                if (map[x - 1][y] == 1 || map[x][y - 1] == 1) {
                    continue;
                }
                dp[2][x][y] += dp[0][x - 1][y - 1] + dp[1][x - 1][y - 1] + dp[2][x - 1][y - 1];
            }
        }

        System.out.println(dp[0][n - 1][n - 1] + dp[1][n - 1][n - 1] + dp[2][n - 1][n - 1]);
    }
}
