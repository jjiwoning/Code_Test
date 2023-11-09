package Programmers_java.kakao64065;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int[] solution(String s) {
		s = s.substring(1, s.length() - 1);

		Map<String, Integer> map = new HashMap<>();

		StringBuilder num = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == ',' || c == '{' || c == '}') {
				if (!num.toString().equals("")) {
					map.put(num.toString(), map.getOrDefault(num.toString(), 0) + 1);
					num = new StringBuilder();
				}
				continue;
			}

			num.append(c);
		}

		int[] answer = new int[map.keySet().size()];

		for (String target : map.keySet()) {
			Integer integer = map.get(target);
			int index = Math.abs(integer - answer.length);
			answer[index] = Integer.parseInt(target);
		}

		return answer;
	}
}
