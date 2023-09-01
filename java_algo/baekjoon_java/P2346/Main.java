package baekjoon_java.P2346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Balloon> balloons = inputBalloons(br, n);

        StringBuilder answer = new StringBuilder();

        int target = 0;

        while (!balloons.isEmpty()) {
            if (target >= 0) {
                for (int i = 0; i < target - 1; i++) {
                    balloons.addLast(balloons.pollFirst());
                }
                Balloon balloon = balloons.pollFirst();
                answer.append(balloon.index).append(" ");
                target = balloon.value;
                continue;
            }
            if (target < 0) {
                for (int i = 0; i < Math.abs(target) - 1; i++) {
                    balloons.addFirst(balloons.pollLast());
                }
                Balloon balloon = balloons.pollLast();
                answer.append(balloon.index).append(" ");
                target = balloon.value;
            }
        }

        System.out.println(answer);
    }

    private static Deque<Balloon> inputBalloons(BufferedReader br, int n) throws IOException {
        Deque<Balloon> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            deque.add(new Balloon(i, st.nextToken()));
        }

        return deque;
    }

    private static class Balloon {
        int index;
        int value;

        public Balloon(int index, String value) {
            this.index = index;
            this.value = Integer.parseInt(value);
        }
    }
}
