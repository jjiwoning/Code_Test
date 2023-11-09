package Programmers_java.kakao118668;

import java.util.Arrays;

public class Solution {

	private static final int MAX_VALUE = 77777777;

	public int solution(int alp, int cop, int[][] problems) {
		int[][] dp = new int[151][151]; // int[alp][cop]

		for (int i = 0; i < 151; i++) {
			Arrays.fill(dp[i], MAX_VALUE);
		}

		int maxAlp = -1;
		int maxCop = -1;

		for (int[] problem : problems) {
			maxAlp = Math.max(problem[0], maxAlp);
			maxCop = Math.max(problem[1], maxCop);
		}

		alp = Math.min(alp, maxAlp);
		cop = Math.min(cop, maxCop);

		dp[alp][cop] = 0;

		for (int i = alp; i < maxAlp + 1; i++) {
			for (int j = cop; j < maxCop + 1; j++) {
				if (i < maxAlp - 1) {
					dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1); // alp 키우기
				}
				if (j < maxCop - 1) {
					dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1); // cop 키우기
				}

				for (int[] problem : problems) {
					if (i >= problem[0] && j >= problem[1]) {
						int nextAlp = Math.min(maxAlp, i + problem[2]);
						int nextCop = Math.min(maxCop, j + problem[3]);

						dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + problem[4]);
					}
				}
			}
		}

		return dp[maxAlp][maxCop];
	}
}

