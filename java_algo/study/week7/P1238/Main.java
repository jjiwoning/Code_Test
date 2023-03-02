package study.week7.P1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.*;
import static java.util.Comparator.*;

public class Main {

    static int x;
    static ArrayList<Node>[] graph;
    static int[] distance;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());
        x = parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        distance = new int[n + 1];
        answer = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            distance[i] = MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            graph[parseInt(st.nextToken())].add(new Node(parseInt(st.nextToken()), parseInt(st.nextToken())));
        }

        dijkstra(x);

        for (int i = 1; i < n + 1; i++) {
            answer[i] = distance[i];
            distance[i] = MAX_VALUE;
            visited[i] = false;
        }

        for (int i = 1; i < n + 1; i++) {
            if (i == x) {
                continue;
            }
            dijkstra(i);
            addAnswerAndInit(i);
        }

        int findAnswer = 0;

        for (int dist : answer) {
            findAnswer = Math.max(findAnswer, dist);
        }

        System.out.println(findAnswer);
    }

    private static void dijkstra(int start) {

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(comparingInt(o -> o.cost));
        priorityQueue.add(new Node(start, 0));
        distance[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node now = priorityQueue.poll();

            if (visited[now.v]) {
                continue;
            }

            visited[now.v] = true;

            for (Node next : graph[now.v]) {
                if (!visited[next.v] && distance[next.v] > now.cost + next.cost) {
                    distance[next.v] = now.cost + next.cost;
                    priorityQueue.add(new Node(next.v, distance[next.v]));
                }
            }
        }

    }

    private static void addAnswerAndInit(int start) {
        answer[start] += distance[x];
        Arrays.fill(distance, MAX_VALUE);
        Arrays.fill(visited, false);
    }

    private static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}
