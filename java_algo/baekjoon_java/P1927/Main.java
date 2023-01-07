package baekjoon_java.P1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int in = Integer.parseInt(br.readLine());
            if (in == 0) {
                printValue(priorityQueue);
            } else {
                priorityQueue.add(in);
            }

        }

        br.close();
    }

    private static void printValue(PriorityQueue<Integer> priorityQueue) {
        if (!priorityQueue.isEmpty()) {
            Integer value = priorityQueue.poll();
            System.out.println(value);
        } else {
            System.out.println(0);
        }
    }
}
