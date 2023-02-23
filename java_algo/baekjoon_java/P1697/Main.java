package baekjoon_java.P1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = parseInt(st.nextToken());
        int k = parseInt(st.nextToken());

        System.out.println(bfs(n, k));
    }

    private static int bfs(int n, int k) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 0));

        boolean[] visited = new boolean[100001];
        visited[n] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.getPosition() == k) {
                return now.getCount();
            }

            if (now.getPosition() < 0 || now.getPosition() > 100000) {
                continue;
            }

            if (now.getPosition() - 1 >= 0 && !visited[now.getPosition() - 1]) {
                queue.add(now.moveNode(0));
                visited[now.getPosition() - 1] = true;
            }
            if (now.getPosition() + 1 < 100001 && !visited[now.getPosition() + 1]) {
                queue.add(now.moveNode(1));
                visited[now.getPosition() + 1] = true;
            }
            if (now.getPosition() * 2 < 100001 && !visited[now.getPosition() * 2]) {
                queue.add(now.moveNode(2));
                visited[now.getPosition() * 2] = true;
            }
        }
        return 0;
    }

    static class Node {
        private int position;
        private int count;

        public Node(int position, int count) {
            this.position = position;
            this.count = count;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        private Node moveNode(int type) {
            Node node = new Node(this.position, this.count);
            if (type == 0) {
                node.setPosition(node.getPosition() - 1);
                node.setCount(node.getCount() + 1);
                return node;
            }
            if (type == 1) {
                node.setPosition(node.getPosition() + 1);
                node.setCount(node.getCount() + 1);
                return node;
            }
            if (type == 2) {
                node.setPosition(node.getPosition() * 2);
                node.setCount(node.getCount() + 1);
                return node;
            }
            throw new IllegalArgumentException("유효하지 않은 입력");
        }
    }
}
