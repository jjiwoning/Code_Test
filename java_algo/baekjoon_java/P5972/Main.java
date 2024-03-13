package baekjoon_java.P5972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static final int MAX_DISTANCE = 777777777;

	private static List<List<Edge>> edges;
	private static int[] distance;

	public static void main(String[] args) throws IOException {
		final var br = new BufferedReader(new InputStreamReader(System.in));

		var st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		distance = new int[n + 1];
		edges = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			distance[i] = MAX_DISTANCE;
			edges.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int vertex1 = Integer.parseInt(st.nextToken());
			int vertex2 = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());

			edges.get(vertex1).add(new Edge(vertex2, distance));
			edges.get(vertex2).add(new Edge(vertex1, distance));
		}

		dijkstra(1);

		System.out.println(distance[n]);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		distance[start] = 0;
		priorityQueue.add(new Edge(start, 0));

		while (!priorityQueue.isEmpty()) {
			Edge now = priorityQueue.poll();

			if (distance[now.vertex] < now.cost) {
				continue;
			}

			for (Edge next : edges.get(now.vertex)) {
				if (distance[next.vertex] > now.cost + next.cost) {
					distance[next.vertex] = now.cost + next.cost;
					priorityQueue.add(new Edge(next.vertex, distance[next.vertex]));
				}
			}
		}
	}
}

class Edge {
	int vertex;
	int cost;

	public Edge(int vertex, int cost) {
		this.vertex = vertex;
		this.cost = cost;
	}
}
