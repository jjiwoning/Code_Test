package baekjoon_java.P6137;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] arr = new char[n];

		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().charAt(0);
		}

		int start = 0;
		int end = n - 1;

		StringBuilder sb = new StringBuilder();

		while (start <= end) {
			if (arr[start] < arr[end]) {
				sb.append(arr[start]);
				start++;
				continue;
			}

			if (arr[start] > arr[end]) {
				sb.append(arr[end]);
				end--;
				continue;
			}

			if (arr[start] == arr[end]) {
				int start2 = start;
				int end2 = end;

				while (true) {

					if (start2 < n - 1) {
						start2++;
					}

					if (end2 > 0) {
						end2--;
					}

					if (arr[start2] < arr[end2]) {
						sb.append(arr[start]);
						start++;
						break;
					}

					if (arr[start2] > arr[end2]) {
						sb.append(arr[end]);
						end--;
						break;
					}
				}
			}
		}

		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < sb.length(); i++) {
			if (i != 0 && i % 80 == 0) {
				System.out.println();
			}
			System.out.print(sb.charAt(i));
		}

		// if (sb.length() > 80) {
		// 	int size = 0;
		// 	while (true) {
		// 		if (sb.substring(size).length() < 80) {
		// 			answer.append(sb.substring(size)).append("\n");
		// 			break;
		// 		}
		// 		answer.append(sb.substring(size, size + 80)).append("\n");
		// 		size += 80;
		// 	}
		// }
		//
		// System.out.println(answer);
	}
}
