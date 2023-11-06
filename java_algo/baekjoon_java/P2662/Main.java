package baekjoon_java.P2662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int m;

	private static int[][] costs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		costs = new int[m + 1][n + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int pay = Integer.parseInt(st.nextToken());
			for (int company = 1; company < m + 1; company++) {
				costs[company][pay] = Integer.parseInt(st.nextToken()); // j 번째 기업에 pay 만큼 투자할 때 수익
			}
		}

		int[][] dp = new int[m + 1][n + 1];
		int[][][] count = new int[m + 1][n + 1][m + 1];

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				for (int k = 0; k <= j; k++) {
					if (dp[i - 1][k] + costs[i][j - k] > dp[i][j]) {
						dp[i][j] = Math.max(dp[i - 1][k] + costs[i][j - k], dp[i][j]);
						for (int l = 1; l < i; l++) {
							count[i][j][l] = count[i - 1][k][l];
						}
						count[i][j][i] = j - k;
					}
				}
			}
		}

		System.out.println(dp[m][n]);
		for (int i = 1; i < m + 1; i++) {
			System.out.print(count[m][n][i] + " ");
		}
	}
}
