package study2024.week3.P10573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();

		for (int testCase = 0; testCase < t; testCase++) {
			dp = initDpArray();
			String targetNum = br.readLine();

			if (checkIncreaseNumber(targetNum)) {
				answer.append(-1).append("\n");
				continue;
			}

			long result = 0;

			result += dp[targetNum.length() + 1][0]; // 자리수 + 1의 개수를 먼저 더해준다.

			for (int i = 0; i < targetNum.length(); i++) {
				int num = targetNum.charAt(i) - '0';
				for (int j = num + 1; j < 10; j++) {
					result -= dp[targetNum.length() - i][j];
				}
			}

			answer.append(result - 1).append("\n");
		}

		System.out.println(answer);
	}

	private static long[][] initDpArray() {
		long[][] dp = new long[82][10];

		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1; // 첫 번째 자리수의 증가하는 수는 1개 -> 자기 자신
		}

		for (int i = 1; i <= 80; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = j; k >= 0; k--) {
					dp[i + 1][k] += dp[i][j]; // 345 -> 1345, 2345, 3345 로직
				}
			}
		}

		return dp;
	}

	private static boolean checkIncreaseNumber(String targetNum) {
		int start = targetNum.charAt(0) - '0';

		for (int i = 1; i < targetNum.length(); i++) {
			if (start > targetNum.charAt(i) - '0') {
				return true;
			}
			start = targetNum.charAt(i) - '0';
		}

		return false;
	}
}
