package baekjoon_java.P14442;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int k;
    static int[][] mapInfo;
    static boolean[][][] visited;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        mapInfo = new int[n][m];
        visited = new boolean[k + 1][n][m]; // 0 벽 안 부심, 1 벽 부심

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

        System.out.println(bfs(0, 0, k));
    }

    private static int bfs(int x, int y, int maxWall) {

        Queue<Person> queue = new LinkedList<>();
        queue.add(new Person(x, y, 0, maxWall));
        visited[maxWall][x][y] = true;

        while (!queue.isEmpty()) {
            Person now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = now.x + dx[i];
                int my = now.y + dy[i];
                int wallCount = now.wallCount;

                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    continue;
                }

                if (mx == n - 1 && my == m - 1) {
                    return now.distance + 2;
                }

                if (visited[wallCount][mx][my]) {
                    continue;
                }

                if (mapInfo[mx][my] == 1 && wallCount > 0 && !visited[wallCount - 1][mx][my]) {
                    visited[wallCount - 1][mx][my] = true;
                    queue.add(new Person(mx, my, now.distance + 1, wallCount - 1));
                }

                if (mapInfo[mx][my] == 0) {
                    visited[wallCount][mx][my] = true;
                    queue.add(new Person(mx, my, now.distance + 1, wallCount));
                }
            }
        }

        return -1;
    }

    private static class Person {
        int x;
        int y;
        int distance;
        int wallCount;

        public Person(int x, int y, int distance, int wallBroken) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.wallCount = wallBroken;
        }
    }
}
