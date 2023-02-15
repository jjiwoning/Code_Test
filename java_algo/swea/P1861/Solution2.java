package swea.P1861;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {

    static int n;
    static int[][] rooms;
    static int[][] visitedCountOfRooms;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {

            n = Integer.parseInt(br.readLine());
            rooms = new int[n][n];
            visitedCountOfRooms = new int[n][n];

            int[][] startPoint = new int[n * n + 1][2];

            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    rooms[i][j] = Integer.parseInt(s[j]);
                    startPoint[Integer.parseInt(s[j])] = new int[]{i, j};
                }
            }

            int answer = Integer.MIN_VALUE;

            for (int i = n * n; i > 0; i--) {
                int count = 0;

                int x = startPoint[i][0];
                int y = startPoint[i][1];

                for (int j = 0; j < 4; j++) {
                    int mx = x + dx[j];
                    int my = y + dy[j];
                    if (mx < 0 || mx >= n || my < 0 || my >= n) {
                        continue;
                    }
                    if (rooms[mx][my] - 1 == rooms[x][y]) {
                        count += visitedCountOfRooms[mx][my];
                    }
                }

                visitedCountOfRooms[x][y] = count + 1;
                answer = Math.max(count + 1, answer);
            }

            int answerRoomNum = -1;

            for (int i = 1; i < n * n + 1; i++) {
                int x = startPoint[i][0];
                int y = startPoint[i][1];
                if (visitedCountOfRooms[x][y] == answer) {
                    answerRoomNum = i;
                    break;
                }
            }

            System.out.println("#" + testCase + " " + answerRoomNum + " " + answer);
        }
    }
}
