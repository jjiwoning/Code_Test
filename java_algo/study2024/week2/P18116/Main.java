package study2024.week2.P18116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static final int MAX_SIZE = 1000001;

	private static final String INSERT_TYPE = "I";
	private static final String QUERY_TYPE = "Q";

	private static int[] parents;
	private static int[] counts;

	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		parents = new int[MAX_SIZE];
		counts = new int[MAX_SIZE];

		for (int i = 0; i < MAX_SIZE; i++) {
			parents[i] = i;
			counts[i] = 1;
		}

		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			final String type = st.nextToken();

			if (INSERT_TYPE.equals(type)) {
				int target1 = Integer.parseInt(st.nextToken());
				int target2 = Integer.parseInt(st.nextToken());

				if (!isSameParent(target1, target2)) {
					union(target1, target2);
				}
			}

			if (QUERY_TYPE.equals(type)) {
				int target = Integer.parseInt(st.nextToken());
				answer.append(counts[find(target)]).append("\n");
			}
		}

		System.out.println(answer);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b) {
			parents[b] = a;
			counts[a] += counts[b];
		}

		if (a > b) {
			parents[a] = b;
			counts[b] += counts[a];
		}
	}

	private static int find(int a) {
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	private static boolean isSameParent(int a, int b) {
		return find(a) == find(b);
	}
}
