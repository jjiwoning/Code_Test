package baekjoon_java.P1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] mapInfo;
    static int[] dx = new int[]{-1, 0, 1, 0, -2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = new int[]{0, 1, 0, -1, 1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        mapInfo = new int[n][m];

        for (int i = 0; i < n; i++) {
            mapInfo[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        if (m == 1 && n == 1) {
            System.out.println(0);
            return;
        }

        System.out.println(bfs(count));
    }

    private static int bfs(int count) {
        Queue<Monkey> queue = new LinkedList<>();
        queue.add(new Monkey(0, 0, 0, 0));
        boolean[][][] visited = new boolean[count + 1][n][m];
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Monkey monkey = queue.poll();

            for (int i = 0; i < 12; i++) {

                int mx = monkey.x + dx[i];
                int my = monkey.y + dy[i];

                if (mx < 0 || my < 0 || mx >= n || my >= m) {
                    continue;
                }

                if (mapInfo[mx][my] == 1) {
                    continue;
                }

                if (i >= 4 && monkey.count == count) {
                    break;
                }

                if (mx == n - 1 && my == m - 1) {
                    return monkey.move + 1;
                }

                if (i >= 4) {
                    if (!visited[monkey.count + 1][mx][my]) {
                        visited[monkey.count + 1][mx][my] = true;
                        queue.add(new Monkey(mx, my, monkey.count + 1, monkey.move + 1));
                    }
                    continue;
                }

                if (!visited[monkey.count][mx][my]) {
                    visited[monkey.count][mx][my] = true;
                    queue.add(new Monkey(mx, my, monkey.count, monkey.move + 1));
                }
            }
        }

        return -1;
    }

    static class Monkey {
        int x;
        int y;
        int count;
        int move;

        public Monkey(int x, int y, int count, int move) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.move = move;
        }
    }
}

