package Programmers_java.kakao118669;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {

	private List<List<Node>> nodes;
	private Set<Integer> gates;
	private Set<Integer> summits;
	private int[] answer;

	public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		answer = new int[]{n + 1, Integer.MAX_VALUE}; // 산봉우리 번호, intensity의 최솟값
		nodes = new ArrayList<>();
		this.summits = new HashSet<>();
		this.gates = new HashSet<>();

		for (int gate : gates) {
			this.gates.add(gate);
		}

		for (int summit : summits) {
			this.summits.add(summit);
		}

		for (int i = 0; i < n + 1; i++) {
			nodes.add(new ArrayList<>());
		}

		for (int[] path : paths) {
			nodes.get(path[0]).add(new Node(path[1], path[2]));
			nodes.get(path[1]).add(new Node(path[0], path[2]));
		}

		dijkstra(this.gates, n);

		return answer;
	}

	private void dijkstra(Set<Integer> gates, int n) {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		int[] distance = new int[n + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		for (Integer gate : gates) {
			priorityQueue.add(new Node(gate, 0));
			distance[gate] = 0;
		}

		while (!priorityQueue.isEmpty()) {
			Node node = priorityQueue.poll();

			if (node.cost > distance[node.end]) {
				continue;
			}

			if (summits.contains(node.end)) {
				if (answer[1] > node.cost) {
					answer[1] = node.cost;
					answer[0] = node.end;
				}
				if (answer[1] == node.cost) {
					answer[0] = Math.min(answer[0], node.end);
				}
				continue;
			}

			for (Node nextNode : nodes.get(node.end)) {
				if (distance[nextNode.end] > Math.max(nextNode.cost, node.cost)) {
					distance[nextNode.end] = Math.max(node.cost, nextNode.cost);
					priorityQueue.add(new Node(nextNode.end, distance[nextNode.end]));
				}
			}
		}
	}
}

class Node {

	int end;
	int cost;

	public Node(int end, int cost) {
		this.end = end;
		this.cost = cost;
	}
}
