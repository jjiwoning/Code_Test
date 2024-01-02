package baekjoon_java.P17835;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static final long MAX_VALUE = 500000L * 100000 + 123L;

	private static long[] distance;

	private static List<List<Node>> edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 도시의 수
		int m = Integer.parseInt(st.nextToken()); // 간선의 수 (단방향 간선)
		int k = Integer.parseInt(st.nextToken()); // 면접장의 수

		edges = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			edges.add(new ArrayList<>());
		}

		distance = new long[n + 1];
		Arrays.fill(distance, MAX_VALUE);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edges.get(e).add(new Node(s, c));
		}

		int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		dijkstra(start);

		long maxDistance = -1;

		for (int i = 1; i < n + 1; i++) {
			maxDistance = Math.max(maxDistance, distance[i]);
		}

		for (int i = 1; i < n + 1; i++) {
			if (distance[i] == maxDistance) {
				System.out.println(i);
				System.out.println(maxDistance);
				return;
			}
		}

	}

	private static void dijkstra(int[] start) {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(o -> o.cost));
		for (int num : start) {
			priorityQueue.add(new Node(num, 0));
			distance[num] = 0;
		}

		while (!priorityQueue.isEmpty()) {
			Node now = priorityQueue.poll();

			if (distance[now.vertex] < now.cost) {
				continue;
			}

			for (Node next : edges.get(now.vertex)) {
				if (now.cost + next.cost < distance[next.vertex]) {
					distance[next.vertex] = now.cost + next.cost;
					priorityQueue.add(new Node(next.vertex, distance[next.vertex]));
				}
			}
		}
	}
}

class Node {
	int vertex;
	long cost;

	public Node(int vertex, long cost) {
		this.vertex = vertex;
		this.cost = cost;
	}
}
