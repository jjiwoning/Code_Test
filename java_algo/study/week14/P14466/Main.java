package study.week14.P14466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static Set<Info>[][] roadSet;
    static int answer;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        roadSet = new HashSet[n][n];
        answer = 0;
        List<Info> cowInfo = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                roadSet[i][j] = new HashSet<>();
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            roadSet[x1][y1].add(new Info(x2, y2));
            roadSet[x2][y2].add(new Info(x1, y1));
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            cowInfo.add(new Info(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1));
        }

        for (int i = 0; i < k; i++) {
            visited = new boolean[n][n];
            bfs(cowInfo.get(i));
            for (int j = i; j < k; j++) {
                Info info = cowInfo.get(j);
                if (!visited[info.x][info.y]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static void bfs(Info cowInfo) {
        Queue<Info> queue = new LinkedList<>();
        queue.add(cowInfo);
        visited[cowInfo.x][cowInfo.y] = true;

        while (!queue.isEmpty()) {
            Info nowDirection = queue.poll();
            int x = nowDirection.x;
            int y = nowDirection.y;
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= n) {
                    continue;
                }

                if (visited[mx][my]) {
                    continue;
                }

                if (roadSet[x][y].contains(new Info(mx, my))) {
                    continue;
                }

                visited[mx][my] = true;
                queue.add(new Info(mx, my));
            }
        }
    }

}

class Info {
    int x;
    int y;

    public Info(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return x == info.x && y == info.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
