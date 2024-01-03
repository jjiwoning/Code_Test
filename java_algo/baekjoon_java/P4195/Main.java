package baekjoon_java.P4195;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	private static Map<String, String> parent;
	private static Map<String, Integer> parent2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();

		for (int testCase = 0; testCase < t; testCase++) {
			int f = Integer.parseInt(br.readLine());
			parent = new HashMap<>();
			parent2 = new HashMap<>();
			int index = 0;
			for (int i = 0; i < f; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String target1 = st.nextToken();
				String target2 = st.nextToken();
				if (!parent2.containsKey(target1)) {
					parent2.put(target1, 1);
				}
				if (!parent2.containsKey(target2)) {
					parent2.put(target2, 1);
				}
				String s = find(target1);
				String s1 = find(target2);
				if (!s.equals(s1)) {
					union(s, s1);
				}
				answer.append(parent2.get(find(s1))).append("\n");
			}
		}

		System.out.println(answer);
	}

	private static void union(String target1, String target2) {
		String s = find(target1);
		String s1 = find(target2);

		if (!s.equals(s1)) {
			if (s.compareTo(s1) < 0) {
				parent.put(s1, s);
				Integer num = parent2.get(s);
				Integer num1 = parent2.get(s1);
				parent2.put(s, num + num1);
			}
			if (s.compareTo(s1) > 0) {
				parent.put(s, s1);
				Integer num = parent2.get(s);
				Integer num1 = parent2.get(s1);
				parent2.put(s1, num + num1);
			}
		}
	}

	private static String find(String target) {
		if (!parent.containsKey(target)) {
			parent.put(target, target);
			return target;
		}

		if (parent.get(target).equals(target)) {
			return target;
		}

		String s = find(parent.get(target));
		parent.put(target, s);
		return s;
	}
}
