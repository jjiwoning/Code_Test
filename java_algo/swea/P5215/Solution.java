package swea.P5215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = parseInt(br.readLine());

        for (int testCase = 1; testCase < t + 1; testCase++) {
            st = new StringTokenizer(br.readLine());
            int n = parseInt(st.nextToken());
            int l = parseInt(st.nextToken());
            int[][] dp = new int[n + 1][l + 1];

            for (int i = 1; i < n + 1; i++) {
                st = new StringTokenizer(br.readLine());
                int score = parseInt(st.nextToken());
                int calorie = parseInt(st.nextToken());

                for (int j = 0; j < l + 1; j++) {
                    if (j < calorie) {
                        dp[i][j] = dp[i - 1][j];
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i - 1][j - calorie] + score, dp[i - 1][j]);
                }
            }

            System.out.println("#" + testCase + " " + dp[n][l]);

        }
    }
}
