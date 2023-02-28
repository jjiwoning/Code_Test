package study.week7.P4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        StringTokenizer st;
        int count = 1;

        while (true) {
            n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            map = new int[n][n];
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            answer.append("Problem").append(" ").append(count++).append(":").append(" ").append(bfs()).append("\n");
        }

        System.out.println(answer);
    }

    private static int bfs() {
        PriorityQueue<Zelda> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        priorityQueue.add(new Zelda(0, 0, map[0][0]));
        visited[0][0] = true;

        while (!priorityQueue.isEmpty()) {
            Zelda nowZelda = priorityQueue.poll();

            if (nowZelda.x == n - 1 && nowZelda.y == n - 1) {
                return nowZelda.cost;
            }

            for (int i = 0; i < 4; i++) {
                int mx = nowZelda.x + dx[i];
                int my = nowZelda.y + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= n) {
                    continue;
                }

                if (visited[mx][my]) {
                    continue;
                }

                visited[mx][my] = true;
                priorityQueue.add(new Zelda(mx, my, nowZelda.cost + map[mx][my]));
            }
        }

        throw new IllegalArgumentException();
    }

    static class Zelda {
        int x;
        int y;
        int cost;

        public Zelda(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
