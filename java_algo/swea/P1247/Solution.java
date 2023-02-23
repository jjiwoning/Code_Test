package swea.P1247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class Solution {

    static int n;
    static int homeX;
    static int homeY;
    static int answer;
    static int[][] mapInfo;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int testCase = 1; testCase <= t; testCase++) {

            n = parseInt(br.readLine());

            mapInfo = new int[n][2];
            visited = new boolean[n];
            answer = MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());

            int startX = parseInt(st.nextToken());
            int startY = parseInt(st.nextToken());

            homeX = parseInt(st.nextToken());
            homeY = parseInt(st.nextToken());

            for (int i = 0; i < n; i++) {
                mapInfo[i][0] = parseInt(st.nextToken());
                mapInfo[i][1] = parseInt(st.nextToken());
            }

            dfs(startX, startY, 0, 0);

            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int x, int y, int depth, int cost) {
        if (depth == n) {
            cost += findDistance(x, y, homeX, homeY);
            answer = Math.min(cost, answer);
            return;
        }

        if (cost > answer) {
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(mapInfo[i][0], mapInfo[i][1], depth + 1, cost + findDistance(x, y, mapInfo[i][0], mapInfo[i][1]));
                visited[i] = false;
            }
        }
    }

    private static int findDistance(int x1, int y1, int x2, int y2) {
        return abs(x1 - x2) + abs(y1 - y2);
    }

}
