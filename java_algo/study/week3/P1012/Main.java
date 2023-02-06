package study.week3.P1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            String[] s = br.readLine().split(" ");
            n = Integer.parseInt(s[1]);
            m = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[2]);
            int answer = 0;
            map = new int[n][m];
            visited = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                String[] s1 = br.readLine().split(" ");
                int x = Integer.parseInt(s1[1]);
                int y = Integer.parseInt(s1[0]);
                map[x][y] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dfs(i, j)) {
                        answer++;
                    }
                }
            }

            System.out.println(answer);

        }
    }

    private static boolean dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        if (!visited[x][y] && map[x][y] == 1) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                dfs(x + dx[i], y + dy[i]);
            }
            return true;
        }
        return false;
    }
}
