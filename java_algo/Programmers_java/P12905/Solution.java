package Programmers_java.P12905;

import static java.lang.Math.*;

public class Solution {
    public int solution(int [][]board) {
        int[][] dp = new int[board.length + 1][board[0].length + 1];

        int answer = 0;

        for (int i = 1; i < board.length + 1; i++) {
            for (int j = 1; j < board[0].length + 1; j++) {
                if (board[i - 1][j - 1] == 1) {
                    dp[i][j] = min(dp[i - 1][j], min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    answer = max(answer, dp[i][j]);
                }
            }
        }

        return answer * answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}});
    }
}
