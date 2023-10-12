package baekjoon_java.P2637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] edgeCount;
    private static int[] answer;
    private static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        edgeCount = new int[n + 1];
        answer = new int[n + 1];
        graph = new List[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;

        boolean[] defaultParts = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edgeCount[end]++;
            defaultParts[start] = true;
            graph[start].add(new Node(end, cost));
        }

        topologicalSort(n);

        for (int i = 1; i < n + 1; i++) {
            if (!defaultParts[i]) {
                System.out.println(i + " " + answer[i]);
            }
        }
    }

    private static void topologicalSort(int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 1));
        answer[n] = 1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            List<Node> nodes = graph[now.start];

            for (Node node : nodes) {
                edgeCount[node.start]--;
                answer[node.start] += answer[now.start] * node.cost;

                if (edgeCount[node.start] == 0) {
                    queue.add(new Node(node.start, answer[node.start]));
                }
            }
        }
    }
}

class Node {

    int start;
    int cost;

    public Node(int start, int cost) {
        this.start = start;
        this.cost = cost;
    }
}
