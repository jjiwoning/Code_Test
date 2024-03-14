package baekjoon_java.P1660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

		int[] arr = new int[n + 1];
		arr[1] = 1;
		int sum = 1;
		for (int i = 2; i < n + 1; i++) {
			sum += i;
			arr[i] = arr[i - 1] + sum;
		}

		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int count = 1;

		for (int i = 0; i <= n; i++) {
			count = 1;

			try {
				while (arr[count] <= i) {
					dp[i] = Math.min(dp[i], dp[i - arr[count]] + 1);
					count++;
				}
			} catch (Exception e) {
				continue;
			}
		}

		System.out.println(dp[n]);
	}
}
