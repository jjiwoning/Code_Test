package study.week7.P1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Node>[] graph;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        graph = new ArrayList[v + 1];
        distance = new int[v + 1];
        visited = new boolean[v + 1];

        for (int i = 1; i < v + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[startNode].add(new Node(endNode, cost));
        }

        dijkstra(start);

        printAnswer(v);
    }

    private static void printAnswer(int v) {
        for (int i = 1; i < v + 1; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(distance[i]);
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        priorityQueue.add(new Node(start, 0));
        distance[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node now = priorityQueue.poll();

            if (visited[now.v]) {
                continue;
            }

            visited[now.v] = true;

            for (Node next : graph[now.v]) {
                if (!visited[next.v] && distance[next.v] > next.cost + now.cost) {
                    distance[next.v] = next.cost + now.cost;
                    priorityQueue.add(new Node(next.v, distance[next.v]));
                }
            }
        }
    }

    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}
