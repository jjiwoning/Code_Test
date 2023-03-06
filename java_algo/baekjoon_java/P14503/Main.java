package baekjoon_java.P14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());

        map = new int[n][m];
        answer = 0;

        st = new StringTokenizer(br.readLine());

        Cleaner cleaner = new Cleaner(parseInt(st.nextToken()), parseInt(st.nextToken()), parseInt(st.nextToken()));

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(cleaner);

        System.out.println(answer);
    }

    private static void dfs(Cleaner cleaner) {
        cleaner.clean();

        if (!cleaner.moveCheck()) {
            if (cleaner.isBack()) {
                dfs(cleaner);
            } else {
                answer = cleaner.cleanCount;
                return;
            }
        }

        if (cleaner.moveCheck()) {
            for (int i = 0; i < 4; i++) {
                cleaner.turn();
                if (cleaner.canClean()) {
                    cleaner.move();
                    dfs(cleaner);
                    break;
                }
            }
        }
    }

    private static class Cleaner {
        int x;
        int y;
        int direction;
        int cleanCount;

        public Cleaner(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cleanCount = 0;
        }

        public void clean() {
            if (map[this.x][this.y] == 0) {
                map[this.x][this.y] = 2;
                cleanCount++;
            }
        }

        public boolean moveCheck() {
            for (int i = 0; i < 4; i++) {
                int mx = this.x + dx[i];
                int my = this.y + dy[i];
                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    continue;
                }
                if (map[mx][my] == 0) {
                    return true;
                }
            }
            return false;
        }

        public void move() {
            this.x += dx[direction];
            this.y += dy[direction];
        }

        public void turn() {
            // 반 시계
            direction -= 1;
            if (direction == -1) {
                direction = 3;
            }
        }

        public boolean canClean() {
            int mx = this.x + dx[direction];
            int my = this.y + dy[direction];
            if (map[mx][my] == 0) {
                return true;
            }
            return false;
        }

        public boolean isBack() {
            int checkDirection = this.direction;
            checkDirection -= 2;
            if (checkDirection < 0) {
                checkDirection += 4;
            }
            int mx = this.x + dx[checkDirection];
            int my = this.y + dy[checkDirection];

            if (map[mx][my] != 1) {
                this.x = mx;
                this.y = my;
                return true;
            }
            return false;
        }
    }
}
