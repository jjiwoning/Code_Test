package study2024.week5.P2616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int connection = Integer.parseInt(br.readLine());

		for (int i = 1; i < n + 1; i++) {
			arr[i] += arr[i - 1];
		}

		int[][] dp = new int[4][n + 1];

		for (int i = connection; i < n + 1; i++) {
			for (int j = 1; j <= 3; j++) {
				dp[j][i] = Math.max(dp[j - 1][i - 1], arr[i] - arr[i - connection] + dp[j - 1][i - connection]);
				dp[j][i] = Math.max(dp[j][i], dp[j][i - 1]);
			}
		}

		System.out.println(dp[3][n]);
	}
}
