package study.week7.P1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Main {

    static int[] distance;
    static boolean[] visited;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int m = parseInt(br.readLine());

        distance = new int[n + 1];
        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            distance[i] = MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = parseInt(st.nextToken());
            int e = parseInt(st.nextToken());
            int c = parseInt(st.nextToken());
            graph[s].add(new Node(e, c));
        }

        st = new StringTokenizer(br.readLine());

        int answer = dijkstra(parseInt(st.nextToken()), parseInt(st.nextToken()));

        System.out.println(answer);
    }

    private static int dijkstra(int start, int end) {
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

        return distance[end];
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
