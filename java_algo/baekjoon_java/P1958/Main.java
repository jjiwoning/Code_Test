package baekjoon_java.P1958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr1 = br.readLine().toCharArray();
		char[] arr2 = br.readLine().toCharArray();
		char[] arr3 = br.readLine().toCharArray();

		int[][][] dp = new int[arr3.length + 1][arr2.length + 1][arr1.length + 1];

		int answer = 0;

		for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				for (int k = 0; k < arr1.length; k++) {
					if (arr3[i] == arr2[j] && arr2[j] == arr1[k]) {
						dp[i + 1][j + 1][k + 1] += dp[i][j][k] + 1;
					}
					if (!(arr3[i] == arr2[j] && arr2[j] == arr1[k])) {
						int beforeMax = Math.max(dp[i][j + 1][k + 1], dp[i + 1][j][k + 1]);
						beforeMax = Math.max(beforeMax, dp[i + 1][j + 1][k]);
						dp[i + 1][j + 1][k + 1] += beforeMax;
					}
					answer = Math.max(answer, dp[i + 1][j + 1][k + 1]);
				}
			}
		}

		System.out.println(answer);
	}
}
