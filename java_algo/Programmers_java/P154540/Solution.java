package Programmers_java.P154540;

import java.util.*;

public class Solution {

    int[][] mapInfo;
    boolean[][] visited;
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();

        mapInfo = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'X') {
                    mapInfo[i][j] = -1;
                    continue;
                }
                mapInfo[i][j] = maps[i].charAt(j) - '0';
            }
        }

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < mapInfo[0].length; j++) {
                if (mapInfo[i][j] == -1) {
                    continue;
                }
                if (visited[i][j]) {
                    continue;
                }
                list.add(bfs(i, j));
            }
        }


        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        if (Arrays.equals(answer, new int[]{})) {
            return new int[]{-1};
        }

        Arrays.sort(answer);
        return answer;
    }

    private int bfs(int x, int y) {
        int value = mapInfo[x][y];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = now[0] + dx[i];
                int my = now[1] + dy[i];

                if (mx < 0 || mx >= mapInfo.length || my < 0 || my >= mapInfo[0].length) {
                    continue;
                }

                if (visited[mx][my]) {
                    continue;
                }

                if (mapInfo[mx][my] == -1) {
                    continue;
                }

                visited[mx][my] = true;
                value += mapInfo[mx][my];
                queue.add(new int[]{mx, my});
            }
        }

        return value;
    }
}
