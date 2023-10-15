package baekjoon_java.P11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int[] DX = new int[]{1, -1, 0, 0};
    private static final int[] DY = new int[]{0, 0, 1, -1};

    private static char[][] gameBoard;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        gameBoard = new char[12][6];

        for (int i = 0; i < 12; i++) {
            gameBoard[i] = br.readLine().toCharArray();
        }

        int answer = 0;

        while (true) {
            visited = new boolean[12][6];

            int count = 0;

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (gameBoard[i][j] != '.' && !visited[i][j]) {
                        count += bfs(i, j, gameBoard[i][j]);
                    }
                }
            }

            arrangeGameBoard();

            if (count == 0) {
                System.out.println(answer);
                return;
            }

            answer++;
        }
    }

    private static int bfs(int x, int y, char target) {
        Queue<Node> queue = new LinkedList<>();
        List<Node> targets = new ArrayList<>();
        Node node = new Node(x, y);
        targets.add(node);
        queue.add(node);
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = now.x + DX[i];
                int my = now.y + DY[i];

                if (mx < 0 || mx >= 12 || my < 0 || my >= 6) {
                    continue;
                }

                if (visited[mx][my] || gameBoard[mx][my] != target) {
                    continue;
                }

                visited[mx][my] = true;
                targets.add(new Node(mx, my));
                queue.add(new Node(mx, my));
            }
        }

        if (targets.size() >= 4) {
            clearGameBoard(targets);
            return targets.size();
        }

        return 0;
    }

    private static void clearGameBoard(List<Node> nodes) {
        for (Node node : nodes) {
            gameBoard[node.x][node.y] = '.';
        }
    }

    private static void arrangeGameBoard() {
        for (int y = 0; y < 6; y++) {
            Stack<Character> stack = new Stack<>();
            for (int x = 0; x < 12; x++) {
                if (gameBoard[x][y] != '.') {
                    stack.add(gameBoard[x][y]);
                    gameBoard[x][y] = '.';
                }
            }
            int index = 11;
            while (!stack.isEmpty()) {
                gameBoard[index--][y] = stack.pop();
            }
        }
    }

}

class Node {

    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
