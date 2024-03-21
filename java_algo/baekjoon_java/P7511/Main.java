package baekjoon_java.P7511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		StringBuilder answer = new StringBuilder();

		for (int testCase = 1; testCase <= t; testCase++) {

			answer.append("Scenario ").append(testCase).append(":").append("\n");

			int userCount = Integer.parseInt(br.readLine());

			parent = new int[userCount];

			for (int i = 0; i < userCount; i++) {
				parent[i] = i;
			}

			int pair = Integer.parseInt(br.readLine());

			for (int i = 0; i < pair; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				union(a, b);
			}

			int findCount = Integer.parseInt(br.readLine());

			for (int i = 0; i < findCount; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (isSameParent(a, b)) {
					answer.append(1).append("\n");
					continue;
				}
				answer.append(0).append("\n");
			}

			answer.append("\n");
		}

		System.out.println(answer);
	}

	private static int find(int target) {
		if (target == parent[target]) {
			return target;
		}

		return parent[target] = find(parent[target]);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b) {
			parent[b] = a;
		}
		if (a > b) {
			parent[a] = b;
		}
	}

	private static boolean isSameParent(int a, int b) {
		return find(a) == find(b);
	}
}
