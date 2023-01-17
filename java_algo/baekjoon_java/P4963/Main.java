package baekjoon_java.P4963;

import java.util.Scanner;

public class Main {

    static int[][] map;
    static boolean[][] checked;
    static int answer;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            m = sc.nextInt();
            n = sc.nextInt();

            if (n == 0 && m == 0) {
                break;
            }

            map = new int[n][m];
            checked = new boolean[n][m];
            answer = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = sc.nextInt();
                }
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
        if (map[x][y] == 1 && !checked[x][y]) {
            checked[x][y] = true;
            dfs(x + 1, y);
            dfs(x - 1, y);
            dfs(x, y + 1);
            dfs(x, y - 1);
            dfs(x + 1, y - 1);
            dfs(x + 1, y + 1);
            dfs(x - 1, y + 1);
            dfs(x - 1, y - 1);
            return true;
        }
        return false;
    }
}
