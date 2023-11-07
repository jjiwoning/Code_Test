package Programmers_java.kakao17677;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	public int solution(String str1, String str2) {

		// 대문자와 소문자의 차이는 무시한다.
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		// 원소의 중복을 허용하는 다중집합에 대해서 확장할 수 있다.
		Map<String, Integer> str1MultiSet = makeMultiSet(str1);
		Map<String, Integer> str2MultiSet = makeMultiSet(str2);

		int unionCount = findUnionCount(str1MultiSet, str2MultiSet);
		int intersectCount = findIntersectCount(str1MultiSet, str2MultiSet);

		// 집합 A와 집합 B가 모두 공집합일 경우에는 나눗셈이 정의되지 않으니 따로 J(A, B) = 1로 정의한다.
		if (unionCount == 0) {
			return 65536;
		}

		double answer = (double) intersectCount / unionCount * 65536;

		return (int) answer;
	}

	private Map<String, Integer> makeMultiSet(String str) {
		Map<String, Integer> result = new HashMap<>();

		for (int i = 0; i < str.length() - 1; i++) {
			// 영문자로 된 글자 쌍만 유효하고, 기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다.
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z' && str.charAt(i + 1) >= 'a' && str.charAt(i + 1) <= 'z') {
				String s = str.substring(i, i + 2);
				result.put(s, result.getOrDefault(s, 0) + 1);
			}
		}

		return result;
	}

	private int findUnionCount(
		Map<String, Integer> str1MultiSet,
		Map<String, Integer> str2MultiSet
	) {
		int count = 0;

		Set<String> union = new HashSet<>(str1MultiSet.keySet());
		union.addAll(str2MultiSet.keySet());

		for (String s : union) {
			count += Math.max(str1MultiSet.getOrDefault(s, 0), str2MultiSet.getOrDefault(s, 0));
		}

		return count;
	}

	private int findIntersectCount(
		Map<String, Integer> str1MultiSet,
		Map<String, Integer> str2MultiSet
	) {
		int count = 0;

		Set<String> intersection = new HashSet<>(str1MultiSet.keySet());
		intersection.retainAll(str2MultiSet.keySet());

		for (String s : intersection) {
			count += Math.min(str1MultiSet.get(s), str2MultiSet.get(s));
		}

		return count;
	}

}
