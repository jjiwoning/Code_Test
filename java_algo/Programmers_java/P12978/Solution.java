package Programmers_java.P12978;

import java.util.*;

import static java.util.Comparator.comparingInt;

public class Solution {

    Map<Integer, Node>[] graph;
    int[] distance;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        distance = new int[N + 1];
        Arrays.fill(distance, 99999999);
        graph = new HashMap[N + 1];

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new HashMap<>();
        }

        Arrays.sort(road, comparingInt(o -> o[2]));

        for (int[] info : road) {
            if (graph[info[0]].containsKey(info[1])) {
                continue;
            }
            graph[info[0]].put(info[1], new Node(info[1], info[2]));
            graph[info[1]].put(info[0], new Node(info[0], info[2]));
        }

        dijkstra(1);

        System.out.println(Arrays.toString(distance));

        for (int i = 1; i < N + 1; i++) {
            if (distance[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    private void dijkstra(int start) {

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(comparingInt(o -> o.cost));
        priorityQueue.add(new Node(start, 0));

        distance[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            for (Integer integer : graph[node.v].keySet()) {
                if (distance[graph[node.v].get(integer).v] > node.cost + graph[node.v].get(integer).cost) {
                    distance[graph[node.v].get(integer).v] = node.cost + graph[node.v].get(integer).cost;
                    priorityQueue.add(new Node(graph[node.v].get(integer).v, distance[graph[node.v].get(integer).v]));
                }
            }
        }
    }

    class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

    }
}
