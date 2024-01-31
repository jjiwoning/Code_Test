package study2024.week6.P22866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	private static List<Top> tops;
	private static List<Node> results;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		tops = new ArrayList<>();
		results = new ArrayList<>();

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int height = Integer.parseInt(st.nextToken());

			tops.add(new Top(i, height));
			results.add(new Node(0, Integer.MAX_VALUE, Integer.MAX_VALUE));
		}

		Stack<Top> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			Top top = tops.get(i);

			while (!stack.isEmpty() && stack.peek().height <= top.height) {
				stack.pop();
			}

			if (!stack.isEmpty()) {
				results.get(top.id).count += stack.size();
				if (results.get(top.id).minDistance > Math.abs(top.id - stack.peek().id)) {
					results.get(top.id).minDistance = Math.abs(top.id - stack.peek().id);
					results.get(top.id).minDistanceId = stack.peek().id;
				}
				if (results.get(top.id).minDistance == Math.abs(top.id - stack.peek().id)) {
					results.get(top.id).minDistanceId = Math.min(stack.peek().id, results.get(top.id).minDistanceId);
				}
			}

			stack.add(top);
		}

		stack = new Stack<>();

		for (int i = n - 1; i >= 0; i--) {
			Top top = tops.get(i);

			while (!stack.isEmpty() && stack.peek().height <= top.height) {
				stack.pop();
			}

			if (!stack.isEmpty()) {
				results.get(top.id).count += stack.size();
				if (results.get(top.id).minDistance > Math.abs(top.id - stack.peek().id)) {
					results.get(top.id).minDistance = Math.abs(top.id - stack.peek().id);
					results.get(top.id).minDistanceId = stack.peek().id;
				}
				if (results.get(top.id).minDistance == Math.abs(top.id - stack.peek().id)) {
					results.get(top.id).minDistanceId = Math.min(stack.peek().id, results.get(top.id).minDistanceId);
				}

			}

			stack.add(top);
		}

		StringBuilder answer = new StringBuilder();

		for (Node result : results) {
			if (result.count == 0) {
				answer.append("0").append("\n");
				continue;
			}
			answer.append(result.count).append(" ").append(result.minDistanceId + 1).append("\n");
		}

		System.out.println(answer);
	}
}

class Top {

	int id;

	int height;

	public Top(int id, int height) {
		this.id = id;
		this.height = height;
	}
}

class Node {
	int count;

	int minDistanceId;

	int minDistance;

	public Node(int count, int minDistanceId, int minDistance) {
		this.count = count;
		this.minDistanceId = minDistanceId;
		this.minDistance = minDistance;
	}
}
