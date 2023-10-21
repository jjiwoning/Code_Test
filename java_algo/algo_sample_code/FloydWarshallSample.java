package algo_sample_code;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 플로이드 워셜 알고리즘
 * 음수 사이클이 존재하지 않는 그래프에서 모든 정점에서 모든 정점까지의 최단 거리를 구하는 알고리즘
 * DP를 활용한 알고리즘 -> 노드 0개를 거치는 최단거리 -> 노드 1개를 거치는 최단거리 -> ... -> 정답 도출
 * 시간 복잡도: O(n^3)
 */
public class FloydWarshallSample {

    static int n;
    static int m;
    static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i < n + 1; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int c = sc.nextInt();
            graph[s][e] = c;
        }

        for (int mid = 1; mid < n + 1; mid++) {
            for (int start = 1; start < n + 1; start++) {
                for (int end = 1; end < n + 1; end++) {
                    graph[start][end] = Math.min(graph[start][end], graph[start][mid] + graph[mid][end]);
                }
            }
        }
    }

}
