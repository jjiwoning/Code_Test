package study.week3.P1189;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int m;
    static int k;
    static int[][] map;
    static boolean[][] visited;
    static int answer;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        map = new int[n][m];
        visited = new boolean[n][m];
        answer = 0;

        for (int i = 0; i < n; i++) {
            String s1 = br.readLine();
            for (int j = 0; j < m; j++) {
                if (s1.charAt(j) == '.') {
                    map[i][j] = 0;
                }
                if (s1.charAt(j) == 'T') {
                    map[i][j] = 1;
                }
            }
        }

        visited[n - 1][0] = true;
        dfs(n - 1, 0, 1);

        System.out.println(answer);
    }

    private static void dfs(int x, int y, int level) {
        if (x == 0 && y == m - 1) {
            if (level == k) {
                answer++;
            }
            return;
        }

        if (x < 0 || x >= n || y < 0 || y >= m) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            if (mx < 0 || mx >= n || my < 0 || my >= m) {
                continue;
            }

            if (!visited[mx][my] && map[mx][my] == 0) {
                visited[mx][my] = true;
                dfs(mx, my, level + 1);
                visited[mx][my] = false;
            }
        }
    }

}
