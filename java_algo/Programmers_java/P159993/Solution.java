package Programmers_java.P159993;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    int answer;
    char[][] charMap;
    boolean[][][] visited;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int solution(String[] maps) {
        answer = 0;

        charMap = new char[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            charMap[i] = maps[i].toCharArray();
        }

        int x = -1;
        int y = -1;

        for (int i = 0; i < charMap.length; i++) {
            for (int j = 0; j < charMap[0].length; j++) {
                if (charMap[i][j] == 'S') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        visited = new boolean[2][charMap.length][charMap[0].length];

        if (bfs(x, y)) {
            return answer;
        }

        return -1;
    }

    private boolean bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0, 0));
        visited[0][x][y] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = now.x + dx[i];
                int my = now.y + dy[i];

                if (mx < 0 || mx >= charMap.length || my < 0 || my >= charMap[0].length) {
                    continue;
                }

                if (visited[now.leverOn][mx][my]) {
                    continue;
                }

                if (charMap[mx][my] == 'X') {
                    continue;
                }

                if (charMap[mx][my] == 'E' && now.leverOn == 1) {
                    answer = now.cost + 1;
                    return true;
                }

                if (charMap[mx][my] == 'L') {
                    visited[1][mx][my] = true;
                    queue.add(new Node(mx, my, now.cost + 1, 1));
                    continue;
                }

                visited[now.leverOn][mx][my] = true;
                queue.add(new Node(mx, my, now.cost + 1, now.leverOn));
            }
        }

        return false;
    }

    private static class Node {
        int x;
        int y;
        int cost;
        int leverOn; // 0 안킴, 1 킴

        public Node(int x, int y, int cost, int leverOn) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.leverOn = leverOn;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
    }
}
