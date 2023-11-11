package Programmers_java.kakao81303;

import java.util.Stack;

public class Solution {
	public String solution(int n, int k, String[] cmd) {
		Nodes nodes = new Nodes(n, k);

		for (String command : cmd) {
			if (command.equals("Z")) {
				nodes.recovery();
				continue;
			}
			if (command.equals("C")) {
				nodes.delete();
				continue;
			}
			String[] split = command.split(" ");
			if (split[0].equals("U")) {
				nodes.up(Integer.parseInt(split[1]));
			}
			if (split[0].equals("D")) {
				nodes.down(Integer.parseInt(split[1]));
			}
		}

		return nodes.toString();
	}
}

class Nodes {

	Node now;
	Node[] nodes;
	Stack<Node> deleted = new Stack<>();

	public Nodes(int n, int k) {
		this.nodes = new Node[n];
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				nodes[i] = new Node(i);
				continue;
			}
			nodes[i] = new Node(i, nodes[i - 1]);
		}
		now = nodes[k];
	}

	// 표의 범위를 벗어나는 이동은 입력으로 주어지지 않습니다.
	public void down(int move) {
		for (int i = 0; i < move; i++) {
			this.now = now.nextNode;
		}
	}

	public void up(int move) {
		for (int i = 0; i < move; i++) {
			this.now = now.beforeNode;
		}
	}

	public void delete() {
		deleted.add(this.now);
		if (now.nextNode == null) {
			Node beforeNode = this.now.beforeNode;
			beforeNode.nextNode = now.nextNode;
			this.now = beforeNode;
			return;
		}
		if (now.beforeNode == null) {
			Node nextNode = this.now.nextNode;
			nextNode.beforeNode = now.beforeNode;
			this.now = nextNode;
			return;
		}
		Node beforeNode = this.now.beforeNode;
		Node nextNode = this.now.nextNode;

		beforeNode.nextNode = now.nextNode;
		nextNode.beforeNode = now.beforeNode;
		this.now = nextNode;
	}

	// 원래대로 복구할 행이 없을 때(즉, 삭제된 행이 없을 때) "Z"가 명령어로 주어지는 경우는 없습니다.
	public void recovery() {
		Node pop = deleted.pop();
		Node beforeNode = pop.beforeNode;
		Node nextNode = pop.nextNode;

		if (beforeNode != null) {
			beforeNode.nextNode = pop;
		}
		if (nextNode != null) {
			nextNode.beforeNode = pop;
		}
	}

	@Override
	public String toString() {
		StringBuilder answer = new StringBuilder();
		answer.append("O".repeat(nodes.length));
		while (!deleted.isEmpty()) {
			Node node = deleted.pop();
			answer.setCharAt(node.value, 'X');
		}
		return answer.toString();
	}
}

class Node {

	int value;
	Node beforeNode;
	Node nextNode;

	public Node(int value) {
		this.value = value;
	}

	public Node(int value, Node beforeNode) {
		this.value = value;
		this.beforeNode = beforeNode;
		beforeNode.nextNode = this;
	}
}
