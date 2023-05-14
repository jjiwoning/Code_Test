package Programmers_java.P172928;

public class Solution {

    int n;
    int m;
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};
    boolean[][] mapInfo;

    public int[] solution(String[] park, String[] routes) {

        n = park.length;
        m = park[0].length();

        mapInfo = new boolean[n][m];
        Robot robot = null;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (park[i].charAt(j) == 'X') {
                    mapInfo[i][j] = true;
                }
                if (park[i].charAt(j) == 'S') {
                    robot = new Robot(i, j);
                }
            }
        }

        for (String route : routes) {
            String[] s = route.split(" ");
            int d = getDirection(s[0]);
            int x = robot.x;
            int y = robot.y;
            for (int i = 0; i < Integer.parseInt(s[1]); i++) {
                if (!moveRobot(robot, d)) {
                    robot.x = x;
                    robot.y = y;
                    break;
                }
            }
        }

        return new int[]{robot.x, robot.y};
    }

    private boolean moveRobot(Robot robot, int direction) {
        int mx = robot.x + dx[direction];
        int my = robot.y + dy[direction];

        if (mx < 0 || mx >= n || my < 0 || my >= m) {
            return false;
        }

        if (mapInfo[mx][my]) {
            return false;
        }

        robot.x = mx;
        robot.y = my;

        return true;
    }

    private int getDirection(String s) {
        if (s.equals("E")) {
            return 2;
        }
        if (s.equals("W")) {
            return 3;
        }
        if (s.equals("S")) {
            return 0;
        }
        if (s.equals("N")) {
            return 1;
        }
        throw new IllegalArgumentException();
    }
}

class Robot {
    int x;
    int y;

    public Robot(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
