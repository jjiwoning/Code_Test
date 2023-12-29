package Programmers_java.P43236;

import java.util.Arrays;

public class Solution {

	private int distance;
	private int[] rocks;
	private int n;

	public int solution(int distance, int[] rocks, int n) {
		this.distance = distance;
		this.rocks = rocks;
		Arrays.sort(this.rocks); // 징검다리 순서대로 정렬
		this.n = n;

		return binarySearch();
	}

	private int binarySearch() {
		int start = 0;
		int end = this.distance + 1;

		while (start < end) {
			int mid = (start + end) / 2;

			if (canMove(mid)) {
				start = mid + 1;
				continue;
			}
			end = mid;
		}

		return end;
	}

	private boolean canMove(int value) {
		int cnt = 0;

		int start = 0;

		for (int i = 0; i < rocks.length; i++) {
			if (rocks[i] - start < value) {
				cnt++;
				continue;
			}
			start = rocks[i];
		}

		if (distance - start < value) {
			cnt++;
		}

		return cnt <= n;
	}

	public static void main(String[] args) {
		new Solution().solution(25, new int[] {2, 14, 11, 21, 17}, 2);
	}
}
