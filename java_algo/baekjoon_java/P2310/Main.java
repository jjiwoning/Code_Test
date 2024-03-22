package baekjoon_java.P2310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static Map<Integer, Node> nodes;
	private static List<List<Integer>> edges;
	private static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		while (true) {
			n = Integer.parseInt(br.readLine());

			if (n == 0) {
				System.out.println(answer);
				return;
			}

			nodes = new HashMap<>();
			edges = new ArrayList<>();
			visited = new int[n + 1];
			Arrays.fill(visited, -1);

			for (int i = 0; i < n + 1; i++) {
				edges.add(new ArrayList<>());
			}

			for (int i = 1; i <= n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				String type = st.nextToken();
				int money = Integer.parseInt(st.nextToken());

				nodes.put(i, new Node(type, money));

				while (true) {
					int edge = Integer.parseInt(st.nextToken());

					if (edge == 0) {
						break;
					}

					edges.get(i).add(edge);
				}
			}

			if (bfs()) {
				answer.append("Yes").append("\n");
				continue;
			}
			answer.append("No").append("\n");
		}
	}

	private static boolean bfs() {
		Queue<Person> queue = new PriorityQueue<>((o1, o2) -> o2.money - o1.money);
		Node node = nodes.get(1);
		if (node.type.equals("E")) {
			visited[1] = 0;
			queue.add(new Person(1, 0));
		}
		if (node.type.equals("L")) {
			visited[1] = 0;
			queue.add(new Person(1, node.money));
		}
		if (node.type.equals("T")) {
			return false;
		}

		while (!queue.isEmpty()) {
			Person now = queue.poll();

			if (now.nodeNumber == n) {
				return true;
			}

			for (Integer nextNodeNumber : edges.get(now.nodeNumber)) {
				Node next = nodes.get(nextNodeNumber);

				if (next.type.equals("E")) {
					if (visited[nextNodeNumber] >= now.money) {
						continue;
					}
					visited[nextNodeNumber] = now.money;
					queue.add(new Person(nextNodeNumber, now.money));
				}
				if (next.type.equals("L")) {
					if (visited[nextNodeNumber] >= Math.max(now.money, next.money)) {
						continue;
					}
					visited[nextNodeNumber] = Math.max(now.money, next.money);
					queue.add(new Person(nextNodeNumber, Math.max(now.money, next.money)));
				}
				if (next.type.equals("T")) {
					if (next.money > now.money) {
						continue;
					}
					if (visited[nextNodeNumber] >= now.money - next.money) {
						continue;
					}
					visited[nextNodeNumber] = now.money - next.money;
					queue.add(new Person(nextNodeNumber, now.money - next.money));
				}
			}
		}

		return false;
	}
}

class Person {
	int nodeNumber; // 현 위치
	int money; // 현재 가진 돈

	public Person(int nodeNumber, int money) {
		this.nodeNumber = nodeNumber;
		this.money = money;
	}
}

class Node {
	String type; // E: empty, L: Lef, T: Troll
	int money;

	public Node(String type, int money) {
		this.type = type;
		this.money = money;
	}
}
