package baekjoon_java.P18405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int[] DX = new int[]{1, -1, 0, 0};
    private static final int[] DY = new int[]{0, 0, 1, -1};

    private static int[][] map;
    private static int n;
    private static int time;
    private static int x;
    private static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value > 0) {
                    nodes.add(new Node(i, j, value, 0));
                }
                map[i][j] = value;
            }
        }

        nodes.sort(Comparator.comparingInt(o -> o.value));

        st = new StringTokenizer(br.readLine());
        time = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken()) - 1;
        y = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(bfs(nodes));
    }

    private static int bfs(List<Node> nodes) {
        Queue<Node> queue = new LinkedList<>(nodes);

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.time >= time) {
                return map[x][y];
            }

            if (now.x == x && now.y == y) {
                return now.value;
            }

            for (int i = 0; i < 4; i++) {
                int mx = now.x + DX[i];
                int my = now.y + DY[i];

                if (mx < 0 || mx >= n || my < 0 || my >= n) {
                    continue;
                }

                if (map[mx][my] != 0) {
                    continue;
                }

                map[mx][my] = now.value;

                queue.add(new Node(mx, my, now.value, now.time + 1));
            }
        }

        return map[x][y];
    }
}

class Node {
    int x;
    int y;
    int value;
    int time;

    public Node(int x, int y, int value, int time) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.time = time;
    }
}
