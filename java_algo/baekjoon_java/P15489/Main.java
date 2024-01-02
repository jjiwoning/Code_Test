package baekjoon_java.P15489;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int[][] dp = new int[31][31];
		dp[1][1] = 1;
		for (int i = 2; i < 31; i++) {
			for (int j = 1; j < 31; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}

		long answer = 0;

		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		for (int i = r; i < r + w; i++) {
			for (int j = c; j < c + i - r + 1; j++) {
				answer += dp[i][j];
			}
		}

		System.out.println(answer);
	}
}
