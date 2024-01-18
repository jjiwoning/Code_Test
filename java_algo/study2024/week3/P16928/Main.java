package study2024.week3.P16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static boolean[] visited;
	private static Map<Integer, Integer> moves;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		var n = Integer.parseInt(st.nextToken());
		var m = Integer.parseInt(st.nextToken());

		moves = new HashMap<>();
		visited = new boolean[101];

		for (int i = 0; i < n + m; i++) {
			st = new StringTokenizer(br.readLine());
			var start = Integer.parseInt(st.nextToken());
			var end = Integer.parseInt(st.nextToken());

			moves.put(start, end);
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.count - o2.count);
		queue.add(new Node(1, 0));
		visited[1] = true;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			for (int i = 1; i <= 6; i++) {
				int movePosition = moves.getOrDefault(now.position + i, now.position + i);

				if (movePosition > 100) {
					continue;
				}

				if (movePosition == 100) {
					return now.count + 1;
				}

				if (visited[movePosition]) {
					continue;
				}

				visited[movePosition] = true;
				queue.add(new Node(movePosition, now.count + 1));
			}
		}

		throw new IllegalArgumentException();
	}
}

class Node {
	int position;
	int count;

	public Node(int position,int count) {
		this.position = position;
		this.count = count;
	}
}
