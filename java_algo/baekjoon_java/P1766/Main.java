package baekjoon_java.P1766;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int[] edgeCount;
    private static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        edgeCount = new int[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            edgeCount[e]++;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 1; i < n + 1; i++) {
            if (edgeCount[i] == 0) {
                priorityQueue.add(i);
            }
        }

        StringBuilder answer = new StringBuilder();

        while (!priorityQueue.isEmpty()) {
            Integer now = priorityQueue.poll();
            answer.append(now).append(" ");

            List<Integer> nextNumbers = graph.get(now);

            for (Integer nextNumber : nextNumbers) {
                edgeCount[nextNumber]--;
                if (edgeCount[nextNumber] == 0) {
                    priorityQueue.add(nextNumber);
                }
            }
        }

        System.out.println(answer);
    }
}
