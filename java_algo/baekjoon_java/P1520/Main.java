package baekjoon_java.P1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DX = new int[]{1, -1, 0, 0};
    private static final int[] DY = new int[]{0, 0, 1, -1};

    private static int n;
    private static int m;
    private static int[][] dp;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        init(br, n, m);

        System.out.println(dfs(0, 0));
    }

    private static void init(BufferedReader br, int n, int m) throws IOException {
        map = new int[n][m];
        dp = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }

    private static int dfs(int x, int y) {
        if (x == n - 1 && y == m - 1) {
            return 1;
        }
        if (visited[x][y]) {
            return dp[x][y];
        }
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int mx = x + DX[i];
            int my = y + DY[i];

            if (0 > mx || mx >= n || 0 > my || my >= m) {
                continue;
            }

            if (map[x][y] > map[mx][my]) {
                dp[x][y] += dfs(mx, my);
            }
        }

        return dp[x][y];
    }
}
