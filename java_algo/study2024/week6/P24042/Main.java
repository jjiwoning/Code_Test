package study2024.week6.P24042;

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

	private static int n;

	private static int m;

	private static List<List<Node>> edges;

	private static long[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		edges = new ArrayList<>();
		distance = new long[n + 1];
		Arrays.fill(distance, Long.MAX_VALUE);

		for (int i = 0; i < n + 1; i++) {
			edges.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int vertex1 = Integer.parseInt(st.nextToken());
			int vertex2 = Integer.parseInt(st.nextToken());
			edges.get(vertex1).add(new Node(vertex2, i));
			edges.get(vertex2).add(new Node(vertex1, i));
		}

		System.out.println(dijkstra(1) + 1);
	}

	private static long dijkstra(int start) {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(o -> o.time));
		priorityQueue.add(new Node(start, 0));
		distance[start] = 0;

		while (!priorityQueue.isEmpty()) {
			Node now = priorityQueue.poll();

			if (now.vertex == n) {
				return now.time;
			}

			if (now.time > distance[now.vertex]) {
				continue;
			}

			for (Node next : edges.get(now.vertex)) {
				long nextTime = next.time;

				if (nextTime < now.time) {
					// 이 경우 현재 시간에 맞게 nextTime을 조정해줘야 된다.
					long cycle = (now.time - nextTime) / m;
					if ((now.time - nextTime) % m != 0) {
						cycle++;
					}
					nextTime += m * cycle;
				}

				if (distance[next.vertex] > nextTime) {
					distance[next.vertex] = nextTime;
					priorityQueue.add(new Node(next.vertex, nextTime));
				}
			}

		}

		return distance[n];
	}
}

class Node {
	int vertex;
	long time;

	public Node(int vertex, long time) {
		this.vertex = vertex;
		this.time = time;
	}
}
