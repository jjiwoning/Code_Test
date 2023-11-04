package baekjoon_java.P1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}

		int count = 0;
		Set<String> answer = new TreeSet<>();

		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			if (set.contains(s)) {
				count++;
				answer.add(s);
			}
		}

		System.out.println(count);
		answer.forEach(System.out::println);
	}
}
