package study2024.week3.P1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	private static int[] dp;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

		if (n < 10) { // n이 10 미만이면 무조건 지는 수
			System.out.println(-1);
			return;
		}

		dp = new int[n + 1];

		for (int i = 10; i < n + 1; i++) {
			Set<Integer> find = findSubString(i);
			for (Integer num : find) {
				if (dp[i - num] == 0) {
					dp[i] = num;
					break;
				}
			}
		}

		if (dp[n] == 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(dp[n]);
	}

	private static Set<Integer> findSubString(int num) {
		String numString = String.valueOf(num);
		Set<Integer> find = new TreeSet<>();

		for (int i = 0; i < numString.length(); i++) {
			StringBuilder substring = new StringBuilder();
			for (int j = i; j < numString.length(); j++) {
				substring.append(numString.charAt(j));
				find.add(Integer.parseInt(substring.toString()));
			}
		}

		find.remove(0);
		find.remove(num);

		return find;
	}
}
