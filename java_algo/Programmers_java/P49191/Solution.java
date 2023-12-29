package Programmers_java.P49191;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	private boolean[][] winVisited;
	private boolean[][] loseVisited;

	private List<List<Integer>> winGraph;
	private List<List<Integer>> loseGraph;

	public int solution(int n, int[][] results) {
		int answer = 0;

		winVisited = new boolean[n + 1][n + 1];
		loseVisited = new boolean[n + 1][n + 1];

		winGraph = new ArrayList<>();
		loseGraph = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			winGraph.add(new ArrayList<>());
			loseGraph.add(new ArrayList<>());
		}

		for (int[] result : results) {
			winGraph.get(result[0]).add(result[1]);
			loseGraph.get(result[1]).add(result[0]);
		}

		for (int i = 1; i < n + 1; i++) {
			winVisited[i][i] = true;
			dfs(i, i, winGraph, winVisited);
			loseVisited[i][i] = true;
			dfs(i, i, loseGraph, loseVisited);
		}

		for (int i = 1; i < n + 1; i++) {
			boolean canFindResult = true;
			for (int j = 1; j < n + 1; j++) {
				if (!winVisited[i][j] && !loseVisited[i][j]) {
					canFindResult = false;
					break;
				}
			}
			if (canFindResult) {
				answer++;
			}
		}

		return answer;
	}

	private void dfs(int start, int target, List<List<Integer>> graph, boolean[][] visited) {
		for (Integer next : graph.get(start)) {
			if (!visited[target][next]) {
				visited[target][next] = true;
				dfs(next, target, graph, visited);
			}
		}
	}

	public static void main(String[] args) {
		new Solution().solution(5, new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
	}
}
