package study.week3.P1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<String, Node> map = new HashMap<>();
    static StringBuilder preorderAnswer;
    static StringBuilder inorderAnswer;
    static StringBuilder postorderAnswer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            Node node = map.getOrDefault(s[0], new Node(s[0]));
            map.put(s[0], node);
            if (!s[1].equals(".")) {
                node.left = new Node(s[1]);
                node.left.parent = node;
                map.put(s[1], node.left);
            }
            if (!s[2].equals(".")) {
                node.right = new Node(s[2]);
                node.right.parent = node;
                map.put(s[2], node.right);
            }
        }

        preorderAnswer = new StringBuilder();
        inorderAnswer = new StringBuilder();
        postorderAnswer = new StringBuilder();

        preorder(map.get("A"));
        inorder(map.get("A"));
        postorder(map.get("A"));

        System.out.println(preorderAnswer);
        System.out.println(inorderAnswer);
        System.out.println(postorderAnswer);
    }

    private static void preorder(Node node) {
        preorderAnswer.append(node.value);
        if (node.left != null) {
            preorder(node.left);
        }
        if (node.right != null) {
            preorder(node.right);
        }
    }

    private static void inorder(Node node) {
        if (node.left != null) {
            inorder(node.left);
        }
        inorderAnswer.append(node.value);
        if (node.right != null) {
            inorder(node.right);
        }
    }

    private static void postorder(Node node) {
        if (node.left != null) {
            postorder(node.left);
        }
        if (node.right != null) {
            postorder(node.right);
        }
        postorderAnswer.append(node.value);
    }

    private static class Node {
        String value;
        Node left;
        Node right;
        Node parent;

        public Node(String value) {
            this.value = value;
        }
    }

}
