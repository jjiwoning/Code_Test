package study.week3.P67259;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 - 경주로 건설
 */
public class Solution {

    int n;
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};
    static final int STREET = 100; // 직진 가격
    static final int CORNER = 500; // 코너 가격
    boolean[][] visited;
    int[][][] totalMoney;

    public int solution(int[][] board) {
        n = board.length;
        visited = new boolean[n][n];
        totalMoney = new int[4][n][n]; // 방향별로 가격 저장할 배열 만들어주기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                totalMoney[0][i][j] = Integer.MAX_VALUE;
                totalMoney[1][i][j] = Integer.MAX_VALUE;
                totalMoney[2][i][j] = Integer.MAX_VALUE;
                totalMoney[3][i][j] = Integer.MAX_VALUE;
            }
        }
        bfs(board);
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            if (totalMoney[i][n - 1][n - 1] != 0) {
                answer = Math.min(answer, totalMoney[i][n - 1][n - 1]);
            }
        }
        return answer;
    }

    private void bfs(int[][] board) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, -1, 0)); // 시작점: 0, 0, -1, 0 -> 방향이 없어서 -1을 넣어줌
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = node.x + dx[i];
                int my = node.y + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= n || board[mx][my] == 1) {
                    // board의 범위를 벗어나는 경우 + 벽인 경우
                    continue;
                }

                int money = node.money;

                if (node.isTurn == i || node.isTurn == -1) { // 방향이 같을 때 + 시작 지점
                    money += STREET; // 100
                } else {
                    money += (STREET + CORNER); // 600
                }

                if (!visited[mx][my] || money <= totalMoney[i][mx][my]) {
                    visited[mx][my] = true; // 방문 체크
                    totalMoney[i][mx][my] = money;
                    queue.add(new Node(mx, my, i, money));
                }
            }
        }
    }

    class Node {
        int x;
        int y;
        int isTurn; // -1: start 지점, 0, 1: x축 이동, 2, 3: y축 이동 -> 이를 dx, dy 배열에 반영해야 됨
        int money;

        public Node(int x, int y, int isTurn, int money) {
            this.x = x;
            this.y = y;
            this.isTurn = isTurn;
            this.money = money;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}});
    }

}
