package baekjoon_java.P14621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static int[] parent;

	private static List<Edge> edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[] arr = new char[n + 1];
		parent = new int[n + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			arr[i] = st.nextToken().charAt(0);
			parent[i] = i;
		}

		edges = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			if (arr[s] == arr[e]) {
				continue;
			}

			edges.add(new Edge(s, e, cost));
		}

		int cnt = 0;
		int answer = 0;
		edges.sort((o1, o2) -> o1.weight - o2.weight);

		for (Edge edge : edges) {
			if (!isSameParent(edge.start, edge.end)) {
				union(edge.start, edge.end);
				cnt++;
				answer += edge.weight;
			}
		}

		if (cnt != n - 1) {
			System.out.println(-1);
			return;
		}
		System.out.println(answer);
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			if (x < y) {
				parent[y] = x;
			}
			if (x > y) {
				parent[x] = y;
			}
		}
	}

	private static boolean isSameParent(int x, int y) {
		return find(x) == find(y);
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
}

class Edge {
	int start;
	int end;
	int weight;

	public Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}
