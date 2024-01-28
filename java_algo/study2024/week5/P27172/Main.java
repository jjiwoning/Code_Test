package study2024.week5.P27172;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();

		int[] arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int[] answer = new int[1000001];
		boolean[] check = new boolean[1000001];

		for (int num : arr) {
			check[num] = true;
		}

		for (int num : arr) {
			for (int i = num * 2; i <= 1000000; i += num) {
				if (check[i]) {
					answer[num]++;
					answer[i]--;
				}
			}
		}

		StringBuilder result = new StringBuilder();

		for (int num : arr) {
			result.append(answer[num]).append(" ");
		}

		System.out.println(result);
	}
}
