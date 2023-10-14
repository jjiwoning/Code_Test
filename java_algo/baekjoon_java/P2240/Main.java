package baekjoon_java.P2240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][][] dp = new int[2][w + 1][t + 1];

        int start = Integer.parseInt(br.readLine()) % 2;

        if (start == 0) {
            dp[start][1][1] = 1;
        }

        if (start == 1) {
            dp[start][0][1] = 1;
        }

        for (int i = 2; i < t + 1; i++) {
            int num = Integer.parseInt(br.readLine()) % 2;
            int otherNum = (num + 1) % 2;

            dp[num][0][i] = dp[num][0][i - 1] + 1;
            dp[otherNum][0][i] = dp[otherNum][0][i - 1];
            dp[0][0][i] = 0;

            for (int j = 1; j < w + 1; j++) {
                dp[otherNum][j][i] = dp[otherNum][j][i - 1];
                dp[num][j][i] = Math.max(dp[num][j][i - 1], dp[otherNum][j - 1][i - 1]) + 1;
            }
            dp[0][0][i] = 0;
        }

        int answer = -1;

        for (int i = 0; i < t + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                answer = Math.max(answer, dp[0][j][i]);
                answer = Math.max(answer, dp[1][j][i]);
            }
        }

        System.out.println(answer);
    }
}
