package Programmers_java.kakao_1829;

/**
 * 2017 카카오 코드 예선 - 카카오프렌즈 컬러링 북
 */
public class Solution {

    private final int[] dx = new int[]{1, -1, 0, 0};
    private final int[] dy = new int[]{0, 0, 1, -1};

    private int m;
    private int n;
    private int[][] picture;

    private boolean[][] visited;
    private int count;

    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        this.picture = picture;
        this.m = m;
        this.n = n;

        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    count = 0;
                    visited[i][j] = true;
                    dfs(i, j, picture[i][j]);
                    answer[1] = Math.max(answer[1], count);
                    answer[0]++;
                }
            }
        }

        return answer;
    }

    private void dfs(int x, int y, int target) {
        count++;

        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            if (0 > mx || mx >= m || 0 > my || my >= n) {
                continue;
            }

            if (visited[mx][my] || picture[mx][my] != target) {
                continue;
            }

            visited[mx][my] = true;
            dfs(mx, my, target);
        }
    }
}
