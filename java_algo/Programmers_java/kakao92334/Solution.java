package Programmers_java.kakao92334;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		Set<String> reports = new HashSet<>(List.of(report));
		Map<String, Integer> userIds = new HashMap<>();
		for (int i = 0; i < id_list.length; i++) {
			userIds.put(id_list[i], i);
		}
		Map<String, Integer> reportsCount = new HashMap<>();
		Map<String, List<String>> reportLogs = new HashMap<>();

		for (String rep : reports) {
			String[] result = rep.split(" ");
			if (!reportLogs.containsKey(result[0])) {
				reportLogs.put(result[0], new ArrayList<>());
			}
			reportLogs.get(result[0]).add(result[1]);
			reportsCount.put(result[1], reportsCount.getOrDefault(result[1], 0) + 1);
		}

		for (String id : reportLogs.keySet()) {
			for (String s : reportLogs.get(id)) {
				if (reportsCount.get(s) >= k) {
					answer[userIds.get(id)]++;
				}
			}
		}

		return answer;
	}
}
