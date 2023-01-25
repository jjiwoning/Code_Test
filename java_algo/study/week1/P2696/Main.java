package study.week1.P2696;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            int count = sc.nextInt();
            int a = 0;
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < count; j++) {
                if (maxHeap.size() == minHeap.size()) {
                    if (maxHeap.isEmpty()) {
                        maxHeap.add(sc.nextInt());
                        a++;
                        sb.append(maxHeap.peek()).append(" ");
                        continue;
                    }
                    maxHeap.add(sc.nextInt());
                    if (maxHeap.peek() > minHeap.peek()) {
                        Integer temp = maxHeap.poll();
                        maxHeap.add(minHeap.poll());
                        minHeap.add(temp);
                    }
                    a++;
                    sb.append(maxHeap.peek()).append(" ");
                } else {
                    minHeap.add(sc.nextInt());
                }
            }

            System.out.println(a);
            System.out.println(sb.toString());
        }

    }
}
