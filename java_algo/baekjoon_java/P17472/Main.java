package baekjoon_java.P17472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[][] groupMap;
    static boolean[][] visited;
    static List<Edge> edgeList;
    static int[] parent;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        groupMap = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int groupNum = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(i, j, groupNum++);
                }
            }
        }

        parent = new int[groupNum];
        for (int i = 0; i < groupNum; i++) {
            parent[i] = i;
        }
        edgeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (groupMap[i][j] != 0) {
                    makeBridge(i, j);
                }
            }
        }

        edgeList.sort((o1, o2) -> o1.cost - o2.cost);

        int answer = 0;

        for (Edge edge : edgeList) {
            if (!isSameParent(edge.start, edge.end)) {
                union(edge.start, edge.end);
                answer += edge.cost;
            }
        }

        int x = parent[1];

        for (int i = 1; i < parent.length; i++) {
            find(i);
            if (x != parent[i]) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int x, int y, int groupNum) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        groupMap[x][y] = groupNum;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = now[0] + dx[i];
                int my = now[1] + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    continue;
                }

                if (map[mx][my] == 0) {
                    continue;
                }

                if (visited[mx][my]) {
                    continue;
                }

                visited[mx][my] = true;
                groupMap[mx][my] = groupNum;
                queue.add(new int[]{mx, my});
            }
        }
    }

    private static void makeBridge(int x, int y) {
        int start = groupMap[x][y];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < 4; i++) {
            queue.add(new int[]{x, y, 0});

            while (!queue.isEmpty()) {
                int[] now = queue.poll();

                int mx = now[0] + dx[i];
                int my = now[1] + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    continue;
                }

                if (groupMap[mx][my] == start) {
                    continue;
                }

                if (groupMap[mx][my] > 0 && groupMap[mx][my] != start) {
                    if (now[2] == 1) {
                        continue;
                    }
                    edgeList.add(new Edge(start, groupMap[mx][my], now[2]));
                    continue;
                }

                queue.add(new int[]{mx, my, now[2] + 1});
            }
        }
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            }

            if (x > y) {
                parent[x] = y;
            }
        }
    }

    private static boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }

    private static class Edge {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

}
