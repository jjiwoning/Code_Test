package Programmers_java.kakao258711;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static final int MAX_VALUE = 1000001;
	private int[] answer; // 도넛 모양 그래프의 수, 막대 모양 그래프의 수, 8자 모양

	private boolean[] visited;

	private List<List<Integer>> edges;

	public int[] solution(int[][] edges) {
		answer = new int[] {0, 0, 0, 0};
		int maxValue = 0;
		int[] in = new int[MAX_VALUE];
		int[] out = new int[MAX_VALUE];

		for (int[] edge : edges) {
			maxValue = Math.max(maxValue, edge[0]);
			maxValue = Math.max(maxValue, edge[1]);
			in[edge[1]]++;
			out[edge[0]]++;
		}

		int root = findRoot(in, out);

		answer[0] = root;

		this.edges = new ArrayList<>();

		for (int i = 0; i < maxValue + 1; i++) {
			this.edges.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			this.edges.get(edge[0]).add(edge[1]);
		}

		visited = new boolean[MAX_VALUE];

		for (Integer start : this.edges.get(root)) {
			dfs(start, start, 0);
		}

		return answer;
	}

	private int findRoot(int[] in, int[] out) {
		for (int i = 0; i < MAX_VALUE; i++) {
			if (out[i] > 1 && in[i] == 0) {
				return i;
			}
		}
		throw new IllegalArgumentException();
	}

	private void dfs(int start, int now, int depth) {
		if (depth != 0 && start == now) {
			// 도넛
			answer[1]++;
			return;
		}

		if (this.edges.get(now).size() == 2) {
			// 8자
			answer[3]++;
			return;
		}

		if (this.edges.get(now).size() == 0) {
			// 막대
			answer[2]++;
			return;
		}

		for (Integer next : this.edges.get(now)) {
			if (!visited[next]) {
				visited[next] = true;
				dfs(start, next, depth + 1);
			}
		}
	}
}
