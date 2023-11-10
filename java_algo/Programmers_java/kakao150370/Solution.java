package Programmers_java.kakao150370;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2000 ≤ YYYY ≤ 2022
 * 1 ≤ MM ≤ 12
 * MM이 한 자릿수인 경우 앞에 0이 붙습니다.
 * 1 ≤ DD ≤ 28
 * DD가 한 자릿수인 경우 앞에 0이 붙습니다.
 */
public class Solution {

	private static final int MONTH = 12;
	private static final int DAY = 28; // 모든 달은 28일까지 있다고 가정합니다.

	public List<Integer> solution(String today, String[] terms, String[] privacies) {
		int parsingDayToday = parseDate(today);
		Map<String, Integer> termMap = makeTermMap(terms);

		return isExpiredPrivacies(parsingDayToday, termMap, privacies);
	}

	private Map<String, Integer> makeTermMap(String[] terms) {
		Map<String, Integer> termMap = new HashMap<>();

		// terms 배열에서 약관 종류는 중복되지 않습니다.
		// 유효기간은 개인정보를 보관할 수 있는 달 수를 나타내는 정수이며, 1 이상 100 이하입니다.
		for (String term : terms) {
			String[] termSplit = term.split(" ");
			termMap.put(termSplit[0], Integer.parseInt(termSplit[1]) * DAY);
		}

		return termMap;
	}

	private List<Integer> isExpiredPrivacies(int parsingDayToday, Map<String, Integer> termMap, String[] privacies) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < privacies.length; i++) {
			String[] privacySpilt = privacies[i].split(" ");
			int privacyDate = parseDate(privacySpilt[0]);
			int expiredDate = privacyDate + termMap.get(privacySpilt[1]);

			if (parsingDayToday > expiredDate - 1) {
				result.add(i + 1);
			}
		}

		return result;
	}

	/**
	 * "2022.05.19" -> year * 12 * 28 + month * 28 + day 형태로 파싱
 	 */
	private int parseDate(String date) {
		String[] splitDate = date.split("\\.");

		int year = Integer.parseInt(splitDate[0]) * MONTH * DAY;
		int month = Integer.parseInt(splitDate[1]) * DAY;
		int day = Integer.parseInt(splitDate[2]);

		return year + month + day;
	}
}
