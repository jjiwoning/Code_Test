package baekjoon_java.P3584;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static boolean[] visited;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < testCase; i++) {
			int nodeCount = Integer.parseInt(br.readLine());
			Node[] nodes = new Node[nodeCount + 1];
			visited = new boolean[nodeCount + 1];
			answer = 0;

			for (int j = 1; j <= nodeCount; j++) {
				nodes[j] = new Node(j);
			}

			for (int j = 0; j < nodeCount - 1; j++) {
				st = new StringTokenizer(br.readLine());
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());

				nodes[child].parent = nodes[parent];
			}

			st = new StringTokenizer(br.readLine());

			int target1 = Integer.parseInt(st.nextToken());
			int target2 = Integer.parseInt(st.nextToken());

			dfs(nodes[target1]);
			dfs(nodes[target2]);

			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}

	private static void dfs(Node now) {
		if (visited[now.num]) {
			answer = now.num;
			return;
		}
		visited[now.num] = true;
		if (now.parent == null) {
			return;
		}
		dfs(now.parent);
	}
}

class Node {
	int num;
	Node parent;

	public Node(int num) {
		this.num = num;
	}

	public Node(int num, Node parent) {
		this.num = num;
		this.parent = parent;
	}
}
