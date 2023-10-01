package baekjoon_java.P1719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_VALUE = 12345678;
    private static int[][] graph;
    private static String[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        answer = new String[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(graph[i], MAX_VALUE);
        }

        for (int i = 1; i < n + 1; i++) {
            graph[i][i] = 0;
            answer[i][i] = "-";
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start][end] = cost;
            graph[end][start] = cost;
            answer[start][end] = "" + end;
            answer[end][start] = "" + start;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    if (graph[j][i] + graph[i][k] < graph[j][k]) {
                        graph[j][k] = graph[j][i] + graph[i][k];
                        answer[j][k] = answer[j][i];
                    }
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
