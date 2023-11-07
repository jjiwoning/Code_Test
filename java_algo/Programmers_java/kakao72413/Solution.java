package Programmers_java.kakao72413;

public class Solution {

	private static final int MAX_VALUE = 77777777;

	private int[][] graph;

	// 합승을 구현하는게 목적
	// 다익스트라 or 플로이드워셜
	// 200^3 (플로이드)
	// a -> x, b -> x, s -> x의 합의 최소
	public int solution(int n, int s, int a, int b, int[][] fares) {
		initGraph(fares, n);
		int answer = Integer.MAX_VALUE;

		for (int mid = 1; mid < n + 1; mid++) {
			for (int start = 1; start < n + 1; start++) {
				for (int end = 1; end < n + 1; end++) {
					graph[start][end] = Math.min(graph[start][end], graph[start][mid] + graph[mid][end]);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			answer = Math.min(answer, graph[s][i] + graph[a][i] + graph[b][i]);
		}

		return answer;
	}

	private void initGraph(int[][] fares, int n) {
		graph = new int[n + 1][n + 1];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == j) {
					continue;
				}
				graph[i][j] = MAX_VALUE;
			}
		}

		for (int[] fare : fares) {
			graph[fare[0]][fare[1]] = fare[2];
			graph[fare[1]][fare[0]] = fare[2];
		}
	}
}
