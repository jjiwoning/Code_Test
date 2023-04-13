package Programmers_java.kakao_118669;

import java.util.*;

public class Solution {

    Set<Integer> summitSet;
    Set<Integer> gateSet;
    private ArrayList<Node>[] graph;
    private int[] distance;
    int[] answer;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        answer = new int[2];
        answer[0] = Integer.MAX_VALUE;
        answer[1] = Integer.MAX_VALUE;

        distance = new int[n + 1];
        graph = new ArrayList[n + 1];
        summitSet = new HashSet<>();
        gateSet = new HashSet<>();

        for (int summit : summits) {
            summitSet.add(summit);
        }
        for (int gate : gates) {
            gateSet.add(gate);
        }

        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] path : paths) {
            graph[path[0]].add(new Node(path[1], path[2]));
            graph[path[1]].add(new Node(path[0], path[2]));
        }

        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int gate : gates) {
            gateSet.remove(gate);
            dijkstra(gate);
            gateSet.add(gate);
        }

        return answer;
    }

    private void dijkstra(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        priorityQueue.add(new Node(start, 0));
        distance[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            if (node.cost > distance[node.end]) {
                continue;
            }

            if (summitSet.contains(node.end)) {
                if (answer[1] > node.cost) {
                    answer[1] = node.cost;
                    answer[0] = node.end;
                }
                if (answer[1] == node.cost) {
                    answer[0] = Math.min(answer[0], node.end);
                }
                continue;
            }

            for (Node n : graph[node.end]) {
                if (distance[n.end] > Math.max(n.cost, node.cost)) {
                    distance[n.end] = Math.max(node.cost, n.cost);
                    priorityQueue.add(new Node(n.end, distance[n.end]));
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(7, new int[][]{{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}}, new int[]{1}, new int[]{2, 3, 4});
    }
}

class Node {
    int end;
    int cost;

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
}
