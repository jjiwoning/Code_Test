package algo_sample_code;

import java.util.List;
import java.util.PriorityQueue;

import static java.util.Comparator.*;

public class DijkstraSample {

    static List<Node>[] graph;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) {

    }

    static void dijkstra(int start) {

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(comparingInt(o -> o.cost));
        priorityQueue.add(new Node(start, 0));
        distance[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            if (!visited[node.v]) {
                visited[node.v] = true;
            }

            for (Node n : graph[node.v]) {
                if (!visited[n.v] && distance[n.v] > node.cost + n.cost) {
                    distance[n.v] = node.cost + n.cost;
                    priorityQueue.add(new Node(n.v, distance[n.v]));
                }
            }
        }
    }

    static class Node {
        int v; // 간선
        int cost; // 가중치

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}
