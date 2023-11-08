package Programmers_java.kakao72413;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionDijkstra {

	private static final int MAX_VALUE = 100000 * 200 + 1;

	private int n;
	private List<List<Node>> graph;
	private int[][] distance;

	public int solution(int n, int s, int a, int b, int[][] fares) {
		this.n = n;
		init(fares, n);
		int answer = Integer.MAX_VALUE;

		dijkstra(s);
		dijkstra(a);
		dijkstra(b);

		for (int i = 1; i < n + 1; i++) {
			answer = Math.min(answer, distance[s][i] + distance[a][i] + distance[b][i]);
		}

		return answer;
	}

	private void init(int[][] fares, int n) {
		graph = new ArrayList<>();
		distance = new int[n + 1][n + 1];

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
			Arrays.fill(distance[i], MAX_VALUE);
			distance[i][i] = 0;
		}

		for (int[] fare : fares) {
			graph.get(fare[0]).add(new Node(fare[1], fare[2]));
			graph.get(fare[1]).add(new Node(fare[0], fare[2]));
		}
	}

	private void dijkstra(int start) {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		boolean[] visited = new boolean[n + 1];

		priorityQueue.add(new Node(start, 0));

		while (!priorityQueue.isEmpty()) {
			Node node = priorityQueue.poll();

			if (visited[node.v]) {
				continue;
			}

			visited[node.v] = true;

			for (Node next : graph.get(node.v)) {
				if (!visited[next.v] && distance[start][next.v] > next.cost + node.cost) {
					distance[start][next.v] = next.cost + node.cost;
					priorityQueue.add(new Node(next.v, distance[start][next.v]));
				}
			}
		}
	}
}

class Node {
	int v;
	int cost;

	public Node(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}
}
