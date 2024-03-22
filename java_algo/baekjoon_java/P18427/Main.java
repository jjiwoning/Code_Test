package baekjoon_java.P18427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static final int MOD_CONST = 10007;

	public static void main(String[] args) throws IOException {
		final var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[][] info = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int index = 0;
			while (st.hasMoreTokens()) {
				info[i][index++] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[n + 1][h + 1]; // 학생, 높이

		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1; // 아무것도 선택하지 않는 경우의 수
		}

		for (int i = 1; i <= n; i++) { // 1번 학생부터 순차적으로 dp 진행
			for (int j = 1; j <= h; j++) { // 최대 높이까지 검사
				dp[i][j] = dp[i - 1][j]; // 현재 학생이 아무것도 고르지 않는 경우
				for (int k = 1; k <= m; k++) { // 블록 선택 시작
					int block = info[i - 1][k - 1]; // 이번에 선택한 블록
					if (block == 0) { // 비어있는 경우
						break;
					}
					if (j - block >= 0) {
						dp[i][j] += dp[i - 1][j - block];
						dp[i][j] %= MOD_CONST;
					}
				}
			}
		}

		System.out.println(dp[n][h]);
	}
}
