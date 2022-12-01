package baekjoon_java.P1926;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int count;
    static int area;

    static int[][] painting;
    static boolean[][] visited;
    static Queue<int[]> queue;

    public static void main(String[] args) {
        // 입력부
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        painting = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                painting[i][j] = sc.nextInt();
            }
        }

        // 로직
        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (painting[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                count++;
                visited[i][j] = true;
                queue.add(new int[]{i, j});
                bfs();
            }
        }

        System.out.println(count);
        System.out.println(area);
    }

    static void bfs() {
        int nowArea = 0;
        while (!queue.isEmpty()) {
            nowArea++;
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (visited[nx][ny] || painting[nx][ny] == 0) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
        area = Math.max(area, nowArea);
    }
}
