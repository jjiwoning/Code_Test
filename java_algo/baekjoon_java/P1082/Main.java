package baekjoon_java.P1082;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] costs = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		int money = Integer.parseInt(br.readLine());

		if (n == 1) {
			System.out.println(0);
			return;
		}

		Node[] nodes = new Node[n];

		for (int i = 0; i < n; i++) {
			nodes[i] = new Node(i, costs[i]);
		}

		Arrays.sort(nodes, (o1, o2) -> o1.cost - o2.cost);

		Node target = nodes[0];
		StringBuilder answer = new StringBuilder();

		if (nodes[0].number == 0) {
			if (nodes[1].cost > money) {
				System.out.println(0);
				return;
			}
			answer.append(nodes[1].number);
			money -= nodes[1].cost;
		}

		while (true) {
			if (money >= target.cost) {
				answer.append(target.number);
				money -= target.cost;
			}
			if (money < target.cost) {
				break;
			}
		}

		for (int i = 0; i < answer.length(); i++) {
			int num = answer.charAt(i) - '0';
			for (int j = n - 1; j >= 0; j--) {
				if (money + costs[num] - costs[j] >= 0) {
					answer.replace(i, i + 1, String.valueOf(j));
					money = money + costs[num] - costs[j];
					break;
				}
			}
		}

		System.out.println(answer);
	}
}

class Node {
	int number;
	int cost;

	public Node(int number, int cost) {
		this.number = number;
		this.cost = cost;
	}
}
