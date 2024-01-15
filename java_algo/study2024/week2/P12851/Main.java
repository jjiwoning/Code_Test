package study2024.week2.P12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int[] visited;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		visited = new int[100001];
		Arrays.fill(visited, Integer.MAX_VALUE);

		Node answer = bfs(n, k);
		System.out.println(answer.position);
		System.out.println(answer.count);
	}

	private static Node bfs(int n, int k) {
		Node answer = null;
		Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.count - o2.count);
		queue.add(new Node(n, 0));
		visited[n] = 0;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			if (answer != null) {
				if (now.count > answer.position) {
					return answer;
				}
			}

			if (now.position == k) {
				if (answer == null) {
					answer = new Node(now.count, 1);
					continue;
				}
				answer.count += 1;
				continue;
			}

			// + 1
			if (now.position < 100000 && visited[now.position + 1] >= now.count) {
				visited[now.position + 1] = now.count;
				queue.add(new Node(now.position + 1, now.count + 1));
			}

			// - 1
			if (now.position > 0 && visited[now.position - 1] >= now.count) {
				visited[now.position - 1] = now.count;
				queue.add(new Node(now.position - 1, now.count + 1));
			}

			// * 2
			if (now.position * 2 <= 100000 && visited[now.position * 2] >= now.count) {
				visited[now.position * 2] = now.count;
				queue.add(new Node(now.position * 2, now.count + 1));
			}
		}

		if (answer == null) {
			return new Node(0, 1);
		}

		return answer;
	}
}

class Node {
	int position;
	int count;

	public Node(int position, int count) {
		this.position = position;
		this.count = count;
	}
}
