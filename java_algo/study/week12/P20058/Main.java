package study.week12.P20058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;
import static java.util.Arrays.*;

public class Main {

    static int n;
    static int[][] arr;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static boolean[][] visited;
    static int ice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int query = Integer.parseInt(st.nextToken());

        arr = new int[(int) pow(2, n)][(int) pow(2, n)];

        for (int i = 0; i < pow(2, n); i++) {
            arr[i] = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < query; i++) {
            int command = Integer.parseInt(st.nextToken());
            move(command);
        }

        visited = new boolean[(int) pow(2, n)][(int) pow(2, n)];
        int sum = 0;
        int answer = 0;
        for (int i = 0; i < pow(2, n); i++) {
            for (int j = 0; j < pow(2, n); j++) {
                sum += arr[i][j];
            }
        }

        for (int i = 0; i < pow(2, n); i++) {
            for (int j = 0; j < pow(2, n); j++) {
                if (!visited[i][j] && arr[i][j] != 0) {
                    ice = 1;
                    dfs(i, j);
                    answer = Math.max(ice, answer);
                }
            }
        }

        System.out.println(sum);
        System.out.println(answer);
    }

    private static void move(int command) {

        int size = (int) pow(2, command);
        int[][] copyMap = copyMap();

        if (command != 0) {
            for (int i = 0; i < pow(2, n); i += size) {
                for (int j = 0; j < pow(2, n); j += size) {
                    rotate(i, j, size, copyMap);
                }
            }
        }

        int[][] meltMap = copyMap();
        arr = meltIce(meltMap);
    }

    private static void rotate(int x, int y, int size, int[][] copyMap) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[x + j][y + size - i - 1] = copyMap[x + i][y + j];
            }
        }
    }

    private static int[][] copyMap() {
        int[][] copy = new int[(int) pow(2, n)][(int) pow(2, n)];
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy.length; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }

    private static int[][] meltIce(int[][] meltMap) {
        for (int i = 0; i < meltMap.length; i++) {
            for (int j = 0; j < meltMap.length; j++) {
                int count = 0;
                if (arr[i][j] == 0) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int mx = i + dx[k];
                    int my = j + dy[k];
                    if (mx < 0 || mx >= pow(2, n) || my < 0 || my >= pow(2, n)) {
                        continue;
                    }
                    if (arr[mx][my] > 0) {
                        count++;
                    }
                }
                if (count < 3) {
                    meltMap[i][j]--;
                }
            }
        }
        return meltMap;
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx < 0 || mx >= pow(2, n) || my < 0 || my >= pow(2, n)) {
                continue;
            }
            if (visited[mx][my]) {
                continue;
            }
            if (arr[mx][my] == 0) {
                continue;
            }
            visited[mx][my] = true;
            dfs(mx, my);
            ice++;
        }
    }
}
