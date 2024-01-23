package study2024.week4.P3687;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// 0 -> 6개
	// 1 -> 2개 -> 최대 만들 때 사용
	// 2 -> 5개 -> 최소 만들 때 사용
	// 3 -> 5개 -> 절대 사용 안함 (2 쓰는게 최소 만들 때 더 유리함)
	// 4 -> 4개 -> 4인 경우에만 사용
	// 5 -> 5개 -> 절대 사용 안함 (2 쓰는게 최소 만들 때 더 유리함)
	// 6 -> 6개 -> 6인 경우에만 사용
	// 7 -> 3개 -> 최대 만들 때 사용
	// 8 -> 7개 -> 8인 경우에만 사용
	// 9 -> 6개 -> 절대 사용 안함 (0, 6 쓰는게 최소 만들 때 더 유리함)

	private static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		StringBuilder answer = new StringBuilder();

		dp = new long[101];
		dp[2] = 1;
		dp[3] = 7;
		dp[4] = 4;
		dp[5] = 2;
		dp[6] = 0;
		dp[7] = 8;

		for (int i = 8; i < 101; i++) {
			long make = Long.MAX_VALUE;

			for (int j = 2; j <= i / 2; j++) {
				make = Math.min(make, makeNumber(dp[j], dp[i - j]));
				if (j == 6) {
					make = Math.min(make, makeNumber(6, dp[i - j]));
				}
				if (i - j == 6) {
					make = Math.min(make, makeNumber(dp[j], 6));
				}
			}

			dp[i] = make;
		}

		for (int i = 0; i < t; i++) {
			int count = Integer.parseInt(br.readLine());

			findMinValue(answer, dp, count);

			findMaxValue(answer, count);

			answer.append("\n");
		}

		System.out.println(answer);
	}

	private static long makeNumber(long value1, long value2) {
		String s1 = value1 + String.valueOf(value2);
		String s2 = value2 + String.valueOf(value1);

		if (s1.charAt(0) == '0' && s2.charAt(0) == '0') {
			return Long.MAX_VALUE;
		}

		if (s1.charAt(0) == '0') {
			return Long.parseLong(s2);
		}

		if (s2.charAt(0) == '0') {
			return Long.parseLong(s1);
		}

		return Math.min(Long.parseLong(s2), Long.parseLong(s1));
	}

	private static void findMinValue(StringBuilder answer, long[] dp, int count) {
		if (count == 6) {
			answer.append(6).append(" ");
			return;
		}

		answer.append(dp[count]).append(" ");
	}

	private static void findMaxValue(StringBuilder answer, int count) {
		if (count % 2 == 0) {
			answer.append("1".repeat(count / 2));
			return;
		}

		answer.append("7").append("1".repeat((count - 3) / 2));
	}

}
