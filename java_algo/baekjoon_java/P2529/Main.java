package baekjoon_java.P2529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	private static int n;

	private static char[] compare;

	private static boolean[] visited;

	private static TreeSet<String> results;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		compare = new char[n];
		visited = new boolean[10];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			compare[i] = st.nextToken().charAt(0);
		}

		results = new TreeSet<>();

		dfs(0, 0, new StringBuilder(), '.');

		System.out.println(results.last());
		System.out.println(results.first());
	}

	private static void dfs(int depth, int before, StringBuilder make, char compareChar) {

		if (depth == n) {
			if (compareChar == '<') {
				for (int i = before + 1; i < 10; i++) {
					if (visited[i]) {
						continue;
					}
					results.add(String.valueOf(make) + i);
				}
			}

			if (compareChar == '>') {
				for (int i = 0; i < before; i++) {
					if (visited[i]) {
						continue;
					}
					results.add(String.valueOf(make) + i);
				}
			}
			return;
		}

		if (depth == 0) {
			for (int i = 0; i < 10; i++) {
				if (visited[i]) {
					continue;
				}
				StringBuilder nextMake = new StringBuilder(make);
				nextMake.append(i);
				visited[i] = true;
				dfs(depth + 1, i, nextMake, compare[depth]);
				visited[i] = false;
			}
		}

		if (depth != 0) {
			if (compareChar == '<') {
				for (int i = before + 1; i < 10; i++) {
					if (visited[i]) {
						continue;
					}
					StringBuilder nextMake = new StringBuilder(make);
					nextMake.append(i);
					visited[i] = true;
					dfs(depth + 1, i, nextMake, compare[depth]);
					visited[i] = false;
				}
			}

			if (compareChar == '>') {
				for (int i = 0; i < before; i++) {
					if (visited[i]) {
						continue;
					}
					StringBuilder nextMake = new StringBuilder(make);
					nextMake.append(i);
					visited[i] = true;
					dfs(depth + 1, i, nextMake, compare[depth]);
					visited[i] = false;
				}
			}
		}
	}
}
