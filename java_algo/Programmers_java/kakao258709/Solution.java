package Programmers_java.kakao258709;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	private int n;
	private int[] answer;
	private int[][] dices;
	private int[] aDices;
	private int[] bDices;
	private boolean[] visited;

	private int win;

	private int maxWin;

	private int[] aChoice;
	private int[] bChoice;

	private List<Integer> bResults;

	public int[] solution(int[][] dice) {
		this.dices = dice;
		this.n = dice.length / 2;
		this.visited = new boolean[dice.length];
		this.answer = new int[this.n];
		this.aDices = new int[this.n];
		this.bDices = new int[this.n];
		this.maxWin = 0;

		combination(0, 0);

		return answer;
	}

	private void combination(int depth, int index) {
		if (depth == n) {
			findBDices();

			this.win = 0;
			this.aChoice = new int[n];

			bResults = new ArrayList<>();
			this.bChoice = new int[n];
			chooseB(0);
			bResults.sort((o1, o2) -> o1 - o2);
			chooseA(0);

			System.out.println(win);

			if (maxWin < this.win) {
				this.maxWin = this.win;
				answer = new int[n];
				for (int i = 0; i < aDices.length; i++) {
					answer[i] = aDices[i] + 1;
				}
			}
			return;
		}

		if (index == this.dices.length) {
			return;
		}

		for (int i = index; i < dices.length; i++) {
			aDices[depth] = i;
			visited[i] = true;
			combination(depth + 1, i + 1);
			visited[i] = false;
			aDices[depth] = 0;
		}
	}

	private void findBDices() {
		this.bDices = new int[n];
		int index = 0;
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				bDices[index++] = i;
			}
		}
	}


	private void chooseB(int depth) {
		if (depth == n) {
			int result = 0;
			for (int i = 0; i < bChoice.length; i++) {
				result += dices[bDices[i]][bChoice[i]];
			}
			bResults.add(result);
			return;
		}

		for (int i = 0; i < 6; i++) {
			bChoice[depth] = i;
			chooseB(depth + 1);
			bChoice[depth] = 0;
		}
	}

	private void chooseA(int depth) {
		if (depth == n) {
			int result = 0;
			for (int i = 0; i < aChoice.length; i++) {
				result += dices[aDices[i]][aChoice[i]];
			}
			this.win += binarySearch(result);
			return;
		}

		for (int i = 0; i < 6; i++) {
			this.aChoice[depth] = i;
			chooseA(depth + 1);
			this.aChoice[depth] = 0;
		}
	}

	private int binarySearch(int target) {
		int start = 0;
		int end = bResults.size();

		while (start < end) {
			int mid = (start + end) / 2;

			if (bResults.get(mid) >= target) {
				end = mid;
			}
			if (bResults.get(mid) < target) {
				start = mid + 1;
			}
		}

		return end - 1;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution(new int[][] {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}});
	}
}
