package baekjoon_java.P3197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int r;
    private static int c;
    private static Queue<Node> queue;
    private static Queue<Node> meltingQueue;
    private static char[][] map;
    private static int[][] cost;
    private static boolean[][] visited1;
    private static boolean[][] visited2;
    private static final int[] dx = new int[]{1, -1, 0, 0};
    private static final int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        cost = new int[r][c];
        visited1 = new boolean[r][c];
        visited2 = new boolean[r][c];

        queue = new LinkedList<>();
        meltingQueue = new LinkedList<>();

        int type = 1;

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'L') {
                    queue.add(new Node(i, j, type++));
                    map[i][j] = '.';
                }
            }
        }

        bfs();
        System.out.println(meltIce());
    }

    private static boolean bfs() {
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = now.x + dx[i];
                int my = now.y + dy[i];

                if (mx < 0 || mx >= r || my < 0 || my >= c) {
                    continue;
                }

                if (map[mx][my] == 'X') {
                    if (now.type == 1) {
                        if (visited1[mx][my]) {
                            continue;
                        }
                        visited1[mx][my] = true;
                    }
                    if (now.type == 2) {
                        if (visited2[mx][my]) {
                            continue;
                        }
                        visited2[mx][my] = true;
                    }
                    map[mx][my] = '.';
                    meltingQueue.add(new Node(mx, my, now.type));
                    continue;
                }

                if (now.type == 1) {
                    if (visited2[mx][my]) {
                        return true;
                    }
                    if (visited1[mx][my]) {
                        continue;
                    }
                    visited1[mx][my] = true;
                }

                if (now.type == 2) {
                    if (visited1[mx][my]) {
                        return true;
                    }
                    if (visited2[mx][my]) {
                        continue;
                    }
                    visited2[mx][my] = true;
                }

                queue.add(new Node(mx, my, now.type));
            }
        }

        return false;
    }

    private static int meltIce() {
        int cnt = 0;
        while (true) {
            int size = meltingQueue.size();
            for (int cycle = 0; cycle < size; cycle++) {
                Node now = meltingQueue.poll();

                for (int i = 0; i < 4; i++) {
                    int mx = now.x + dx[i];
                    int my = now.y + dy[i];

                    if (mx < 0 || mx >= r || my < 0 || my >= c) {
                        continue;
                    }

                    if (now.type == 1) {
                        if (visited2[mx][my]) {
                            return cost[mx][my] + 1;
                        }
                        if (visited1[mx][my]) {
                            continue;
                        }
                    }

                    if (now.type == 2) {
                        if (visited1[mx][my]) {
                            return cost[mx][my] + 1;
                        }
                        if (visited2[mx][my]) {
                            continue;
                        }
                    }

                    if (map[mx][my] == '.' && !visited1[mx][my] && !visited2[mx][my]) {
                        cost[mx][my] = cnt + 1;
                        meltingQueue.add(new Node(mx, my, now.type));
                    }

                    if (map[mx][my] == 'X') {
                        if (now.type == 1) {
                            visited1[mx][my] = true;
                            map[mx][my] = '.';
                            cost[mx][my] = cnt + 1;
                            meltingQueue.add(new Node(mx, my, now.type));
                        }
                        if (now.type == 2) {
                            visited2[mx][my] = true;
                            map[mx][my] = '.';
                            cost[mx][my] = cnt + 1;
                            meltingQueue.add(new Node(mx, my, now.type));
                        }
                    }
                }
            }
            cnt++;
        }
    }
}

class Node {
    int x;
    int y;
    int type; // 1, 2

    public Node(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}