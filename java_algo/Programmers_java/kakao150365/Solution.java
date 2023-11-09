package Programmers_java.kakao150365;

public class Solution {

	private char[] movingChar = new char[] {'d', 'l', 'r', 'u'};
	private int[] dx = new int[]{1, 0, 0, -1};
	private int[] dy = new int[]{0, -1, 1, 0};

	private String answer;
	private int n;
	private int m;
	private int r;
	private int c;
	private int k;

	public String solution(int n, int m, int x, int y, int r, int c, int k) {
		init(n, m, r, c, k);
		int minDistance = findDistance(x, y, r, c);

		if (k < minDistance || (k - minDistance) % 2 == 1) {
			return "impossible";
		}

		dfs(x, y, 0, "");

		return answer;
	}

	private void dfs(int x, int y, int move, String s) {
		if (move == this.k && x == this.r && y == this.c) {
			answer = s;
			return;
		}

		if (answer != null) {
			return;
		}

		if (findDistance(x, y, r, c) > this.k - move) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];

			if (mx <= 0 || mx > n || my <= 0 || my > m) {
				continue;
			}
			String make = s + movingChar[i];
			dfs(mx, my, move + 1, make);
		}
	}

	private int findDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	private void init(int n, int m, int r, int c, int k) {
		this.n = n;
		this.m = m;
		this.r = r;
		this.c = c;
		this.k = k;
	}
}
