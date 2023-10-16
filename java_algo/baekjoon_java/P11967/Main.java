package baekjoon_java.P11967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private final static int[] DX = new int[]{1, -1, 0, 0};
    private final static int[] DY = new int[]{0, 0, 1, -1};

    private static int n;
    private static boolean[][] visited;
    private static boolean[][] isTurnOn;
    private static Map<Node, List<Node>> switches;

    private static int checkX;
    private static int checkY;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][n];
        isTurnOn = new boolean[n][n];
        switches = new HashMap<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            Node node = new Node(x1, y1);

            if (!switches.containsKey(node)) {
                switches.put(node, new ArrayList<>());
            }

            switches.get(node).add(new Node(x2, y2));
        }

        answer = 0;

        bfs();


        for (boolean[] turnOns : isTurnOn) {
            for (boolean turnOn : turnOns) {
                if (turnOn) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        visited[0][0] = true;
        isTurnOn[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (switches.containsKey(node)) {
                List<Node> turnOnNodes = switches.get(node);

                for (Node turnOnNode : turnOnNodes) {
                    if (isTurnOn[turnOnNode.x][turnOnNode.y]) {
                        continue;
                    }
                    isTurnOn[turnOnNode.x][turnOnNode.y] = true;
                    if (checkAround(turnOnNode.x, turnOnNode.y)) {
                        queue.add(new Node(checkX, checkY));
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int mx = node.x + DX[i];
                int my = node.y + DY[i];

                if (mx < 0 || mx >= n || my < 0 || my >= n) {
                    continue;
                }

                if (!isTurnOn[mx][my]) {
                    continue;
                }

                if (visited[mx][my]) {
                    continue;
                }

                visited[mx][my] = true;
                queue.add(new Node(mx, my));
            }
        }
    }

    private static boolean checkAround(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int mx = x + DX[i];
            int my = y + DY[i];

            if (mx < 0 || mx >= n || my < 0 || my >= n) {
                continue;
            }

            if (isTurnOn[mx][my] && visited[mx][my]) {
                checkX = mx;
                checkY = my;
                return true;
            }
        }

        return false;
    }
}

class Node {

    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
