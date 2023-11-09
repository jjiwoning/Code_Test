package Programmers_java.kakao64064;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	private int banIdSize;
	private boolean[] visited;
	private String[] userIds;
	private String[] bannedIds;
	private Set<Set<Integer>> answerSet;

	public int solution(String[] user_id, String[] banned_id) {
		visited = new boolean[user_id.length];
		banIdSize = banned_id.length;
		userIds = user_id;
		bannedIds = banned_id;
		answerSet = new HashSet<>();

		dfs(0, new HashSet<>());

		return answerSet.size();
	}

	private void dfs(int depth, Set<Integer> now) {
		if (depth == banIdSize) {
			answerSet.add(now);
			return;
		}

		for (int i = 0; i < userIds.length; i++) {
			if (!visited[i]) {
				if (checkId(userIds[i], bannedIds[depth])) {
					visited[i] = true;
					Set<Integer> newSet = new HashSet<>(now);
					newSet.add(i);
					dfs(depth + 1, newSet);
					visited[i] = false;
				}
			}
		}
	}

	private boolean checkId(String userId, String ban) {

		if (userId.length() != ban.length()) {
			return false;
		}

		for (int i = 0; i < userId.length(); i++) {
			if (ban.charAt(i) == '*') {
				continue;
			}

			if (userId.charAt(i) != ban.charAt(i)) {
				return false;
			}
		}

		return true;
	}
}
