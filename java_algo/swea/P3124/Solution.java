package swea.P3124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Solution {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        StringTokenizer st;

        for (int testCase = 1; testCase <= t; testCase++) {
            st = new StringTokenizer(br.readLine());

            int v = parseInt(st.nextToken());
            int e = parseInt(st.nextToken());

            parent = new int[v + 1];
            PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

            long finalCost = 0;

            for (int i = 1; i < v + 1; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                priorityQueue.add(new Node(parseInt(st.nextToken()), parseInt(st.nextToken()), parseInt(st.nextToken())));
            }

            while (!priorityQueue.isEmpty()) {
                Node now = priorityQueue.poll();
                if (!isSameParent(now.v1, now.v2)) {
                    union(now.v1, now.v2);
                    finalCost += now.cost;
                }
            }

            answer.append("#").append(testCase).append(" ").append(finalCost).append("\n");
        }

        System.out.println(answer);
    }

    private static void union(int v1, int v2) {
        v1 = find(v1);
        v2 = find(v2);

        if (v1 < v2) {
            parent[v2] = v1;
        }

        if (v1 > v2) {
            parent[v1] = v2;
        }
    }

    private static int find(int v1) {
        if (v1 == parent[v1]) {
            return v1;
        }

        return parent[v1] = find(parent[v1]);
    }

    private static boolean isSameParent(int v1, int v2) {
        return find(v1) == find(v2);
    }

    static class Node {
        int v1;
        int v2;
        int cost;

        public Node(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }
}
