package Programmers_java.quadcompression;

public class Solution {

    static int zero = 0;
    static int one = 0;

    public int[] solution(int[][] arr) {
        int[] answer = new int[2]; // 0의 개수, 1의 개수
        dfs(arr, 0, arr.length, 0, arr[0].length);
        answer[0] = zero;
        answer[1] = one;
        return answer;
    }

    private void dfs(int[][] arr, int startX, int endX, int startY, int endY) {
        int value = arr[startX][startY];

        if (isSame(arr, startX, endX, startY, endY)) {
            if (value == 0) {
                zero++;
            }
            if (value == 1) {
                one++;
            }
            return;
        }

        dfs(arr, startX, (startX+endX) / 2, startY, (startY+endY) / 2);
        dfs(arr, startX, (startX+endX) / 2, (startY+endY) / 2, endY);
        dfs(arr, (startX+endX) / 2, endX, startY, (startY+endY) / 2);
        dfs(arr, (startX+endX) / 2, endX, (startY+endY) / 2, endY);
    }

    private boolean isSame(int[][] arr, int startX, int endX, int startY, int endY) {
        int number = arr[startX][startY];
        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                if (arr[i][j] != number) {
                    return false;
                }
            }
        }
        return true;
    }
}
