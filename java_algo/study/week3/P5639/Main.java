package study.week3.P5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기값 세팅
        int start = Integer.parseInt(br.readLine());
        Node root = new Node(start);

        while (true) {
            String s = br.readLine();
            if (s == null || "".equals(s)) {
                break;
            }
            int value = Integer.parseInt(s);
            root.add(value);
        }

        postOrderSearch(root);
    }

    private static void postOrderSearch(Node root) {
        if (root.left == null && root.right == null) { // 리프 노드에서 탈출해야 된다.
            System.out.println(root.value);
            return;
        }
        if (root.left != null) { // 왼쪽 먼저 탐색
            postOrderSearch(root.left);
        }
        if (root.right != null) { // 그 다음 오른쪽
            postOrderSearch(root.right);
        }
        System.out.println(root.value); // 그 다음 현재 노드
    }

    // 트리 구현 참고 링크: https://st-lab.tistory.com/300
    static class Node {
        int value; // 노드의 값

        Node left; // 왼쪽
        Node right; // 오른쪽
        Node parent; // 부모 -> 이진 탐색 트리에서는 꼭 안넣어줘도 된다.

        public Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;
        }

        public Node(int value) {
            this.value = value;
        }

        public void add(int num) {
            if (num < value) {
                if (this.left == null) {
                    this.left = new Node(num);
                    return;
                }
                left.add(num);
            }
            if (num > value) {
                if (this.right == null) {
                    this.right = new Node(num);
                    return;
                }
                right.add(num);
            }
        }
    }

}
