package study.week8.P15684;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

/**
 * 삼성 기출 - 사다리 조작
 */
public class Main {

    static int n;
    static int h;
    static int answer;
    static int[][] ladderInfo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());
        h = parseInt(st.nextToken());

        ladderInfo = new int[2 * n - 1][h];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            ladderInfo[b * 2 - 1][a - 1] = 1;
        }

        for (int i = 0; i < 2 * n - 1; i += 2) {
            for (int j = 0; j < h; j++) {
                ladderInfo[i][j] = 1;
            }
        }

        answer = -1;

        for (int i = 0; i <= 3; i++) {
            setLadder(i, 0, 1, 0);
            if (answer != -1) {
                break;
            }
        }
        System.out.println(answer);
    }

    private static void setLadder(int maxLadder, int nowLadder, int x, int y) {
        if (nowLadder == maxLadder) {
            validLadder(maxLadder);
            return;
        }

        for (int i = x; i < 2 * n - 1; i += 2) {
            if (x < i) {
                y = 0;
            }
            for (int j = y; j < h; j++) {
                if (canLadder(i, j)) {
                    ladderInfo[i][j] = 1;
                    setLadder(maxLadder, nowLadder + 1, i, j);
                    ladderInfo[i][j] = 0;
                }
            }
        }
    }

    private static boolean canLadder(int x, int y) {
        if (ladderInfo[x][y] == 1) {
            return false;
        }
        if (x != 1 && ladderInfo[x - 2][y] == 1) {
            return false;
        }
        if (x != 2 * n - 3 && ladderInfo[x + 2][y] == 1) {
            return false;
        }
        return true;
    }

    private static void validLadder(int ladder) {
        for (int i = 0; i < 2 * n - 1; i += 2) {
            int x = i;
            int y = 0;
            boolean[][] visited = new boolean[2 * n - 1][h];
            visited[x][y] = true;
            while (y < h) {
                visited[x][y] = true;
                if (x > 0 && ladderInfo[x - 1][y] == 1 && !visited[x - 2][y] && !visited[x - 1][y]) {
                    visited[x - 1][y] = true;
                    x -= 2;
                    visited[x][y] = true;
                    continue;
                }
                if (x < 2 * n - 2 && ladderInfo[x + 1][y] == 1 && !visited[x + 2][y] && !visited[x + 1][y]) {
                    visited[x + 1][y] = true;
                    x += 2;
                    visited[x][y] = true;
                    continue;
                }
                y++;
            }
            if (x != i) {
                return;
            }
        }
        answer = ladder;
    }
}
