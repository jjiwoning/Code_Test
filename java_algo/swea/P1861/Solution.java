package swea.P1861;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int n;
    static int[][] rooms;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int[] visitedCountOfRooms;
    static boolean[] visited;
    static int count;
    static int roomNumber;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {

            n = Integer.parseInt(br.readLine());
            rooms = new int[n][n];
            visitedCountOfRooms = new int[n * n + 1];
            visited = new boolean[n * n + 1];
            int[][] startPoint = new int[n * n + 1][2];

            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    rooms[i][j] = Integer.parseInt(s[j]);
                    startPoint[Integer.parseInt(s[j])] = new int[]{i, j};
                }
            }

            count = Integer.MIN_VALUE;
            roomNumber = 0;

            for (int i = 1; i < n * n + 1; i++) {
                if (!visited[i]) {
                    dfs(startPoint[i][0], startPoint[i][1], 1);
                }
            }

            int answerRoomNum = -1;
            for (int i = 1; i < n * n + 1; i++) {
                if (visitedCountOfRooms[i] == count) {
                    answerRoomNum = i;
                    break;
                }
            }

            System.out.println("#" + testCase + " " + answerRoomNum + " " + count);
        }
    }

    private static void dfs(int x, int y, int move) {
        if (check(x, y)) {
            if (move >= count) {
                visitedCountOfRooms[roomNumber] = move;
                count = move;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx < 0 || mx >= n || my < 0 || my >= n) {
                continue;
            }
            if (rooms[mx][my] - 1 == rooms[x][y]) {
                visited[rooms[mx][my]] = true;
                dfs(mx, my, move + 1);
            }
        }
    }

    private static boolean check(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx < 0 || mx >= n || my < 0 || my >= n) {
                continue;
            }
            if (rooms[mx][my] - 1 == rooms[x][y]) {
                return false;
            }
        }
        return true;
    }
}
