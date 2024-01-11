package study2024.week1.P15809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	private static final int UNION_TYPE = 1;
	private static final int WAR_TYPE = 2;

	private static int[] parents;
	private static int[] armies;

	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		final int n = Integer.parseInt(st.nextToken());
		final int m = Integer.parseInt(st.nextToken());

		parents = new int[n + 1];
		armies = new int[n + 1];

		for (int i = 0; i < n; i++) {
			final int army = Integer.parseInt(br.readLine());
			parents[i + 1] = i + 1;
			armies[i + 1] = army;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			final int type = Integer.parseInt(st.nextToken());
			final int country1 = Integer.parseInt(st.nextToken());
			final int country2 = Integer.parseInt(st.nextToken());

			if (type == UNION_TYPE) { // union
				union(country1, country2);
			}

			if (type == WAR_TYPE) { // war
				doWar(country1, country2);
			}
		}

		Map<Integer, Integer> results = new HashMap<>();

		for (int i = 0; i < n + 1; i++) {
			int parentCountry = find(i);
			if (parentCountry == 0) {
				continue;
			}
			if (!results.containsKey(parentCountry)) {
				results.put(parentCountry, armies[parentCountry]);
			}
		}

		System.out.println(results.size());
		List<Integer> resultArmies = new ArrayList<>(results.values());
		resultArmies.sort(Comparator.comparingInt(o -> o));
		StringBuilder sb = new StringBuilder();
		for (Integer resultArmy : resultArmies) {
			sb.append(resultArmy).append(" ");
		}
		System.out.println(sb);
	}

	private static void doWar(int country1, int country2) {
		int parent1 = find(country1);
		int parent2 = find(country2);

		if (armies[parent2] == armies[parent1]) {
			// 두 나라 모두 멸망
			union(0, parent1);
			union(0, parent2);
		}

		if (armies[parent1] > armies[parent2]) {
			int keep = armies[parent1] - armies[parent2];
			union(parent1, parent2);
			armies[parent1] = keep;
			armies[parent2] = keep;
		}

		if (armies[parent2] > armies[parent1]) {
			int keep = armies[parent2] - armies[parent1];
			union(parent1, parent2);
			armies[parent1] = keep;
			armies[parent2] = keep;
		}
	}

	private static void union(int country1, int country2) {
		country1 = find(country1);
		country2 = find(country2);

		if (country1 > country2) {
			armies[country2] += armies[country1];
			parents[country1] = country2;
		}

		if (country1 < country2) {
			armies[country1] += armies[country2];
			parents[country2] = country1;
		}
	}

	private static int find(final int target) {
		if (target == parents[target]) {
			return target;
		}

		return parents[target] = find(parents[target]);
	}
}
