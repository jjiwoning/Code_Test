package baekjoon_java.P1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n + 1][m + 1];
		int[][] dp = new int[n + 1][m + 1];

		for (int i = 1; i < n + 1; i++) {
			String s = br.readLine();
			for (int j = 1; j < m + 1; j++) {
				int number = s.charAt(j - 1) - '0';
				map[i][j] = number;
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				int num = Math.min(map[i - 1][j], Math.min(map[i][j - 1], map[i - 1][j - 1]));
				map[i][j] = num + 1;
			}
		}

		int answer = 0;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				answer = Math.max(answer, map[i][j]);
			}
		}

		System.out.println(answer * answer);
	}
}
