package baekjoon_java.P2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] lowerDp = new int[n + 1][3];
		int[][] higherDp = new int[n + 1][3];

		int[][] arr = new int[n + 1][3];

		for (int i = 1; i < n + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < n + 1; i++) {
			higherDp[i][0] = Math.max(higherDp[i - 1][0], higherDp[i - 1][1]) + arr[i][0];
			higherDp[i][1] = Math.max(higherDp[i - 1][0], Math.max(higherDp[i - 1][1], higherDp[i - 1][2])) + arr[i][1];
			higherDp[i][2] = Math.max(higherDp[i - 1][1], higherDp[i - 1][2]) + arr[i][2];

			lowerDp[i][0] = Math.min(lowerDp[i - 1][0], lowerDp[i - 1][1]) + arr[i][0];
			lowerDp[i][1] = Math.min(lowerDp[i - 1][0], Math.min(lowerDp[i - 1][1], lowerDp[i - 1][2])) + arr[i][1];
			lowerDp[i][2] = Math.min(lowerDp[i - 1][1], lowerDp[i - 1][2]) + arr[i][2];
		}

		int maxScore = Math.max(higherDp[n][0], Math.max(higherDp[n][1], higherDp[n][2]));
		int minScore = Math.min(lowerDp[n][0], Math.min(lowerDp[n][1], lowerDp[n][2]));

		System.out.println(maxScore + " " + minScore);
	}
}
