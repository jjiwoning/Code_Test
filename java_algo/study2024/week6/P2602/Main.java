package study2024.week6.P2602;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] target = br.readLine().toCharArray();

		char[][] arr = new char[2][];

		arr[0] = br.readLine().toCharArray();
		arr[1] = br.readLine().toCharArray();

		int[][][] dp = new int[2][arr[0].length + 1][target.length + 1];

		for (int i = 0; i < arr[0].length + 1; i++) {
			dp[0][i][0] = 1;
			dp[1][i][0] = 1;
		}

		for (int j = 1; j < target.length + 1; j++) {
			for (int i = 1; i < arr[0].length + 1; i++) {
				if (arr[0][i - 1] == target[j - 1]) {
					dp[0][i][j] += dp[1][i - 1][j - 1];
				}
				dp[0][i][j] += dp[0][i - 1][j];
				if (arr[1][i - 1] == target[j - 1]) {
					dp[1][i][j] += dp[0][i - 1][j - 1];
				}
				dp[1][i][j] += dp[1][i - 1][j];
			}
		}

		System.out.println(dp[0][arr[0].length][target.length] + dp[1][arr[0].length][target.length]);
	}
}
