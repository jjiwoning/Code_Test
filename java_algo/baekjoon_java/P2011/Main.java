package baekjoon_java.P2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static final int MOD_CONST = 1000000;

	public static void main(String[] args) throws IOException {
		String s = new BufferedReader(new InputStreamReader(System.in)).readLine();

		int[] arr = new int[s.length() + 1];

		for (int i = 1; i < s.length() + 1; i++) {
			arr[i] = s.charAt(i - 1) - '0';
		}

		if (arr[1] == 0) {
			System.out.println(0);
			return;
		}

		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = 1; // init

		for (int i = 2; i < dp.length; i++) {
			if (arr[i] == 0) {
				if (arr[i - 1] > 2 || arr[i - 1] == 0) {
					System.out.println(0);
					return;
				}
				dp[i] += dp[i - 2];
				dp[i] %= MOD_CONST;
				continue;
			}
			if (arr[i - 1] == 1) {
				// 그냥 현재 숫자에 매핑하기
				dp[i] += dp[i - 1];
				dp[i] %= MOD_CONST;
				// 이전꺼랑 합쳐서 보기
				dp[i] += dp[i - 2];
				dp[i] %= MOD_CONST;
				continue;
			}
			if (arr[i - 1] == 2 && arr[i] <= 6) {
				// 그냥 현재 숫자에 매핑하기
				dp[i] += dp[i - 1];
				dp[i] %= MOD_CONST;
				// 이전꺼랑 합쳐서 보기
				dp[i] += dp[i - 2];
				dp[i] %= MOD_CONST;
				continue;
			}
			dp[i] = dp[i - 1];
			dp[i] %= MOD_CONST;
		}

		System.out.println(dp[s.length()] % MOD_CONST);
	}
}
