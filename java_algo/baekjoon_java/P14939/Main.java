package baekjoon_java.P14939;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int answer;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] bulb = new boolean[10][10];
        visited = new boolean[10][10];

        for (int i = 0; i < 10; i++) {
            String s = br.readLine();
            for (int j = 0; j < 10; j++) {

                if (s.charAt(j) == '#') {
                    bulb[i][j] = false; // 꺼진 전구
                }
                if (s.charAt(j) == 'O') {
                    bulb[i][j] = true; // 켜진 전구
                }
            }
        }

        answer = Integer.MAX_VALUE;

        dfs(bulb, 0, 0, 0);

        System.out.println(answer);
    }

    private static void dfs(boolean[][] bulb, int count, int nIndex, int mIndex) {
        if (checkBulb(bulb)) {
            answer = Math.min(answer, count);
            return;
        }
        if (count > answer) {
            return;
        }
        if (nIndex == 10) {
            return;
        }

        if (nIndex == 0 && mIndex != 10) { // 첫 행의 인덱스에 대해서는 완탐
            changeBulbLight(bulb, nIndex, mIndex);
            dfs(bulb, count + 1, nIndex, mIndex + 1);
            changeBulbLight(bulb, nIndex, mIndex);
            dfs(bulb, count, nIndex, mIndex + 1);
        }

        if (mIndex == 10) { // m이 범위에 넘어가면 다음 줄 확인
            dfs(bulb, count, nIndex + 1, 0);
            return;
        }

        if (nIndex != 0) { // 그 다음 행에 대한 탐색
            if (bulb[nIndex - 1][mIndex]) { // 위의 전구가 켜저있다면 꺼준다.
                changeBulbLight(bulb, nIndex, mIndex);
                visited[nIndex][mIndex] = true;
                dfs(bulb, count + 1, nIndex, mIndex + 1);
                changeBulbLight(bulb, nIndex, mIndex);
            }
            if (!bulb[nIndex - 1][mIndex]) {
                dfs(bulb, count, nIndex, mIndex + 1);
            }
        }

    }

    private static boolean checkBulb(boolean[][] bulb) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (bulb[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void changeBulbLight(boolean[][] bulb, int x, int y) {
        bulb[x][y] = !bulb[x][y];
        if (x != 0) {
            bulb[x - 1][y] = !bulb[x - 1][y];
        }
        if (y != 0) {
            bulb[x][y - 1] = !bulb[x][y - 1];
        }
        if (x != 9) {
            bulb[x + 1][y] = !bulb[x + 1][y];
        }
        if (y != 9) {
            bulb[x][y + 1] = !bulb[x][y + 1];
        }
    }
}
