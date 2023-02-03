package study.week3.P12869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 3P3 -> 3 * 2 * 1 = 6
    static int[][] damage = new int[][]{{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};
    static int[] scv;
    static int answer;
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        scv = new int[3];
        visited = new int[61][61][61];
        for (int i = 0; i < n; i++) {
            scv[i] = Integer.parseInt(s[i]);
        }

        answer = Integer.MAX_VALUE;

        dfs(0, scv);

        System.out.println(answer);
    }

    private static void dfs(int count, int[] scv) {
        if (scv[0] == 0 && scv[1] == 0 && scv[2] == 0) {
            answer = Math.min(answer, count);
            return;
        }

        if (count >= answer) {
            return;
        }

        if (checkVisit(scv, count)) {
            for (int i = 0; i < 6; i++) {
                int[] now = scv.clone();
                for (int j = 0; j < 3; j++) {
                    now[j] = Math.max(now[j] - damage[i][j], 0);
                }
                dfs(count + 1, now);
            }
        }
    }

    private static boolean checkVisit(int[] scv, int count) {
        int s1 = scv[0];
        int s2 = scv[1];
        int s3 = scv[2];

        if (visited[s1][s2][s3] == 0 || visited[s1][s2][s3] > count) {
            visited[s1][s2][s3] = count;
            return true;
        }
        return false;
    }
}
