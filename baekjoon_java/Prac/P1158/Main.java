package baekjoon_java.Prac.P1158;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        sb.append("<");

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            queue.add(i);
        }

        while (queue.size() > 1){
            for (int i = 0; i < K - 1; i++) {
                int num = queue.poll();
                queue.add(num);
            }
            sb.append(queue.poll() + ", ");
        }

        sb.append(queue.poll() + ">");
        System.out.println(sb);
    }

}
