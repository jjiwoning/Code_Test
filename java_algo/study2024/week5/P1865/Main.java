package study2024.week5.P1865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {

	private static final int MAX_VAL = 98765432;

	private int n;

	private int[] distance;

	private List<Edge> edges;

	public String solution(int n, List<Edge> edges) {
		this.n = n;
		this.distance = new int[n + 1];
		this.edges = edges;

		if (bellmanFord()) {
			return "YES";
		}
		return "NO";
	}

	private boolean bellmanFord() {
		for (int i = 1; i < n + 1; i++) {
			for (Edge edge : edges) {
				if (distance[edge.start] == MAX_VAL) {
					continue;
				}
				if (distance[edge.end] > distance[edge.start] + edge.cost) {
					distance[edge.end] = distance[edge.start] + edge.cost;

					if (i == n) {
						return true;
					}
				}
			}
		}
		return false;
	}
}

class Edge {
	int start;
	int end;
	int cost;

	public Edge(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		StringBuilder answer = new StringBuilder();

		Solution solution = new Solution();

		for (int testCase = 0; testCase < t; testCase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			List<Edge> edges = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());

				edges.add(new Edge(start, end, cost));
				edges.add(new Edge(end, start, cost));
			}

			for (int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());

				edges.add(new Edge(start, end, -1 * cost));
			}

			answer.append(solution.solution(n, edges)).append("\n");
		}

		System.out.println(answer);
	}
}
