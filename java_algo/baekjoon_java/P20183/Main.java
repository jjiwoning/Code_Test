package baekjoon_java.P20183;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static List<List<Node>> edges;
	private static long[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		long money = Long.parseLong(st.nextToken());

		edges = new ArrayList<>();
		distance = new long[n + 1];

		for (int i = 0; i < n + 1; i++) {
			edges.add(new ArrayList<>());
			distance[i] = Long.MAX_VALUE;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			long cost = Long.parseLong(st.nextToken());

			edges.get(s).add(new Node(e, cost, cost));
			edges.get(e).add(new Node(s, cost, cost));
		}

		dijkstra(start, money);

		if (distance[end] == Long.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(distance[end]);
	}

	private static void dijkstra(int start, long maxMoney) {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> {
			if (o1.maxCost == o2.maxCost) {
				return Long.compare(o1.totalCost, o2.totalCost);
			}
			return Long.compare(o1.maxCost, o2.maxCost);
		});

		priorityQueue.add(new Node(start, 0, 0));

		while (!priorityQueue.isEmpty()) {
			Node now = priorityQueue.poll();

			if (now.maxCost > distance[now.vertex]) {
				continue;
			}

			for (Node next : edges.get(now.vertex)) {
				if (now.totalCost + next.totalCost > maxMoney) {
					continue;
				}
				if (Math.max(now.maxCost, next.maxCost) < distance[next.vertex]) {
					distance[next.vertex] = Math.max(now.maxCost, next.maxCost);
					priorityQueue.add(new Node(next.vertex, now.totalCost + next.maxCost, distance[next.vertex]));
				}
			}
		}
	}
}

class Node {
	int vertex;
	long totalCost;
	long maxCost;

	public Node(int vertex, long totalCost, long maxCost) {
		this.vertex = vertex;
		this.totalCost = totalCost;
		this.maxCost = maxCost;
	}
}
