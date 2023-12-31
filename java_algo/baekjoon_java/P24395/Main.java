package baekjoon_java.P24395;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] dp = new int[51][51];
		for (int i = 0; i < 51; i++) {
			Arrays.fill(dp[i], -1);
		}
		dp[0][0] = 0;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int danger = Integer.parseInt(st.nextToken());

			for (int j = 50; j >= r; j--) {
				for (int k = 50; k >= b; k--) {
					if (dp[j - r][k - b] >= 0) {
						dp[j][k] = Math.max(dp[j][k], dp[j - r][k - b] + danger);
					}
				}
			}
		}

		List<Answer> answers = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			answers.add(new Answer(i, dp[r][b]));
		}

		answers.sort((o1, o2) -> {
			if (o1.value == o2.value) {
				return o1.order - o2.order;
			}
			return o1.value - o2.value;
		});

		StringBuilder result = new StringBuilder();

		for (Answer answer : answers) {
			result.append(answer.toString()).append("\n");
		}

		System.out.println(result);
	}
}

class Answer {
	int order;
	int value;

	public Answer(int order, int value) {
		this.order = order;
		this.value = value;
		if (value == -1) {
			this.value = 0;
		}
	}

	@Override
	public String toString() {
		return order + " " + value;
	}
}
