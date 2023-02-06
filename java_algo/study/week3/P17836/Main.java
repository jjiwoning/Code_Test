package study.week3.P17836;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n;
    static int m;
    static int limit;
    static int answer;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        limit = Integer.parseInt(s[2]);
        map = new int[n][m];
        visited = new boolean[2][n][m]; // 마스터 소드가 있을 때 없을 때 구분하기 위해 3차원 배열로 선언

        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s1[j]);
            }
        }

        if (bfs() && answer <= limit) {
            System.out.println(answer);
        } else {
            System.out.println("Fail");
        }
    }

    private static boolean bfs() {

        Queue<Link> queue = new LinkedList<>();
        queue.add(new Link(0, 0, 0, false));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Link now = queue.poll(); // 현재 용사의 위치

            if (now.distance > limit) {
                continue; // 가지치기 -> 이미 제한을 넘어서는 경우 탐색을 하는 의미가 없음
            }

            if (now.x == n - 1 && now.y == m - 1) { // 이 경우 공주를 찾음 -> answer 값 구할 수 있다.
                answer = now.distance;
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int mx = now.x + dx[i];
                int my = now.y + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    continue; // 범위에 벗어나 탐색 못함
                }

                if (map[mx][my] == 1 && !now.masterSword) {
                    continue; // 이 경우 탐색 못함
                }

                if (now.masterSword) { // 마스터 소드가 있는 경우
                    if (visited[1][mx][my]) { // 방문한 경우 탈출
                        continue;
                    }
                    visited[1][mx][my] = true;
                    queue.add(new Link(mx, my, now.distance + 1, now.masterSword));
                }

                if (!now.masterSword) { // 마스터 소드가 없는 경우
                    if (visited[0][mx][my]) { // 방문한 경우 탈출
                        continue;
                    }
                    if (map[mx][my] == 2) { // 마스터 소드를 얻는 경우
                        visited[0][mx][my] = true;
                        queue.add(new Link(mx, my, now.distance + 1, true)); // 마스터 소드를 얻는다.
                    }
                    if (map[mx][my] == 0) {
                        visited[0][mx][my] = true;
                        queue.add(new Link(mx, my, now.distance + 1, false));
                    }
                }
            }
        }
        return false;
    }

    private static class Link {
        int x;
        int y;
        int distance; // 거리
        boolean masterSword; // 마스터 소드 보유 여부

        public Link(int x, int y, int distance, boolean masterSword) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.masterSword = masterSword;
        }
    }

}
