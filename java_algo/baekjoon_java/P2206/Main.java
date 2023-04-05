package baekjoon_java.P2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] mapInfo;
    static boolean[][][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        mapInfo = new int[n][m];
        visited = new boolean[2][n][m]; // 0 벽 안 부심, 1 벽 부심

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                mapInfo[i][j] = s.charAt(j) - '0';
            }
        }

        if (n == 1 && m == 1) {
            System.out.println(1);
            return;
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int x, int y) {

        Queue<Person> queue = new LinkedList<>();
        queue.add(new Person(x, y, 0, false));
        visited[0][x][y] = true;

        while (!queue.isEmpty()) {
            Person now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = now.x + dx[i];
                int my = now.y + dy[i];
                boolean wallBreak = now.wallBroken;

                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    continue;
                }

                if (mx == n - 1 && my == m - 1) {
                    return now.distance + 2;
                }

                if (wallBreak) { // 벽 부심
                    if (visited[1][mx][my]) {
                        continue;
                    }
                    if (mapInfo[mx][my] == 1) {
                        continue;
                    }
                    visited[1][mx][my] = true;
                    queue.add(new Person(mx, my, now.distance + 1, wallBreak));
                }

                if (!wallBreak) { // 벽 안 부심
                    if (visited[0][mx][my]) {
                        continue;
                    }
                    if (mapInfo[mx][my] == 0) {
                        visited[0][mx][my] = true;
                        queue.add(new Person(mx, my, now.distance + 1, wallBreak));
                    }
                    if (mapInfo[mx][my] == 1) {
                        visited[1][mx][my] = true;
                        queue.add(new Person(mx, my, now.distance + 1, !wallBreak));
                    }
                }
            }
        }

        return -1;
    }

    private static class Person {
        int x;
        int y;
        int distance;
        boolean wallBroken;

        public Person(int x, int y, int distance, boolean wallBroken) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.wallBroken = wallBroken;
        }
    }
}
