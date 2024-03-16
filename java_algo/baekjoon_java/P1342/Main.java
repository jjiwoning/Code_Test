package baekjoon_java.P1342;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static char[] arr;
	private static int[] visited;
	private static int answer;

	public static void main(String[] args) throws IOException {
		arr = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
		visited = new int[26];
		answer = 0;

		for (char c : arr) {
			visited[c - 'a']++;
		}

		dfs(0, 'Z');

		System.out.println(answer);
	}

	private static void dfs(int depth, char before) {

		if (depth == arr.length) {
			answer++;
			return;
		}

		for (int i = 0; i < 26; i++) {
			if (visited[i] > 0 && before != (char)('a' + i)) {
				visited[i]--;
				dfs(depth + 1, (char)('a' + i));
				visited[i]++;
			}
		}
	}
}
