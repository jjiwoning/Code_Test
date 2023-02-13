package baekjoon_java.P1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            queue.add(i);
        }

        StringBuilder answer = new StringBuilder();
        answer.append("<");

        while (!queue.isEmpty()) {
            for (int i = 0; i < m - 1; i++) {
                queue.add(queue.poll());
            }
            answer.append(queue.poll()).append(", ");
        }

        answer.delete(answer.length() - 2, answer.length());
        answer.append(">");

        System.out.println(answer);
    }
}
