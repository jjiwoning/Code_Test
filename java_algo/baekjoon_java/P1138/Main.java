package baekjoon_java.P1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static int n;

	private static boolean[] visited;
	private static List<Person> personList;
	private static Person[] people;
	private static StringBuilder answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		personList = new ArrayList<>();
		visited = new boolean[n];
		people = new Person[n];

		for (int i = 1; i <= n; i++) {
			int number = Integer.parseInt(st.nextToken());
			personList.add(new Person(i, number));
		}

		dfs(0);

		System.out.println(answer);
	}

	private static void dfs(int depth) {

		if (depth == n) {
			for (int i = 0; i < n; i++) {
				int count = 0;
				for (int j = 0; j < i; j++) {
					if (people[i].heigth < people[j].heigth) {
						count++;
					}
				}
				if (count != people[i].count) {
					return;
				}
			}
			answer = new StringBuilder();
			for (int i = 0; i < n; i++) {
				answer.append(people[i].heigth).append(" ");
			}
			return;
		}

		if (answer != null) {
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				people[depth] = personList.get(i);
				dfs(depth + 1);
				visited[i] = false;
				people[depth] = null;
			}
		}
	}
}

class Person {
	int heigth;
	int count;

	public Person(int heigth, int count) {
		this.heigth = heigth;
		this.count = count;
	}
}
