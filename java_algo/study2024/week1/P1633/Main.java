package study2024.week1.P1633;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static int[][][] dp;
	private static List<int[]> status;
	private static int index;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		status = new ArrayList<>();

		index = 0;

		while (true) {
			String s = br.readLine();
			if (s == null || s.isBlank() || s.isEmpty()) {
				break;
			}
			status.add(new int[2]);
			String[] s1 = s.split(" ");
			int blackStatus = Integer.parseInt(s1[0]);
			int whiteStatus = Integer.parseInt(s1[1]);
			status.get(index)[0] = blackStatus;
			status.get(index)[1] = whiteStatus;
			index++;
		}

		dp = new int[index + 1][16][16]; // dp[현재 사람][흑팀][백팀]

		// dp = new int[index + 1][index + 1];
		//
		// for (int i = 0; i < index; i++) {
		// 	int blackStatus = status.get(i)[0];
		// 	int whiteStatus = status.get(i)[1];
		//
		// 	dp[i + 1][0] = dp[i][0] + blackStatus;
		// 	dp[0][i + 1] = dp[0][i] + whiteStatus;
		//
		// 	for (int j = 1; j < i + 1; j++) {
		// 		dp[j][i + 1 - j] = Math.max(dp[j][i + 1 - j],
		// 			Math.max(dp[j - 1][i + 1 - j] + blackStatus, dp[j][i - j] + whiteStatus));
		// 	}
		// }

		dfs(0, 15, 15);

		System.out.println(dp[0][15][15]);
	}

	private static int dfs(int depth, int blackCount, int whiteCount) {
		if (blackCount == 0 && whiteCount == 0) {
			return 0;
		}

		if (depth == index) {
			return 0;
		}

		if (dp[depth][blackCount][whiteCount] != 0) {
			return dp[depth][blackCount][whiteCount];
		}

		int find = 0;

		if (blackCount > 0) {
			find = Math.max(find, dfs(depth + 1, blackCount - 1, whiteCount) + status.get(depth)[0]);
		}

		if (whiteCount > 0) {
			find = Math.max(find, dfs(depth + 1, blackCount, whiteCount - 1) + status.get(depth)[1]);
		}

		find = Math.max(find, dfs(depth + 1, blackCount, whiteCount));

		dp[depth][blackCount][whiteCount] = find;

		return dp[depth][blackCount][whiteCount];
	}
}
