package Programmers_java.kakao67258;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
	// 진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간을 찾아서 구매
	public int[] solution(String[] gems) {
		int[] answer = {1, 1};

		int gemsCount = findGemsCount(gems);
		Map<String, Integer> boughtGems = new HashMap<>();

		// two pointer: 시간 복잡도 최소화 하기
		int firstIndex = 0;
		int lastIndex = 0;
		int length = Integer.MAX_VALUE;

		// first Index Init
		boughtGems.put(gems[firstIndex], 1);

		while (lastIndex < gems.length) {
			if (checkGem(boughtGems, gemsCount)) {
				// 만약 가장 짧은 구간이 여러 개라면 시작 진열대 번호가 가장 작은 구간을 return 합니다.
				if (lastIndex - firstIndex + 1 < length) {
					answer[0] = firstIndex + 1;
					answer[1] = lastIndex + 1;
					length = lastIndex - firstIndex + 1;
				}
				boughtGems.put(gems[firstIndex], boughtGems.get(gems[firstIndex]) - 1);
				if (boughtGems.get(gems[firstIndex]) == 0) {
					// 이 경우 map에서 제거하기
					boughtGems.remove(gems[firstIndex]);
				}
				// 모든 보석을 하나 이상 포함하는 가장 짧은 구간을 찾아서 return 하도록 solution 함수를 완성해주세요.
				// -> 시작 인덱스 증가 시켜서 한 번 더 확인하기
				firstIndex++;
				continue;
			}

			// 모든 보석 포함 x
			// -> 끝 인덱스 증가 시켜서 확인하기
			lastIndex++;
			if (lastIndex == gems.length) {
				continue;
			}
			boughtGems.put(gems[lastIndex], boughtGems.getOrDefault(gems[lastIndex], 0) + 1);
		}

		return answer;
	}

	private int findGemsCount(String[] gems) {
		// 모든 종류의 보석을 적어도 하나 이상씩 포함하게 됩니다. -> Set으로 중복없는 개수 찾기
		return new HashSet<>(Arrays.asList(gems)).size();
	}

	private boolean checkGem(Map<String, Integer> boughtGems, int gemsCount) {
		// 진열된 모든 종류의 보석을 적어도 1개 이상 포함하는지 체크
		return boughtGems.size() == gemsCount;
	}
}
