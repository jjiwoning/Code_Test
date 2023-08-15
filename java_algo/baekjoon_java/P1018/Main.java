package baekjoon_java.P1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                answer = Math.min(answer, findBoardColorChangedCount(i, j, board));
            }
        }

        System.out.println(answer);
    }

    private static int findBoardColorChangedCount(int startX, int startY, char[][] board) {
        char color = board[startX][startY];
        int count = 0;

        for (int i = startX; i < startX + 8; i++) {
            for (int j = startY; j < startY + 8; j++) {
                if (board[i][j] != color) {
                    count++;
                }
                color = colorChange(color);
            }
            color = colorChange(color);
        }

        return Math.min(count, 64 - count);
    }

    private static char colorChange(char color) {
        if (color == 'B') {
            return 'W';
        }

        if (color == 'W') {
            return 'B';
        }

        throw new IllegalStateException("예외");
    }
}
