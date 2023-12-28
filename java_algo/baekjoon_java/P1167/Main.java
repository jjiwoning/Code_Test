package baekjoon_java.P1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static List<List<Node>> edges;
	private static boolean[] visited;
	private static int maxDistance;
	private static int nodeNumber;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];
		edges = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			edges.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());

			while (true) {
				int v2 = Integer.parseInt(st.nextToken());
				if (v2 == -1) {
					break;
				}
				int cost = Integer.parseInt(st.nextToken());

				edges.get(v1).add(new Node(v2, cost));
			}
		}

		maxDistance = -1;
		nodeNumber = -1;

		visited[1] = true;
		dfs(1, 0);

		visited = new boolean[n + 1];
		visited[nodeNumber] = true;
		dfs(nodeNumber, 0);

		System.out.println(maxDistance);
	}

	private static void dfs(int num, int cost) {
		if (cost > maxDistance) {
			maxDistance = cost;
			nodeNumber = num;
		}

		for (Node node : edges.get(num)) {
			if (!visited[node.vertex]) {
				visited[node.vertex] = true;
				dfs(node.vertex, cost + node.cost);
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
