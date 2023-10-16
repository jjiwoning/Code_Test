package baekjoon_java.P18430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int[] DX = new int[]{1, -1, -1, 1};
    private static final int[] DY = new int[]{-1, -1, 1, 1};

    private static int n;
    private static int m;
    private static int[][] woods;
    private static boolean[][] visited;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (n == 1 || m == 1) {
            System.out.println(0);
            return;
        }

        woods = new int[n][m];
        visited = new boolean[n][m];
        answer = 0;

        for (int i = 0; i < n; i++) {
            woods[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(0, 0, 0);

        System.out.println(answer);
    }

    private static void dfs(int x, int y, int sum) {
        answer = Math.max(answer, sum);

        if (y == m) {
            y = 0;
            x++;
        }
        if (x == n) {
            return;
        }
        if (visited[x][y]) {
            dfs(x, y + 1, sum);
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int x1 = x + DX[i];
            int y1 = y + DY[i];

            if (0 > x1 || x1 >= n || 0 > y1 || y1 >= m) {
                continue;
            }

            if (visited[x1][y] || visited[x][y1]) {
                continue;
            }

            int makeSum = 2 * woods[x][y] + woods[x1][y] + woods[x][y1];
            visited[x1][y] = true;
            visited[x][y1] = true;

            dfs(x, y + 1, sum + makeSum);

            visited[x1][y] = false;
            visited[x][y1] = false;
        }

        visited[x][y] = false;
        dfs(x, y + 1, sum);
    }
}
