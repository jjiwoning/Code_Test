package study2024.week7.P23059;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	private static Set<String> items;

	private static Map<String, Integer> counts;

	private static Map<String, List<String>> edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		items = new HashSet<>();
		counts = new TreeMap<>();
		edges = new HashMap<>();

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			String start = st.nextToken();
			String end = st.nextToken();

			items.add(start);
			items.add(end);

			if (!edges.containsKey(start)) {
				edges.put(start, new ArrayList<>());
			}

			if (!edges.containsKey(end)) {
				edges.put(end, new ArrayList<>());
			}

			edges.get(start).add(end);
			counts.put(end, counts.getOrDefault(end, 0) + 1);
			counts.put(start, counts.getOrDefault(start, 0));
		}

		StringBuilder answer = new StringBuilder();

		Queue<String> queue = new LinkedList<>();

		for (String s : counts.keySet()) {
			if (!counts.containsKey(s) || counts.get(s) == 0) {
				queue.add(s);
			}
		}

		for (String s : edges.keySet()) {
			edges.get(s).sort(String::compareTo);
		}

		int count = 0;

		while (!queue.isEmpty()) {
			int cnt = queue.size();

			List<String> nexts = new ArrayList<>();

			for (int i = 0; i < cnt; i++) {
				String now = queue.poll();

				answer.append(now).append("\n");
				count++;

				for (String next : edges.get(now)) {
					counts.put(next, counts.getOrDefault(next, 0) - 1);

					if (counts.get(next) == 0) {
						nexts.add(next);
					}
				}
			}

			nexts.sort(String::compareTo);

			queue.addAll(nexts);
		}

		if (count != items.size()) {
			System.out.println(-1);
			return;
		}
		System.out.println(answer);
	}
}
