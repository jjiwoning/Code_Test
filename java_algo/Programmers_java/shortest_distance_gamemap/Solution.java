package Programmers_java.shortest_distance_gamemap;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int[][] maps) {
        bfs(maps);
        if (maps[maps.length - 1][maps[0].length - 1] == 1) {
            return -1;
        }
        return maps[maps.length - 1][maps[0].length - 1];
    }

    public void bfs(int[][] maps) {
        int x = 0;
        int y = 0;
        maps[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            for (int i = 0; i < 4; i++) {
                int nX = nowX + dx[i];
                int nY = nowY + dy[i];

                if (nX < 0 || nX > maps.length - 1 || nY < 0 || nY > maps[0].length - 1) {
                    continue;
                }

                if (maps[nX][nY] == 1) {
                    maps[nX][nY] = maps[nowX][nowY] + 1;
                    queue.add(new int[]{nX, nY});
                }

            }
        }
    }
}
