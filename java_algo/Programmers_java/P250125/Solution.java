package Programmers_java.P250125;

public class Solution {

	private int[] dx = new int[]{1, -1, 0, 0};
	private int[] dy = new int[]{0, 0, 1, -1};

	public int solution(String[][] board, int h, int w) {
		int answer = 0;

		for (int i = 0; i < 4; i++) {
			int mx = h + dx[i];
			int my = w + dy[i];

			if (mx < 0 || mx >= board.length || my < 0 || my >= board[0].length) {
				continue;
			}

			if (board[mx][my].equals(board[h][w])) {
				answer++;
			}
		}

		return answer;
	}
}
