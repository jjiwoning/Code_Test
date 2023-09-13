package baekjoon_java.P11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            }
            return Math.abs(o1) - Math.abs(o2);
        });

        for (int i = 0; i < n; i++) {
            int command = Integer.parseInt(br.readLine());

            if (command == 0) {
                if (priorityQueue.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                System.out.println(priorityQueue.poll());
            }

            if (command != 0) {
                priorityQueue.add(command);
            }
        }
    }
}
