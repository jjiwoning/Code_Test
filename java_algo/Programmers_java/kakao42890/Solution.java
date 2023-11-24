package Programmers_java.kakao42890;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	private Set<Set<Integer>> answers;
	private String[][] relation;

	public int solution(String[][] relation) {
		this.answers = new HashSet<>();
		this.relation = relation;

		for (int i = 1; i <= relation[0].length; i++) {
			combination(i, 0, 0, new HashSet<>());
		}

		return answers.size();
	}

	private void combination(int wantedCount, int nowCount, int index, Set<Integer> set) {
		if (nowCount == wantedCount) {
			if (isUnique(set)) {
				answers.add(set);
			}
			return;
		}
		if (index == relation[0].length) {
			return;
		}

		Set<Integer> makeSet = new HashSet<>(set);
		makeSet.add(index);
		combination(wantedCount, nowCount + 1, index + 1, makeSet);

		Set<Integer> makeSet2 = new HashSet<>(set);
		combination(wantedCount, nowCount, index + 1, makeSet2);

	}

	private boolean isUnique(Set<Integer> set) {
		for (Set<Integer> nowSet : answers) {
			if (set.containsAll(nowSet)) {
				return false;
			}
		}
		return relationCheck(set);
	}

	private boolean relationCheck(Set<Integer> set) {
		String[] makeKey = new String[relation.length];
		Arrays.fill(makeKey, "");
		for (int i = 0; i < relation.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (Integer column : set) {
				sb.append(relation[i][column]);
			}
			makeKey[i] = sb.toString();
		}
		Set<String> makeSet = new HashSet<>(List.of(makeKey));
		return makeSet.size() == relation.length;
	}
}
