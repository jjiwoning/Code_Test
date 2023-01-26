package study.week1.P1966;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int size = sc.nextInt();
            int wantedIndex = sc.nextInt();
            int count = 0;

            Queue<Node> queue = new LinkedList<>();

            for (int j = 0; j < size; j++) {
                queue.add(new Node(j, sc.nextInt()));
            }

            while (true) {
                Node node = queue.peek();
                boolean checked = false;
                for (Node node1 : queue) {
                    if (node.value < node1.value) {
                        checked = true;
                        break;
                    }
                }
                if (checked) {
                    queue.add(queue.poll());
                } else {
                    Node find = queue.poll();
                    count++;
                    if (find.index == wantedIndex) {
                        break;
                    }
                }
            }

            System.out.println(count);
        }
    }

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

}
