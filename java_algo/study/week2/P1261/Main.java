package study.week2.P1261;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] arr;
    static boolean[][] visited;
    static int x;
    static int y;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        y = sc.nextInt();
        x = sc.nextInt();

        arr = new int[x][y];
        visited = new boolean[x][y];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < x; i++) {
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(answer);
    }

    private static void bfs() {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        queue.add(new int[]{0, 0, 0}); // x, y, 부순 벽
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == x - 1 && poll[1] == y - 1) {
                answer = poll[2];
                return;
            }
            for (int i = 0; i < 4; i++) {
                int mx = poll[0] + dx[i];
                int my = poll[1] + dy[i];
                if (mx < 0 || mx >= x || my < 0 || my >= y) {
                    continue;
                }
                if (!visited[mx][my]) {
                    visited[mx][my] = true;
                    if (arr[mx][my] == 1) {
                        queue.add(new int[]{mx, my, poll[2] + 1});
                    } else {
                        queue.add(new int[]{mx, my, poll[2]});
                    }
                }
            }
        }
    }
}
