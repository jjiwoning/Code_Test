package Programmers_java.kakao118666;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	private Map<Character, Integer> scores;

	public String solution(String[] survey, int[] choices) {
		scores = initScore();
		calScore(survey, choices);
		return makeMbti();
	}

	/**
	 * 1 매우 비동의
	 * 2 비동의
	 * 3 약간 비동의
	 * 4 모르겠음
	 * 5 약간 동의
	 * 6 동의
	 * 7 매우 동의
	 */
	private void calScore(String[] survey, int[] choices) {
		for (int i = 0; i < survey.length; i++) {
			char type1 = survey[i].charAt(0);
			char type2 = survey[i].charAt(1);
			int score = choices[i];

			if (score == 4) {
				continue;
			}

			if (score <= 3) {
				scores.put(type1, scores.get(type1) + 4 - score);
			}

			if (score >= 5) {
				scores.put(type2, scores.get(type2) + score - 4);
			}
		}
	}

	private String makeMbti() {
		return String.valueOf(compareScore('R', 'T'))
			+ compareScore('C', 'F')
			+ compareScore('J', 'M')
			+ compareScore('A', 'N');
	}

	private char compareScore(char type1, char type2) {
		if (scores.get(type1) >= scores.get(type2)) {
			return type1;
		}
		return type2;
	}

	private Map<Character, Integer> initScore() {
		Map<Character, Integer> score = new HashMap<>();

		score.put('R', 0);
		score.put('T', 0);
		score.put('C', 0);
		score.put('F', 0);
		score.put('J', 0);
		score.put('M', 0);
		score.put('A', 0);
		score.put('N', 0);

		return score;
	}
}
