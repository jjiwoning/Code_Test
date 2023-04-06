package baekjoon_java.P16946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] groupInfo;
    static boolean[] groupVisited;
    static int[][] map;
    static int[][] answer;
    static boolean[][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int num;
    static Map<Integer, Integer> groupMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        answer = new int[n][m];
        visited = new boolean[n][m];
        groupInfo = new int[n][m];
        groupMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                int num = s.charAt(j) - '0';
                map[i][j] = num;
                if (num == 1) {
                    map[i][j] = -1;
                }
            }
        }

        num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    int find = bfs(i, j);
                    groupInfo[i][j] = num;
                    groupMap.put(num, find);
                    num++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1) {
                    groupVisited = new boolean[num];
                    sb.append(getAnswer(i, j) % 10);
                    continue;
                }
                sb.append(0);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int getAnswer(int x, int y) {

        int answer = 1;

        for (int i = 0; i < 4; i++) {

            int mx = x + dx[i];
            int my = y + dy[i];

            if (mx < 0 || mx >= n || my < 0 || my >= m) {
                continue;
            }

            if (!groupVisited[groupInfo[mx][my]] && map[mx][my] != -1) {
                answer += groupMap.get(groupInfo[mx][my]);
                groupVisited[groupInfo[mx][my]] = true;
            }
        }

        return answer % 10;
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int answer = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int mx = now[0] + dx[i];
                int my = now[1] + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    continue;
                }

                if (visited[mx][my]) {
                    continue;
                }

                if (map[mx][my] == -1) {
                    continue;
                }

                answer++;
                visited[mx][my] = true;
                groupInfo[mx][my] = num;
                queue.add(new int[]{mx, my});
            }
        }

        return answer % 10;
    }
}
