package baekjoon_java.P20924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static List<List<Node>> edges;

	private static int root;
	private static int gigaNode;
	private static int rootToGigaDistance;
	private static int maximumLeafDistance;

	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 노드의 개수
		root = Integer.parseInt(st.nextToken()); // 트리의 시작점 (루트 노드)

		edges = new ArrayList<>();
		visited = new boolean[n + 1];

		for (int i = 0; i < n + 1; i++) {
			edges.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int vertex1 = Integer.parseInt(st.nextToken());
			int vertex2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			edges.get(vertex1).add(new Node(vertex2, cost));
			edges.get(vertex2).add(new Node(vertex1, cost));
		}

		visited[root] = true;
		rootDfs(root);

		visited[gigaNode] = true;
		leafDfs(gigaNode, 0);

		System.out.println(rootToGigaDistance + " " + maximumLeafDistance);
	}

	private static void rootDfs(int start) {
		if (edges.get(start).size() > 2
			|| (edges.get(start).size() == 1 && start != root)
			|| (edges.get(start).size() == 2 && start == root)
		) {
			gigaNode = start;
			return;
		}

		for (Node node : edges.get(start)) {
			if (!visited[node.vertex]) {
				visited[node.vertex] = true;
				rootToGigaDistance += node.cost;
				rootDfs(node.vertex);
			}
		}
	}

	private static void leafDfs(int start, int distance) {
		if (edges.get(start).size() == 1) {
			maximumLeafDistance = Math.max(maximumLeafDistance, distance);
			return;
		}

		for (Node node : edges.get(start)) {
			if (!visited[node.vertex]) {
				visited[node.vertex] = true;
				leafDfs(node.vertex, distance + node.cost);
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
