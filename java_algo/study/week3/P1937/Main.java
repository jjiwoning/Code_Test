package study.week3.P1937;

import java.io.*;

public class Main {

    static int n;
    static int[][] bamboo;
    static int[][] dp;
    static int answer;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        bamboo = new int[n][n]; // 대나무 저장
        dp = new int[n][n]; // 가지치기 할 배열
        answer = 0; // 정답

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                bamboo[i][j] = Integer.parseInt(s[j]);
                dp[i][j] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 1) {
                    dfs(i, j);
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }

    private static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            if (mx < 0 || mx >= n || my < 0 || my >= n || bamboo[mx][my] <= bamboo[x][y]) {
                continue;
            }

            if (dp[mx][my] == 1) {
                dfs(mx, my);
            }
            dp[x][y] = Math.max(dp[x][y], dp[mx][my] + 1);
        }
    }
}
