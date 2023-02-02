package study.week3.P67259;

import java.util.PriorityQueue;

/**
 * 프로그래머스 - 경주로 건설
 */
public class SolutionFail {

    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};
    final int STREET = 100;
    final int CORNER = 500;

    public int solution(int[][] board) {
        int[][] downBoard = new int[board.length][board.length];
        int[][] rightBoard = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, downBoard[i], 0, board[i].length);
        }
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, rightBoard[i], 0, board[i].length);
        }
        bfsDown(downBoard);
        bfsRight(rightBoard);
        return Math.min(downBoard[board.length - 1][board.length - 1], rightBoard[board.length - 1][board.length - 1]);
    }

    private void bfsRight(int[][] board) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.money - o2.money);
        priorityQueue.add(new Node(0, 1, true, STREET));
        board[0][1] = STREET;

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            for (int i = 0; i < 4; i++) {

                int mx = node.x + dx[i];
                int my = node.y + dy[i];

                if (mx < 0 || mx >= board.length || my < 0 || my >= board.length) {
                    continue;
                }

                if (board[mx][my] != 0) {
                    continue;
                }

                if (i < 2) {
                    // x축이 움직이는 경우 -> false
                    if (node.isTurn) {
                        // 코너 생성
                        board[mx][my] = node.money + STREET + CORNER;
                        priorityQueue.add(new Node(mx, my, false, node.money + STREET + CORNER));
                    }
                    if (!node.isTurn) {
                        //직진
                        board[mx][my] = node.money + STREET;
                        priorityQueue.add(new Node(mx, my, false, node.money + STREET));
                    }

                    continue;
                }

                // y축이 움직이는 경우 -> true
                if (node.isTurn) {
                    //직진
                    board[mx][my] = node.money + STREET;
                    priorityQueue.add(new Node(mx, my, true, node.money + STREET));
                }
                if (!node.isTurn) {
                    //코너 생성
                    board[mx][my] = node.money + STREET + CORNER;
                    priorityQueue.add(new Node(mx, my, true, node.money + STREET + CORNER));
                }
            }
        }
    }

    private void bfsDown(int[][] board) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.money - o2.money);
        priorityQueue.add(new Node(1, 0, false, STREET));
        board[1][0] = STREET;

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            for (int i = 0; i < 4; i++) {

                int mx = node.x + dx[i];
                int my = node.y + dy[i];

                if (mx < 0 || mx >= board.length || my < 0 || my >= board.length) {
                    continue;
                }

                if (board[mx][my] != 0) {
                    continue;
                }

                if (i < 2) {
                    // x축이 움직이는 경우 -> false
                    if (node.isTurn) {
                        // 코너 생성
                        board[mx][my] = node.money + STREET + CORNER;
                        priorityQueue.add(new Node(mx, my, false, node.money + STREET + CORNER));
                    }
                    if (!node.isTurn) {
                        //직진
                        board[mx][my] = node.money + STREET;
                        priorityQueue.add(new Node(mx, my, false, node.money + STREET));
                    }

                    continue;
                }

                // y축이 움직이는 경우 -> true
                if (node.isTurn) {
                    //직진
                    board[mx][my] = node.money + STREET;
                    priorityQueue.add(new Node(mx, my, true, node.money + STREET));
                }
                if (!node.isTurn) {
                    //코너 생성
                    board[mx][my] = node.money + STREET + CORNER;
                    priorityQueue.add(new Node(mx, my, true, node.money + STREET + CORNER));
                }
            }
        }
    }

    class Node {
        int x;
        int y;
        boolean isTurn; // true -> 좌우 이동 (dy), false -> 상하 이동 (dx)
        int money;

        public Node(int x, int y, boolean isTurn, int money) {
            this.x = x;
            this.y = y;
            this.isTurn = isTurn;
            this.money = money;
        }
    }

    public static void main(String[] args) {
        SolutionFail solutionFail = new SolutionFail();
        int answer = solutionFail.solution(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
        System.out.println(answer);
    }

}
