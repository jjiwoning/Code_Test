package algo_sample_code;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimSample {

    static List<Edge>[] graph;

    public int prim(int start, int n) {
        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((Comparator.comparingInt(o -> o.cost)));
        priorityQueue.add(new Edge(start, 0));

        int total = 0;

        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            int v = edge.w;
            int c = edge.cost;

            if (visited[v]) {
                continue;
            }

            visited[v] = true;
            total += c;

            for (Edge e : graph[v]) {
                if (!visited[e.w]) {
                    priorityQueue.add(e);
                }
            }
        }

        return total;
    }
}

class Edge {
    int w; // 정점
    int cost; // 가중치

    public Edge(int w, int cost) {
        this.w = w;
        this.cost = cost;
    }
}

