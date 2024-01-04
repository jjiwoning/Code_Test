package Programmers_java.kakao42892;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	private int index;
	private int[][] answer;
	private List<Node> nodes;

	public int[][] solution(int[][] nodeinfo) {
		answer = new int[2][nodeinfo.length]; // 0: 전위 순회, 1: 후위 순회
		nodes = new ArrayList<>();
		for (int i = 0; i < nodeinfo.length; i++) {
			nodes.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
		}

		nodes.sort((o1, o2) -> {
			if (o1.y == o2.y) {
				return o1.x - o2.x;
			}
			return o2.y - o1.y;
		});

		Node root = nodes.get(0);

		for (int i = 1; i < nodes.size(); i++) {
			insertNode(root, nodes.get(i));
		}

		index = 0;
		preOrder(root);
		index = 0;
		postOrder(root);

		return answer;
	}

	private void insertNode(Node root, Node target) {
		if (root.x < target.x) {
			if (root.rightNode == null) {
				root.rightNode = target;
				return;
			}
			insertNode(root.rightNode, target);
			return;
		}
		if (root.x > target.x) {
			if (root.leftNode == null) {
				root.leftNode = target;
				return;
			}
			insertNode(root.leftNode, target);
			return;
		}
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		answer[0][index++] = node.number;
		preOrder(node.leftNode);
		preOrder(node.rightNode);
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.leftNode);
		postOrder(node.rightNode);
		answer[1][index++] = node.number;
	}
}

class Node {
	int number;
	int x;
	int y;
	Node leftNode;
	Node rightNode;

	public Node(int number, int x, int y) {
		this.number = number;
		this.x = x;
		this.y = y;
	}
}
