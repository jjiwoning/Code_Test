package baekjoon_java.P1976.floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_VALUE = 123456789;

    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        int[][] graph = initGraph(br, n);

        floyd(graph);

        int[] wantedPath = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(findAnswer(graph, wantedPath));
    }

    private static int[][] initGraph(BufferedReader br, int n) throws IOException {
        StringTokenizer st;
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(graph[i], MAX_VALUE);
            graph[i][i] = 0;
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    graph[i][j] = 1;
                }
            }
        }

        return graph;
    }

    private static void floyd(int[][] graph) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }
    }

    private static String findAnswer(int[][] graph, int[] wantedPath) {
        for (int i = 0; i < wantedPath.length - 1; i++) {
            if (graph[wantedPath[i] - 1][wantedPath[i + 1] - 1] >= MAX_VALUE) {
                return "NO";
            }
        }
        return "YES";
    }
}
