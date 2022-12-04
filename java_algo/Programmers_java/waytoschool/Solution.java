package Programmers_java.waytoschool;

/**
 * 프로그래머스 - 등교길
 */
public class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];

        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] != -1) {
                    // 조건1. i가 0보다 크면서 이전 길이 물 웅덩이가 아닌 경우
                    if (i > 0 && dp[i - 1][j] != -1) {
                        dp[i][j] += dp[i - 1][j];
                    }
                    // 조건2. j가 0보다 크면서 이전 길이 물 웅덩이가 아닌 경우
                    if (j > 0 && dp[i][j - 1] != -1) {
                        dp[i][j] += dp[i][j - 1];
                    }
                    if (dp[i][j] > 1000000007) {
                        // 안해주면 오류남
                        dp[i][j] %= 1000000007;
                    }
                }
            }
        }
        int answer = dp[n - 1][m - 1];

        return answer;
    }
}
