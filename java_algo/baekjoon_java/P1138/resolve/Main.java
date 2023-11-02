package baekjoon_java.P1138.resolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];

		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());

			int count = 0;

			for (int j = 0; j < n; j++) {
				if (arr[j] == 0 && count == num) {
					arr[j] = i;
					break;
				}

				if (arr[j] == 0) {
					count++;
				}
			}
		}

		StringBuilder answer = new StringBuilder();

		for (int number : arr) {
			answer.append(number).append(" ");
		}

		System.out.println(answer);
	}
}
