package baekjoon_java.P1647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.*;
import static java.util.Comparator.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());

        parent = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        List<Node> nodeList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = parseInt(st.nextToken());
            int e = parseInt(st.nextToken());
            int c = parseInt(st.nextToken());
            nodeList.add(new Node(s, e, c));
        }

        nodeList.sort(comparingInt(o -> o.cost));

        int totalCost = 0;
        int maxCost = -1;

        for (int i = 0; i < m; i++) {
            Node node = nodeList.get(i);
            if (!isSameParent(node.start, node.end)) {
                union(node.start, node.end);
                totalCost += node.cost;
                maxCost = Math.max(maxCost, node.cost);
            }
        }

        System.out.println(totalCost - maxCost);
    }

    private static void union(int n1, int n2) {
        n1 = find(n1);
        n2 = find(n2);

        if (n1 < n2) {
            parent[n2] = n1;
        }

        if (n1 > n2) {
            parent[n1] = n2;
        }
    }

    private static int find(int n) {
        if (n == parent[n]) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }

    private static boolean isSameParent(int n1, int n2) {
        return find(n1) == find(n2);
    }

    static class Node {
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
