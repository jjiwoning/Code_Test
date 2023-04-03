package study.week11.P2169;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < m; i++) {
            dp[0][i] = dp[0][max(i - 1, 0)] + map[0][i];
        }

        for (int i = 1; i < n; i++) {

            int[][] values = new int[3][m]; // 0: 위, 1: 왼, 2: 오

            // 일단 아래로 보내기
            for (int j = 0; j < m; j++) {
                values[0][j] = dp[i - 1][j];
            }

            values[1][0] = values[0][0] + map[i][0];

            // 좌
            for (int j = 1; j < m; j++) {
                values[1][j] = max(values[1][j - 1], values[0][j]) + map[i][j];
            }

            values[2][m - 1] = values[0][m - 1] + map[i][m - 1];

            // 우
            for (int j = m - 2; j >= 0; j--) {
                values[2][j] = max(values[2][j + 1], values[0][j]) + map[i][j];
                dp[i][j] = max(values[1][j], values[2][j]);
            }

            dp[i][m - 1] = max(values[1][m - 1], values[2][m - 1]);
        }

        System.out.println(dp[n - 1][m - 1]);
    }
}
