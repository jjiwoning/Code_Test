package Programmers_java.kakao_60063;

import java.util.*;

public class Solution {

    Set<Robot> visited;
    int[][] costBoard;
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    public int solution(int[][] board) {
        int answer = 0;

        costBoard = new int[board.length][board[0].length];
        visited = new HashSet<>();

        Robot robot = new Robot(0, 0, 0, 1, 0);

        bfs(robot);

        return answer;
    }

    private void bfs(Robot robot) {
        Queue<Robot> queue = new LinkedList<>();
        queue.add(robot);
        visited.add(robot);

        while (!queue.isEmpty()) {
            Robot nowRobot = queue.poll();

            // 상하좌우
            for (int i = 0; i < 4; i++) {

            }

            // 회전
            for (int i = 0; i < 4; i++) {

            }
        }
    }
}

class Robot {
    int x1;
    int y1;
    int x2;
    int y2;
    int cost;

    public Robot rotateRobot(int number) {
        if (number == 0) {

        }
        if (number == 1) {

        }
        if (number == 2) {

        }
        if (number == 3) {

        }
        throw new IllegalArgumentException();
    }

    public Robot(int x1, int y1, int x2, int y2, int cost) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return x1 == robot.x1 && y1 == robot.y1 && x2 == robot.x2 && y2 == robot.y2 && cost == robot.cost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2, cost);
    }
}
