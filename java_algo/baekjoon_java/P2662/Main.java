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

		int[][] dp = new int[m + 1][n + 1]; // dp로 사용할 배열
		int[][][] count = new int[m + 1][n + 1][m + 1]; // 기업 투자 정보 저장 배열

		for (int i = 1; i < m + 1; i++) { // 첫 번째 기업부터 for문 시작 (배낭 문제)
			for (int j = 1; j < n + 1; j++) { // 투자 금액 1부터 n까지
				for (int k = 0; k <= j; k++) { // 현재 투자 금액이 j라고 할 때
					if (dp[i - 1][k] + costs[i][j - k] > dp[i][j]) {
						// j로 나오는 경우의 수 다 찾아주기
						// ex) j가 4 일때 -> 0 4, 1 3, 2 2, 3 1, 4, 0 -> 이 중 최대를 선택한다.
						dp[i][j] = Math.max(dp[i - 1][k] + costs[i][j - k], dp[i][j]);
						for (int l = 1; l < i; l++) {
							count[i][j][l] = count[i - 1][k][l]; // i 번째 이전의 최대 투자 정보를 가져오는 과정
						}
						count[i][j][i] = j - k; // i 번째 투자 정보 저장
					}
				}
			}
		}

		// 정답 출력 부
		System.out.println(dp[m][n]);
		for (int i = 1; i < m + 1; i++) {
			System.out.print(count[m][n][i] + " ");
		}
	}
}
