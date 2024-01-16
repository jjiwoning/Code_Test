package study2024.week2.P2263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static int[] postOrder;
	private static int[] inOrder;

	private static StringBuilder answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		inOrder = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		postOrder = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		answer = new StringBuilder();

		dfs(0, n - 1, 0, n - 1);

		System.out.println(answer);
	}

	private static void dfs(int postOrderStart, int postOrderEnd, int inOrderStart, int inOrderEnd) {
		if (postOrderStart > postOrderEnd || inOrderStart > inOrderEnd) {
			return;
		}

		answer.append(postOrder[postOrderEnd]).append(" ");


		for (int i = inOrderStart; i <= inOrderEnd; i++) {
			if (inOrder[i] == postOrder[postOrderEnd]) {
				// 왼쪽
				dfs(postOrderStart, postOrderStart + i - 1 - inOrderStart, inOrderStart, i - 1);
				// 오른쪽
				dfs(postOrderStart + i - inOrderStart, postOrderEnd - 1, i + 1, inOrderEnd);
				return;
			}
		}
	}
}
