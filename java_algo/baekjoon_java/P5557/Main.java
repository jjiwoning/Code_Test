package baekjoon_java.P5557;

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
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long[][] dp = new long[n + 1][21];
		dp[1][arr[0]] = 1;

		for (int i = 2; i < n; i++) {
			for (int j = 0; j <= 20; j++) {
				int tempSum = j + arr[i - 1];

				if (0 <= tempSum && tempSum <= 20) {
					dp[i][tempSum] += dp[i - 1][j];
				}

				tempSum = j - arr[i - 1];
				if (0 <= tempSum && tempSum <= 20) {
					dp[i][tempSum] += dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[n - 1][arr[n - 1]]);
	}
}

