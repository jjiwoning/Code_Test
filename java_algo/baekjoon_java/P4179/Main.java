package baekjoon_java.P4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n;
    private static int m;
    private static char[][] miro;
    private static boolean[][] visited;
    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        miro = new char[n][m];
        visited = new boolean[n][m];

        Node jihoon = null;
        List<Node> fire = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            miro[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (miro[i][j] == 'J') {
                    jihoon = new Node(i, j, 0, miro[i][j]);
                }
                if (miro[i][j] == 'F') {
                    Node node = new Node(i, j, 0, miro[i][j]);
                    fire.add(node);
                }
            }
        }

        Queue<Node> queue = new LinkedList<>(fire);
        queue.add(jihoon);

        int answer = bfs(queue);

        if (answer == -1) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        System.out.println(answer);
    }

    private static int bfs(Queue<Node> queue) {
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = now.x + dx[i];
                int my = now.y + dy[i];

                if (0 > mx || mx >= n || 0 > my || my >= m) {
                    if (now.type == 'J') {
                        return now.moveCount + 1;
                    }
                    continue;
                }

                if (visited[mx][my]) {
                    continue;
                }

                if (miro[mx][my] == 'F' || miro[mx][my] == '#') {
                    continue;
                }

                if (now.type == 'J') {
                    visited[mx][my] = true;
                }

                if (now.type == 'F') {
                    miro[mx][my] = 'F';
                }

                queue.add(new Node(mx, my, now.moveCount + 1, now.type));
            }
        }

        return -1;
    }
}

class Node {
    int x;
    int y;
    int moveCount;
    char type;

    public Node(int x, int y, int moveCount, char type) {
        this.x = x;
        this.y = y;
        this.moveCount = moveCount;
        this.type = type;
    }
}
