package study.week8.P20057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[][] mapInfo;
    static int answer;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[][] dsx = new int[][]{{-1, 1, -2, -1, 1, 2, -1, 1, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, 2}, {1, -1, 2, 1, -1, -2, 1, -1, 0}, {1, 1, 0, 0, 0, 0, -1, -1, -2}};
    static int[][] dsy = new int[][]{{1, 1, 0, 0, 0, 0, -1, -1, -2}, {-1, 1, -2, -1, 1, 2, -1, 1, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, 2}, {1, -1, 2, 1, -1, -2, 1, -1, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int startIndex = n / 2;
        mapInfo = new int[n][n];

        for (int i = 0; i < n; i++) {
            mapInfo[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        answer = 0;

        magic(startIndex);

        System.out.println(answer);
    }

    private static void magic(int startIndex) {
        int direction = 0;
        int x = startIndex;
        int y = startIndex;
        for (int i = 1; i < n; i++) {
            if (i == n - 1) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < i; k++) {
                        x += dx[direction];
                        y += dy[direction];
                        getSand(x, y, direction);
                        mapInfo[x][y] = 0;
                    }
                    direction = changeDirection(direction);
                }
                continue;
            }

            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < i; k++) {
                    x += dx[direction];
                    y += dy[direction];
                    getSand(x, y, direction);
                    mapInfo[x][y] = 0;
                }
                direction = changeDirection(direction);
            }
        }
    }

    private static int changeDirection(int direction) {
        int changeDirection = direction + 1;
        if (changeDirection == 4) {
            changeDirection = 0;
        }
        return changeDirection;
    }

    private static void getSand(int x, int y, int direction) {
        int nowSand = mapInfo[x][y];
        int sandMapOut = 0;

        // 7%
        int sand7 = (int) (nowSand * 0.07);
        int sand2 = (int) (nowSand * 0.02);
        int sand1 = (int) (nowSand * 0.01);
        int sand5 = (int) (nowSand * 0.05);
        int sand10 = (int) (nowSand * 0.1);
        int sandAlpha = nowSand - 2 * sand7 - 2 * sand2 - 2 * sand1 - sand5 - 2 * sand10;

        for (int i = 0; i < 9; i++) {
            int sand = -1;
            if (i <= 1) {
                sand = sand1;
            }
            if (i == 2 || i == 5) {
                sand = sand2;
            }
            if (i == 3 || i == 4) {
                sand = sand7;
            }
            if (i == 6 || i == 7) {
                sand = sand10;
            }
            if (i == 8) {
                sand = sand5;
            }
            if (checkAreaAndMoveSand(x + dsx[direction][i], y + dsy[direction][i], sand)) {
                sandMapOut += sand;
            }
        }

        if (checkAreaAndMoveSand(x + dx[direction], y + dy[direction], sandAlpha)) {
            sandMapOut += sandAlpha;
        }

        answer += sandMapOut;
    }

    private static boolean checkAreaAndMoveSand(int x, int y, int sand) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return true;
        }

        mapInfo[x][y] += sand;

        return false;
    }
}
