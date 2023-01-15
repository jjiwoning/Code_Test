package baekjoon_java.P14502;

import java.util.*;

public class Main {

    static int[][] checked;
    static int[][] map;
    static List<int[]> list;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;
    static int m;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    list.add(new int[]{i, j});
                }
            }
        }

        answer = Integer.MIN_VALUE;
        dfs(0);

        System.out.println(answer);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>(list);
        checked = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                checked[i][j] = map[i][j];
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx < 0 || my < 0 || mx >= n || my >= m) {
                    continue;
                }
                if (checked[mx][my] == 0) {
                    queue.add(new int[]{mx, my});
                    checked[mx][my] = 2;
                }
            }
        }

        int find = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (checked[i][j] == 0) {
                    find++;
                }
            }
        }

        if (find > answer) {
            answer = find;
        }
    }

    private static void dfs(int level) {
        if (level == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(level + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
}
