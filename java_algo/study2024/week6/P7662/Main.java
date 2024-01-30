package study2024.week6.P7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();

		for (int t = 0; t < testCase; t++) {
			TreeMap<Integer, Integer> map = new TreeMap<>();

			int n = Integer.parseInt(br.readLine());

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String type = st.nextToken();
				int value = Integer.parseInt(st.nextToken());

				if ("I".equals(type)) {
					if (!map.containsKey(value)) {
						map.put(value, 1);
						continue;
					}
					map.put(value, map.get(value) + 1);
				}

				if ("D".equals(type)) {
					if (map.isEmpty()) {
						continue;
					}
					if (value == -1) {
						Integer key = map.firstKey();
						if (map.get(key) == 1) {
							map.remove(key);
							continue;
						}
						map.put(key, map.get(key) - 1);
					}
					if (value == 1) {
						Integer key = map.lastKey();
						if (map.get(key) == 1) {
							map.remove(key);
							continue;
						}
						map.put(key, map.get(key) - 1);
					}
				}
			}

			if (map.isEmpty()) {
				answer.append("EMPTY").append("\n");
				continue;
			}
			answer.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
		}

		System.out.println(answer);
	}
}
