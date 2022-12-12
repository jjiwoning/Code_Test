package Programmers_java.triangularsnail;

/**
 * 프로그래머스 - 삼각 달팽이
 */
public class Solution {
    public int[] solution(int n) {
        int[] answer = new int[findLength(n)];
        int[][] matrix = new int[n][n];

        int x = -1;
        int y = 0;
        int number = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else if (i % 3 == 2) {
                    x--;
                    y--;
                }
                matrix[x][y] = number++;
            }
        }

        int find = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    break;
                }
                answer[find] = matrix[i][j];
                find++;
            }
        }
        return answer;
    }

    private int findLength(int n) {
        int length = 0;
        for (int i = 1; i <= n; i++) {
            length += i;
        }
        return length;
    }
}
