package Programmers_java.RotateMatrixBorders;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 - 행렬 테두리 회전하기
 */
public class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (i * columns) + (j + 1);
            }
        }

        int index = 0;
        for (int[] query : queries) {
            answer[index++] = rotate(query[0] - 1, query[2] - 1, query[1] - 1, query[3] - 1, matrix);
        }

        return answer;
    }

    private int rotate(int startX, int endX, int startY, int endY, int[][] matrix) {
        int minValue = matrix[startX][startY];
        Queue<Integer> tempQueue = new LinkedList<>();
        tempQueue.add(matrix[startX][startY]);
        int x = startX;
        int y = startY + 1;

        while (true) {

            minValue = Math.min(minValue, matrix[x][y]);
            tempQueue.add(matrix[x][y]);
            matrix[x][y] = tempQueue.poll();

            if (x == startX && y == startY) {
                break;
            }

            if (x == startX && y < endY) {
                y++;
            } else if (y == endY && x < endX) {
                x++;
            } else if (x == endX && y > startY) {
                y--;
            } else if (x > startX  && y == startY) {
                x--;
            }
        }

        return minValue;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] queries = new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        sol.solution(6, 6, queries);
    }
}
