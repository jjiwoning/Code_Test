package Programmers_java.kakao150368;

/**
 * 1. 이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.
 * 2. 이모티콘 판매액을 최대한 늘리는 것.
 * 이모티콘 m개를 할인하여 판매합니다. + [10, 20, 30, 40] -> 4^m -> 시간 복잡도 : 최대 4 ^ 7 = 2 ^ 14 = 16384 -> 완탐 가능
 * 가격은 100의 배수입니다. -> 할인율 적용하더라도 int 값 보장 됨 -> double 고려 x
 */
public class Solution {

	private static final int[] discountRates = new int[] {10, 20, 30, 40};

	private int n;
	private int[] answer;
	private int[] discounts;
	private int[] emoticons;
	private int[][] users;

	public int[] solution(int[][] users, int[] emoticons) {
		this.n = emoticons.length;
		this.users = users;
		this.emoticons = emoticons;

		answer = new int[] {0, 0};
		discounts = new int[emoticons.length];

		dfs(0);

		return answer;
	}

	private void dfs(int depth) {
		if (depth == n) {
			checkUsersBought();
			return;
		}

		for (int i = 0; i < discountRates.length; i++) {
			discounts[depth] = discountRates[i];
			dfs(depth + 1);
			discounts[depth] = 0;
		}
	}

	private void checkUsersBought() {
		int[] result = new int[] {0, 0};

		/**
		 * 각 사용자들은 자신의 기준에 따라 일정 비율 이상 할인하는 이모티콘을 모두 구매합니다.
		 * 각 사용자들은 자신의 기준에 따라 이모티콘 구매 비용의 합이 일정 가격 이상이 된다면,
		 * 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입합니다.
		 */
		for (int[] user : users) {
			int wantedDiscountRate = user[0];
			int maximumMoney = user[1];
			int boughtMoney = 0;
			for (int i = 0; i < discounts.length; i++) {
				if (discounts[i] >= wantedDiscountRate) {
					boughtMoney += (100 - discounts[i]) * emoticons[i] / 100;
				}
			}
			if (boughtMoney >= maximumMoney) {
				result[0]++;
			}
			if (boughtMoney < maximumMoney) {
				result[1] += boughtMoney;
			}
		}

		if (answer[0] < result[0]) {
			answer = result;
			return;
		}

		if (answer[0] == result[0] && answer[1] < result[1]) {
			answer[1] = result[1];
		}
	}
}
