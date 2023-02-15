package study.week4.P1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] papers;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        papers = new int[n][n];

        for (int i = 0; i < n; i++) {
            papers[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        answer = new int[3]; // 0 -> 0, 1 -> 1, -1 -> 2

        findPaper(0, 0, n);

        System.out.println(answer[2]);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    private static void findPaper(int x, int y, int size) {
        int startPaper = papers[x][y];

        if (isSame(x, y, size)) {
            if (startPaper == -1) {
                answer[2]++;
                return;
            }
            answer[startPaper]++;
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                findPaper(x + i * newSize, y + j * newSize, newSize);
            }
        }
    }

    private static boolean isSame(int x, int y, int size) {
        int startPaper = papers[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (startPaper != papers[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
