package study2024.week4.P1030;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());

		int s = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int r1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());

		System.out.println(new Solution().solution(s, n, k, r1, r2, c1, c2));
	}
}

class Solution {

	private int r1;
	private int r2;
	private int c1;
	private int c2;
	private int[][] board;

	public StringBuilder solution(
		int s,
		int n,
		int k,
		int r1,
		int r2,
		int c1,
		int c2
	) {
		board = new int[51][51];
		this.r1 = r1;
		this.r2 = r2;
		this.c1 = c1;
		this.c2 = c2;

		dfs(0, 0, s, k, n);

		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < r2 - r1 + 1; i++) {
			for (int j = 0; j < c2 - c1 + 1; j++) {
				answer.append(board[i][j]);
			}
			answer.append("\n");
		}

		return answer;
	}

	// 1(s = 1) -> 3(s = 2) -> 9 -> 27
	// 3(s = 1) -> 15(s = 2) -> 75
	private void dfs(int startX, int startY, int nowS, int k, int n) {
		if (nowS == 0) {
			return;
		}

		if (startX > r2 || startY > c2) {
			return;
		}

		int nowSize = (int)Math.pow(n, nowS);

		if (startX + nowSize < r1 || startY + nowSize < c1) {
			return;
		}

		int fillBlack = (int)Math.pow(n, nowS - 1) * k;

		int start = (nowSize - fillBlack) / 2;

		int startX1 = Math.max(r1, startX + start);
		int startY1 = Math.max(c1, startY + start);
		int endX = Math.min(r2 + 1, startX + start + fillBlack);
		int endY = Math.min(c2 + 1, startY + start + fillBlack);

		for (int i = startX1; i < endX; i++) {
			for (int j = startY1; j < endY; j++) {
				board[i - r1][j - c1] = 1;
			}
		}

		int nextSize = (int)Math.pow(n, nowS - 1);

		if (nowS - 1 == 0) {
			return;
		}

		// nextLoop
		for (int i = startX; i < startX + nowSize; i += nextSize) {
			for (int j = startY; j < startY + nowSize; j += nextSize) {
				if (i > r2 || j > c2) {
					continue;
				}
				if (i + nextSize < r1 || j + nextSize < c1) {
					continue;
				}
				dfs(i, j, nowS - 1, k, n);
			}
		}
	}
}
