package swea.P1226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int[][] map;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int caseNum = Integer.parseInt(br.readLine());

            map = new int[16][16];

            int x = 0;
            int y = 0;

            for (int i = 0; i < 16; i++) {
                String str = br.readLine();
                for (int j = 0; j < 16; j++) {
                    map[i][j] = str.charAt(j) - 48;
                    if (map[i][j] == 2) {
                        x = i;
                        y = j;
                    }
                }
            }

            int answer = bfs(x, y);
            System.out.println("#" + caseNum + " " + answer);
        }
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowX = poll[0];
            int nowY = poll[1];

            for (int i = 0; i < 4; i++) {
                int mx = nowX + dx[i];
                int my = nowY + dy[i];
                if (mx < 0 || my < 0 || mx >= 16 || my >= 16) {
                    continue;
                }
                if (map[mx][my] == 0) {
                    queue.add(new int[]{mx, my});
                    map[mx][my] = 1;
                }
                if (map[mx][my] == 3) {
                    return 1;
                }
            }
        }

        return 0;
    }
}
