package study.week4.P2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] arr;
    static int whiteCount;
    static int blueCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        whiteCount = 0;
        blueCount = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(0, 0, n);

        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    private static void dfs(int x, int y, int length) {
        if (checkColor(x, y, length)) {
            if (arr[x][y] == 0) {
                whiteCount++;
                return;
            }
            if (arr[x][y] == 1) {
                blueCount++;
                return;
            }
        }

        int divLength = length / 2;

        dfs(x, y, divLength);
        dfs(x + divLength, y, divLength);
        dfs(x, y + divLength, divLength);
        dfs(x + divLength, y + divLength, divLength);

    }

    private static boolean checkColor(int x, int y, int length) {
        int start = arr[x][y];

        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (arr[i][j] != start) {
                    return false;
                }
            }
        }

        return true;
    }
}
