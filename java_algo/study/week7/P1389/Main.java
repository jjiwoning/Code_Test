package study.week7.P1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_VAL = 2000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(graph[i], MAX_VAL);
            graph[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        int answer = -1;
        int minVal = MAX_VAL * 2 + 1;

        for (int i = 1; i < n + 1; i++) {
            int sum = Arrays.stream(graph[i]).sum();
            if (sum < minVal) {
                answer = i;
                minVal = sum;
            }
        }

        System.out.println(answer);
    }

}
