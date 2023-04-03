package study.week11.P1832;

public class Solution {

    static final int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[2][m + 1][n + 1]; // 0: 가로 직진, 1: 세로 직진
        int[][] newCityMap = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                newCityMap[i][j] = cityMap[i - 1][j - 1];
            }
        }

        for (int i = 2; i < n + 1; i++) {
            if (newCityMap[1][i] == 1) {
                break;
            }
            dp[0][1][i] = 1;
        }

        for (int i = 2; i < m + 1; i++) {
            if (newCityMap[i][1] == 1) {
                break;
            }
            dp[1][i][1] = 1;
        }


        for (int i = 2; i < m + 1; i++) {
            for (int j = 2; j < n + 1; j++) {
                if (newCityMap[i][j] == 1) { // 자동차의 통행이 금지된 경우
                    dp[1][i][j] = 0;
                    dp[0][i][j] = 0;
                    continue;
                }

                if (newCityMap[i - 1][j] == 2) { // 꺾는거 불가능
                    dp[1][i][j] = dp[1][i - 1][j] % MOD;
                    dp[1][i][j] %= MOD;
                }

                if (newCityMap[i - 1][j] == 0) {
                    dp[1][i][j] = dp[1][i - 1][j] % MOD + dp[0][i - 1][j] % MOD;
                    dp[1][i][j] %= MOD;
                }

                if (newCityMap[i][j - 1] == 2) { // 꺾는거 불가능
                    dp[0][i][j] = dp[0][i][j - 1] % MOD;
                    dp[0][i][j] %= MOD;
                }

                if (newCityMap[i][j - 1] == 0) {
                    dp[0][i][j] = (dp[0][i][j - 1] % MOD + dp[1][i][j - 1] % MOD) % MOD;
                    dp[0][i][j] %= MOD;
                }
            }
        }

        return (dp[0][m][n] % MOD + dp[1][m][n] % MOD) % MOD;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, 6, new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}));
    }
}
