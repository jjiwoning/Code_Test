package Programmers_java.P172927;

public class Solution {
	private static final String DIA = "diamond";

	private static final String IRON = "iron";

	private static final String STONE = "stone";

	private int answer = Integer.MAX_VALUE;

	private String[] minerals;

	public int solution(int[] picks, String[] minerals) {
		// picks[0] = 다이아, picks[1] = 철, picks[2] = 돌
		this.minerals = minerals;

		for (int i = 0; i < picks.length; i++) {
			if (picks[i] != 0) {
				int[] copy = copyArray(picks);
				copy[i]--;
				dfs(0, 0, copy, i);
			}
		}

		return answer;
	}

	private void dfs(int depth, int power, int[] picks, int pick) {
		// 종료 조건 1) 다 캔 경우
		if (depth == minerals.length) {
			answer = Math.min(answer, power);
			return;
		}

		// 백트래킹 -> 답이 될 수 없을 때
		if (power > answer) {
			return;
		}

		// 5번 사용
		int result = power;
		for(int i = depth; i < depth + 5; i++) {
			if (i == minerals.length) {
				answer = Math.min(answer, result);
				return;
			}

			int gem = convert(minerals[i]);

			if (pick <= gem) {
				result += 1;
			}

			if (pick - gem == 1) {
				result += 5;
			}

			if (pick - gem == 2) {
				result += 25;
			}
		}

		// 종료 조건 2) 더 이상 사용할 곡괭이가 없을 때
		if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
			answer = Math.min(answer, result);
			return;
		}

		for (int i = 0; i < picks.length; i++) {
			if (picks[i] != 0) {
				int[] copy = copyArray(picks);
				copy[i]--;
				dfs(depth + 5, result, copy, i);
			}
		}

	}

	private int[] copyArray(int[] arr) {
		int[] copy = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			copy[i] = arr[i];
		}

		return copy;
	}

	private int convert(String mineral) {
		if (mineral.equals(DIA)) {
			return 0;
		}
		if (mineral.equals(IRON)) {
			return 1;
		}
		if (mineral.equals(STONE)) {
			return 2;
		}
		return 3;
	}
}
