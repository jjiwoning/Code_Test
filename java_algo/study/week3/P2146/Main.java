package study.week3.P2146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int answer;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int mark;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        answer = Integer.MAX_VALUE;

        mark = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j)) {
                    mark--;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    visited = new boolean[n][n];
                    bfs(new Node(i, j, map[i][j], 0));
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean dfs(int x, int y) { // 같은 섬 찾는 용도의 dfs

        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }

        if (!visited[x][y] && map[x][y] == 1) {
            visited[x][y] = true;
            map[x][y] = mark;
            for (int i = 0; i < 4; i++) {
                dfs(x + dx[i], y + dy[i]);
            }
            return true;
        }

        return false;
    }

    private static void bfs(Node node) { // 최단 거리 구할 용도의 bfs

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited[node.x][node.y] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.distance >= answer) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int mx = now.x + dx[i];
                int my = now.y + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= n) {
                    continue;
                }

                if (map[mx][my] != 0 && map[mx][my] != now.mark) {
                    answer = Math.min(answer, now.distance);
                    return;
                }

                if (!visited[mx][my]) {
                    if (map[mx][my] == 0) {
                        visited[mx][my] = true;
                        queue.add(new Node(mx, my, now.mark, now.distance + 1));
                    } else {
                        visited[mx][my] = true;
                        queue.add(new Node(mx, my, now.mark, now.distance));
                    }
                }
            }

        }
    }

    static class Node {
        int x;
        int y;
        int mark;
        int distance;

        public Node(int x, int y, int mark, int distance) {
            this.x = x;
            this.y = y;
            this.mark = mark;
            this.distance = distance;
        }
    }
}
