package baekjoon_java.P14499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[] dx = new int[]{0, 0, 0, -1, 1};
    static int[] dy = new int[]{0, 1, -1, 0, 0};
    static int commandCount;
    static Dice dice;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        commandCount = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dice = new Dice(0, 0, 0, 0, 0, 0);
        answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] commands = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        moveDice(commands, 0, x, y);

        System.out.println(answer);
    }

    private static void moveDice(int[] commands, int depth, int x, int y) {
        if (depth == commandCount) {
            return;
        }

        int mx = x + dx[commands[depth]];
        int my = y + dy[commands[depth]];

        if (!canMove(mx, my)) {
            moveDice(commands, depth + 1, x, y);
        }

        if (canMove(mx, my)) {
            rollDice(commands[depth], mx, my);
            moveDice(commands, depth + 1, mx, my);
        }
    }

    private static void rollDice(int command, int x, int y) {

        if (command == 1) {
            dice.turnRight();
        }
        if (command == 2) {
            dice.turnLeft();
        }
        if (command == 3) {
            dice.turnUp();
        }
        if (command == 4) {
            dice.turnDown();
        }

        answer.append(dice.top).append("\n");

        if (map[x][y] == 0) {
            map[x][y] = dice.bottom;
            return;
        }
        if (map[x][y] != 0) {
            dice.bottom = map[x][y];
            map[x][y] = 0;
            return;
        }
    }

    private static boolean canMove(int x, int y) {
        return !(x < 0 || x >= n || y < 0 || y >= m);
    }

    private static class Dice {
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
}
