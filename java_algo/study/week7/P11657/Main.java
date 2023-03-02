package study.week7.P11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static final long MAX_VAL = Long.MAX_VALUE;
    static long[] distance;
    static List<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        distance = new long[n + 1];
        Arrays.fill(distance, MAX_VAL);
        edgeList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            edgeList.add(new Edge(br.readLine().split(" ")));
        }

        printAnswer();
    }

    private static boolean bellmanFord(int start) {
        distance[start] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (Edge edge : edgeList) {
                if (distance[edge.from] == MAX_VAL) {
                    continue;
                }

                if (distance[edge.to] > distance[edge.from] + edge.cost) {
                    distance[edge.to] = distance[edge.from] + edge.cost;

                    if (i == n) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static void printAnswer() {
        if (bellmanFord(1)) {
            for (int i = 2; i < n + 1; i++) {
                if (distance[i] == MAX_VAL) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(distance[i]);
            }
            return;
        }
        System.out.println(-1);
    }

    private static class Edge {
        int from;
        int to;
        int cost;

        public Edge(String[] s) {
            this.from = Integer.parseInt(s[0]);
            this.to = Integer.parseInt(s[1]);
            this.cost = Integer.parseInt(s[2]);
        }
    }

}
