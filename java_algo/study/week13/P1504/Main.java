package study.week13.P1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Comparator.comparingInt;

public class Main {

    static List<Node>[] graph;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }

        st = new StringTokenizer(br.readLine());
        int want1 = Integer.parseInt(st.nextToken());
        int want2 = Integer.parseInt(st.nextToken());

        int answer1 = 0; // 1 -> want1 -> want2 -> n
        int answer2 = 0; // 1 -> want2 -> want1 -> n

        visited = new boolean[n + 1];
        distance = new int[n + 1];
        Arrays.fill(distance, 200000001);
        dijkstra(1);

        answer1 += distance[want1];
        answer2 += distance[want2];

        visited = new boolean[n + 1];
        distance = new int[n + 1];
        Arrays.fill(distance, 200000001);
        dijkstra(want1);

        answer1 += distance[want2];
        answer2 += distance[n];

        visited = new boolean[n + 1];
        distance = new int[n + 1];
        Arrays.fill(distance, 200000001);
        dijkstra(want2);

        answer2 += distance[want1];
        answer1 += distance[n];

        if (Math.min(answer1, answer2) >= 200000001) {
            System.out.println(-1);
            return;
        }

        System.out.println(Math.min(answer1, answer2));
    }

    static void dijkstra(int start) {

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(comparingInt(o -> o.cost));
        priorityQueue.add(new Node(start, 0));
        distance[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            if (!visited[node.vertex]) {
                visited[node.vertex] = true;
            }

            for (Node n : graph[node.vertex]) {
                if (!visited[n.vertex] && distance[n.vertex] > node.cost + n.cost) {
                    distance[n.vertex] = node.cost + n.cost;
                    priorityQueue.add(new Node(n.vertex, distance[n.vertex]));
                }
            }
        }
    }

    static class Node {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

}
