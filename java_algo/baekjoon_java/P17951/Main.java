package baekjoon_java.P17951;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int[] scores;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		scores = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int totalScore = Arrays.stream(scores)
			.sum();

		System.out.println(binarySearch(m, totalScore));
	}

	private static int binarySearch(int m, int totalScore) {
		int start = 0;
		int end = totalScore + 1;

		while (start < end) {
			int mid = (start + end) / 2;

			if (canMakeScore(mid, m)) {
				start = mid + 1;
				continue;
			}
			end = mid;
		}

		return end - 1;
	}

	private static boolean canMakeScore(int target, int m) {

		int sum = 0;
		int partition = 0;

		for (int score : scores) {
			sum += score;
			if (sum >= target) {
				partition++;
				sum = 0;
			}
		}

		return partition >= m;
	}
}
