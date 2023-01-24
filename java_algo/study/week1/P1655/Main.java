package study.week1.P1655;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            if (maxQueue.size() == minQueue.size()) {
                maxQueue.offer(sc.nextInt());
            } else {
                minQueue.offer(sc.nextInt());
            }

            if (!maxQueue.isEmpty() && !minQueue.isEmpty()) {
                if (maxQueue.peek() < maxQueue.peek()) {
                    int temp = maxQueue.poll();
                    maxQueue.add(minQueue.poll());
                    minQueue.add(temp);
                }
            }
            System.out.println(maxQueue.peek());
        }
    }
}
