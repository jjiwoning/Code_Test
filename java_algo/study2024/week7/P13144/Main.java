package study2024.week7.P13144;

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

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		boolean[] visited = new boolean[100001];
		long answer = 0;
		int end = 0;

		for (int start = 0; start < n; start++) {

			while (end < n) {
				if (visited[arr[end]]) {
					break;
				}
				visited[arr[end]] = true;
				end++;
			}

			answer += (end - start);

			visited[arr[start]] = false;
		}

		System.out.println(answer);
	}
}
