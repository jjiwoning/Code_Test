package Programmers_java.P42861;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {

    private int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        List<Node> nodeList = new ArrayList<>();

        for (int[] cost : costs) {
            nodeList.add(new Node(cost[0], cost[1], cost[2]));
        }

        nodeList.sort(Comparator.comparingInt(o1 -> o1.cost));

        for (Node node : nodeList) {
            if (!isSameParent(node.start, node.end)) {
                union(node.start, node.end);
                answer += node.cost;
            }
        }

        return answer;
    }

    private void union(int node1, int node2) {
        node1 = find(node1);
        node2 = find(node2);

        if (node1 < node2) {
            parent[node2] = node1;
        }

        if (node1 > node2) {
            parent[node1] = node2;
        }
    }

    private int find(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    private boolean isSameParent(int node1, int node2) {
        return find(node1) == find(node2);
    }
}

class Node {
    int start;
    int end;
    int cost;

    public Node(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}
