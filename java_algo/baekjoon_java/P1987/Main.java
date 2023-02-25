package baekjoon_java.P1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static char[][] arr;
    static Map<Character, Boolean> visited;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];

        visited = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (!visited.containsKey(arr[i][j])) {
                    visited.put(arr[i][j], false);
                }
            }
        }

        answer = 0;
        visited.put(arr[0][0], true);

        dfs(0, 0, 1);

        System.out.println(answer);
    }

    private static void dfs(int x, int y, int count) {
        answer = Math.max(count, answer);

        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx < 0 || mx >= n || my < 0 || my >= m) {
                continue;
            }
            if (!visited.get(arr[mx][my])) {
                visited.put(arr[mx][my], true);
                dfs(mx, my, count + 1);
                visited.put(arr[mx][my], false);
            }
        }
    }
}
