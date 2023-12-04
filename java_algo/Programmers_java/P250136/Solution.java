package Programmers_java.P250136;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	private Node[][] map;
	private boolean[][] visited;
	private int[][] land;
	private int[] dx = new int[] {1, -1, 0, 0};
	private int[] dy = new int[] {0, 0, 1, -1};

	public int solution(int[][] land) {
		int answer = 0;
		this.land = land;
		visited = new boolean[land.length][land[0].length];
		map = new Node[land.length][land[0].length];
		int type = 0;

		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[0].length; j++) {
				if (!visited[i][j] && land[i][j] == 1) {
					visited[i][j] = true;
					Node node = new Node(type++, 1);
					map[i][j] = node;
					dfs(i, j, node);
				}
			}
		}

		for (int y = 0; y < land[0].length; y++) {
			Set<Integer> set = new HashSet<>();
			int find = 0;

			for (int x = 0; x < land.length; x++) {
				if (map[x][y] != null) {
					if (set.contains(map[x][y].number)) {
						continue;
					}
					set.add(map[x][y].number);
					find += map[x][y].value;
				}
			}

			answer = Math.max(find, answer);
		}

		return answer;
	}

	private void dfs(int x, int y, Node node) {
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];

			if (mx < 0 || mx >= visited.length || my < 0 || my >= visited[0].length) {
				continue;
			}

			if (land[mx][my] == 0) {
				continue;
			}

			if (visited[mx][my]) {
				continue;
			}

			visited[mx][my] = true;

			node.value += 1;
			map[mx][my] = node;

			dfs(mx, my, node);
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new int[][] {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0},
			{1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}});
	}
}

class Node {
	int number;
	int value;

	public Node(int number, int value) {
		this.number = number;
		this.value = value;
	}
}
