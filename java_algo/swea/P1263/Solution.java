package swea.P1263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static final int MAX_VALUE = 200000000;
    static int n;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            distance = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    if (value == 1) {
                        distance[i][j] = value;
                        distance[j][i] = value;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][j] == 0) {
                        distance[i][j] = MAX_VALUE;
                    }
                }
            }

            floydWarshall();

            int findValue = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int findSum = 0;
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        continue;
                    }
                    findSum += distance[i][j];
                }
                findValue = Math.min(findValue, findSum);
            }

            answer.append("#").append(testCase).append(" ").append(findValue).append("\n");
        }

        System.out.println(answer);
    }

    private static void floydWarshall() {
        for (int i = 0; i < n; i++) { // 경유지
            for (int j = 0; j < n; j++) { // 출발지
                for (int k = 0; k < n; k++) { // 목적지
                    if (j == k || i == k) {
                        continue;
                    }
                    distance[j][k] = Math.min(distance[j][k], distance[j][i] + distance[i][k]);
                }
            }
        }
    }
}
