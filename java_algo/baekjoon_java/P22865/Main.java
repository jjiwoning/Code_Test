package baekjoon_java.P22865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static int[] distance;

	private static List<List<Node>> edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		distance = new int[n + 1];
		Arrays.fill(distance, 987654321);

		edges = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			edges.add(new ArrayList<>());
		}

		int[] arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int vertex1 = Integer.parseInt(st.nextToken());
			int vertex2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			edges.get(vertex1).add(new Node(vertex2, cost));
			edges.get(vertex2).add(new Node(vertex1, cost));
		}

		dijkstra(arr, distance);

		int maxDistance = 0;

		for (int i = 1; i < distance.length; i++) {
			maxDistance = Math.max(maxDistance, distance[i]);
		}

		for (int i = 1; i < distance.length; i++) {
			if (maxDistance == distance[i]) {
				System.out.println(i);
				return;
			}
		}
	}

	private static void dijkstra(int[] start, int[] distance) {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		for (int num : start) {
			priorityQueue.add(new Node(num, 0));
			distance[num] = 0;
		}

		while (!priorityQueue.isEmpty()) {
			Node now = priorityQueue.poll();

			if (now.cost > distance[now.vertex]) {
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
	int cost;

	public Node(int vertex, int cost) {
		this.vertex = vertex;
		this.cost = cost;
	}
}
