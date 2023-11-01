package baekjoon_java.P2847;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int max = arr[n - 1];
		int answer = 0;

		for (int i = n - 1; i > -1; i--) {
			if (arr[i] < max) {
				max = arr[i] - 1;
				continue;
			}

			answer += arr[i] - max;
			max--;
		}

		System.out.println(answer);
	}
}
