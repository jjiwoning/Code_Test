package baekjoon_java.P16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int[] DX = new int[]{1, -1, 0, 0};
    private static final int[] DY = new int[]{0, 0, 1, -1};

    private static int n;
    private static int l;
    private static int r;
    private static int[][] countries;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        countries = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                countries[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while (true) {
            visited = new boolean[n][n];
            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            if (count == n * n) {
                break;
            }

            answer++;
        }

        System.out.println(answer);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> pairs = new ArrayList<>();
        int sum = 0;
        queue.add(new int[]{x, y});
        pairs.add(new int[]{x, y});
        sum += countries[x][y];
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = now[0] + DX[i];
                int my = now[1] + DY[i];

                if (mx < 0 || mx >= n || my < 0 || my >= n) {
                    continue;
                }

                int difference = Math.abs(countries[now[0]][now[1]] - countries[mx][my]);

                if (l > difference || difference > r) {
                    continue;
                }

                if (visited[mx][my]) {
                    continue;
                }

                sum += countries[mx][my];
                visited[mx][my] = true;
                pairs.add(new int[]{mx, my});
                queue.add(new int[]{mx, my});
            }
        }

        int divSum = sum / pairs.size();

        for (int[] pair : pairs) {
            countries[pair[0]][pair[1]] = divSum;
        }
    }
}
