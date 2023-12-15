package baekjoon_java.P1414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		parent = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		List<Node> edges = new ArrayList<>();
		int totalSum = 0;

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				char c = s.charAt(j);

				if (c == '0') {
					continue;
				}

				if (Character.isLowerCase(c)) {
					edges.add(new Node(i, j, c - 'a' + 1));
					totalSum += c - 'a' + 1;
				}

				if (Character.isUpperCase(c)) {
					edges.add(new Node(i, j, c - 'A' + 27));
					totalSum += c - 'A' + 27;
				}
			}
		}

		edges.sort((o1, o2) -> o1.cost - o2.cost);

		for (Node edge : edges) {
			if (!isSameParent(edge.start, edge.end)) {
				union(edge.start, edge.end);
				totalSum -= edge.cost;
			}
		}

		int value = parent[0];
		for (int i = 0; i < parent.length; i++) {
			find(i);
			if (value != parent[i]) {
				System.out.println(-1);
				return;
			}
		}

		System.out.println(totalSum);
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x < y) {
			parent[y] = x;
		}
		if (x > y) {
			parent[x] = y;
		}
	}

	private static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	private static boolean isSameParent(int x, int y) {
		return find(x) == find(y);
	}

	private static class Node {
		int start;
		int end;
		int cost;

		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}

}
