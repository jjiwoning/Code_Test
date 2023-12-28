package codetree.sprint1.p4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static List<List<Integer>> graph;
	private static int[] degree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}
		degree = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph.get(start).add(end);
			degree[end]++;
		}

		StringBuilder answer = new StringBuilder();

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		for (int i = 1; i < n + 1; i++) {
			if (degree[i] == 0) {
				priorityQueue.add(i);
			}
		}

		while (!priorityQueue.isEmpty()) {
			Integer now = priorityQueue.poll();
			answer.append(now).append(" ");

			for (Integer next : graph.get(now)) {
				degree[next]--;
				if (degree[next] == 0) {
					priorityQueue.add(next);
				}
			}
		}

		System.out.println(answer);
	}
}
