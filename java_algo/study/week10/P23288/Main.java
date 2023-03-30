package study.week10.P23288;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int answer;

    public static void main(String[] args) throws IOException {

        Dice dice = new Dice(1, 6, 3, 4, 5, 2);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int direction = 0;
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        answer = 0;
        int diceX = 0;
        int diceY = 0;

        for (int i = 0; i < count; i++) {
            if (diceX + dx[direction] < 0 || diceX + dx[direction] >= n || diceY + dy[direction] < 0 || diceY + dy[direction] >= m) {
                if (direction <= 1) {
                    direction += 2;
                } else {
                    direction -= 2;
                }
            }
            dice.roll(direction);
            diceX += dx[direction];
            diceY += dy[direction];
            answer += getContinuityValue(diceX, diceY, map[diceX][diceY]);
            direction = directionMove(direction, dice.getBottom(), map[diceX][diceY]);
        }

        System.out.println(answer);

    }

    private static int getContinuityValue(int x, int y, int value) {
        int count = 1;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int mx = now[0] + dx[i];
                int my = now[1] + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    continue;
                }

                if (visited[mx][my]) {
                    continue;
                }

                if (map[mx][my] != value) {
                    continue;
                }

                visited[mx][my] = true;
                count++;
                queue.add(new int[]{mx, my});
            }
        }

        return count * value;
    }

    private static int directionMove(int direction, int bottom, int value) {
        if (bottom > value) {
            direction++;
            if (direction == 4) {
                return 0;
            }
        }
        if (bottom < value) {
            direction--;
            if (direction == -1) {
                return 3;
            }
        }
        return direction;
    }
}

class Dice {
    int top;
    int bottom;
    int right;
    int left;
    int up;
    int down;

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }

    public int getRight() {
        return right;
    }

    public int getLeft() {
        return left;
    }

    public int getUp() {
        return up;
    }

    public int getDown() {
        return down;
    }

    public Dice(int top, int bottom, int right, int left, int up, int down) {
        this.top = top;
        this.bottom = bottom;
        this.right = right;
        this.left = left;
        this.up = up;
        this.down = down;
    }

    public void roll(int direction) {
        if (direction == 0) {
            turnLeft();
            return;
        }

        if (direction == 1) {
            turnUp();
            return;
        }

        if (direction == 2) {
            turnRight();
            return;
        }

        if (direction == 3) {
            turnDown();
            return;
        }
    }

    void turnRight() {
        int temp = this.getTop();
        this.top = this.getRight();
        this.right = this.getBottom();
        this.bottom = this.getLeft();
        this.left = temp;
    }

    void turnLeft() {
        int temp = this.getTop();
        this.top = this.getLeft();
        this.left = this.getBottom();
        this.bottom = this.getRight();
        this.right = temp;
    }

    void turnUp() {
        int temp = this.getTop();
        this.top = this.getDown();
        this.down = this.getBottom();
        this.bottom = this.getUp();
        this.up = temp;
    }

    void turnDown() {
        int temp = this.getTop();
        this.top = this.getUp();
        this.up = this.getBottom();
        this.bottom = this.getDown();
        this.down = temp;
    }
}
