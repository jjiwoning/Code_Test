package Programmers_java.pick_item;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    int[][] map;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        map = new int[102][102];
        for (int[] ints : rectangle) { // 처음에 직사각형 전체 채우기
            int sx = ints[0] * 2;
            int sy = ints[1] * 2;
            int ex = ints[2] * 2;
            int ey = ints[3] * 2;
            for (int i = sx; i <= ex; i++) {
                for (int j = sy; j <= ey; j++) {
                    map[i][j] = 1;
                }
            }
        }

        for (int[] ints : rectangle) { // 채운 직사각형 겉에만 남기고 다 지우기
            int sx = ints[0] * 2;
            int sy = ints[1] * 2;
            int ex = ints[2] * 2;
            int ey = ints[3] * 2;
            for (int i = sx + 1; i < ex; i++) {
                for (int j = sy + 1; j < ey; j++) {
                    map[i][j] = 0;
                }
            }
        }

        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);

        return map[itemX * 2][itemY * 2] / 2;
    }

    private void bfs(int x, int y, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            if (nowX == endX && nowY == endY) {
                break;
            }
            if (nowX < 0 || nowX > 101 || nowY < 0 || nowY > 101) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int mx = nowX + dx[i];
                int my = nowY + dy[i];
                if (map[mx][my] == 1) {
                    map[mx][my] += map[nowX][nowY];
                    queue.add(new int[]{mx, my});
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] rect = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
        Solution solution = new Solution();
        int answer = solution.solution(rect, 1, 3, 7, 8);
        System.out.println(answer);
    }
}
