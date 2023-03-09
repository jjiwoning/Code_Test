package study.week7.P1738;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Main {

    static int n;
    static boolean[] visited;
    static int[] answer;
    static StringBuilder sb;
    static int[] path;
    static List<Edge> edgeList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());

        answer = new int[n];
        path = new int[n + 1];
        Arrays.fill(path, MIN_VALUE);

        edgeList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            edgeList.add(new Edge(parseInt(st.nextToken()), parseInt(st.nextToken()), parseInt(st.nextToken())));
        }

        path[1] = 0;
        visited = new boolean[n + 1];

        if (!bellmanFord(n, path, edgeList)) {
            System.out.println(-1);
            return;
        }

        visited = new boolean[n + 1];
        visited[1] = true;
        answer[0] = 1;

        dfs(1, 1);

        if (!visited[n]) {
            System.out.println(-1);
            return;
        }

        System.out.println(sb);
    }

    private static boolean bellmanFord(int n, int[] path, List<Edge> edgeList) {
        for (int i = 1; i < n + 1; i++) {
            for (Edge edge : edgeList) {
                if (path[edge.start] == MIN_VALUE) {
                    continue;
                }

                if (path[edge.end] < path[edge.start] + edge.cost) {
                    path[edge.end] = path[edge.start] + edge.cost;

                    if (i == n) {
                        visited = new boolean[n + 1];
                        visited[edge.start] = true;
                        if (findCycle(edge.start)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static boolean findCycle(int start) {
        if (start == n) {
            return true;
        }

        boolean check = false;

        for (Edge edge : edgeList) {
            if (edge.start != start) {
                continue;
            }
            if (!visited[edge.end]) {
                visited[edge.end] = true;
                check = check || findCycle(edge.end);
            }
        }

        return check;
    }

    private static void dfs(int start, int level) {
        if (start == n) {
            if (sb == null) {
                sb = new StringBuilder();
                for (int i = 0; i < level; i++) {
                    sb.append(answer[i]).append(" ");
                }
            }
            return;
        }

        for (Edge edge : edgeList) {
            if (edge.start != start) {
                continue;
            }

            if (!visited[edge.end] && path[edge.end] == (path[edge.start] + edge.cost)) {
                visited[edge.end] = true;
                answer[level] = edge.end;
                dfs(edge.end, level + 1);
            }
        }
    }

    private static class Edge {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
