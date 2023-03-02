package algo_sample_code;

import java.util.List;

/**
 * 벨만 포드 알고리즘
 * 음수인 가중치가 포함되어 있는 그래프에서 최단 거리를 구하는 알고리즘
 * -> 음수인 사이클을 찾을 수 있다.
 */
public class BellmanFordSample {

    static final long MAX_VAL = 987654321;
    static int n;
    static int[] distance;
    static List<Edge> edgeList;

    public static void main(String[] args) {

    }

    private static boolean bellmanFord() {
        for (int i = 1; i < n + 1; i++) {
            for (Edge edge : edgeList) {
                if (distance[edge.from] == MAX_VAL) {
                    continue;
                }
                if (distance[edge.to] > distance[edge.from] + edge.cost) {
                    distance[edge.to] = distance[edge.from] + edge.cost;

                    if (i == n) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
