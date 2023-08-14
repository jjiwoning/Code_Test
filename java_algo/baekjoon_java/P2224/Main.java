package baekjoon_java.P2224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[][] graph;
    static int graphSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graphSize = 'z' + 1;
        initGraph();
        setGraphEdge(br);
        floydWarshall(graphSize);
        printResult();
    }

    private static void initGraph() {
        graph = new int[graphSize][graphSize];

        for (int i = 0; i < graphSize; i++) {
            Arrays.fill(graph[i], 100000);
        }

        for (int i = 0; i < graphSize; i++) {
            graph[i][i] = 0;
        }
    }

    private static void setGraphEdge(BufferedReader br) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" => ");
            graph[inputs[0].charAt(0)][inputs[1].charAt(0)] = 1;
        }
    }

    private static void floydWarshall(int graphSize) {
        for (int i = 0; i < graphSize; i++) {
            for (int j = 0; j < graphSize; j++) {
                for (int k = 0; k < graphSize; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }
    }

    private static void printResult() {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < graphSize; i++) {
            for (int j = 0; j < graphSize; j++) {
                if (graph[i][j] < 100000 && graph[i][j] > 0 && i != j) {
                    count++;
                    sb.append((char) i).append(" => ").append((char) j).append("\n");
                }
            }
        }
        System.out.println(count);
        System.out.println(sb);
    }
}
