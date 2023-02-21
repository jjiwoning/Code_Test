package baekjoon_java.P3109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 0, 1};
    static int[] dy = new int[]{1, 1, 1};
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visited = new boolean[n][m];
        answer = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            steal(i, 0);
        }

        System.out.println(answer);
    }

    private static boolean steal(int x, int y) {
        if (y == m - 1) {
            answer++;
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            if (mx < 0 || mx >= n || my < 0 || my >= m) {
                continue;
            }

            if (!visited[mx][my] && arr[mx][my] == '.') {
                visited[mx][my] = true;
                if (steal(mx, my)) {
                    return true;
                }
            }
        }
        return false;
    }
}
