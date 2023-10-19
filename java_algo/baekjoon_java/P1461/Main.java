package baekjoon_java.P1461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> minusNumbers = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> plusNumbers = new PriorityQueue<>((o1, o2) -> o2 - o1);

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num < 0) {
                minusNumbers.add(Math.abs(num));
            }
            if (num > 0) {
                plusNumbers.add(num);
            }
        }

        int answer = findMaxDistance(minusNumbers, plusNumbers, m);

        while (!minusNumbers.isEmpty()) {
            int find = minusNumbers.peek();
            for (int i = 0; i < m; i++) {
                if (!minusNumbers.isEmpty()) {
                    minusNumbers.poll();
                }
            }
            answer += find * 2;
        }

        while (!plusNumbers.isEmpty()) {
            int find = plusNumbers.peek();
            for (int i = 0; i < m; i++) {
                if (!plusNumbers.isEmpty()) {
                    plusNumbers.poll();
                }
            }
            answer += find * 2;
        }

        System.out.println(answer);
    }

    private static int findMaxDistance(PriorityQueue<Integer> minusNumbers, PriorityQueue<Integer> plusNumbers, int m) {
        if (plusNumbers.isEmpty() && minusNumbers.isEmpty()) {
            return 0;
        }

        if (minusNumbers.isEmpty()) {
            int num = plusNumbers.peek();
            for (int i = 0; i < m; i++) {
                if (!plusNumbers.isEmpty()) {
                    plusNumbers.poll();
                }
            }
            return num;
        }

        if (plusNumbers.isEmpty()) {
            int num = minusNumbers.peek();
            for (int i = 0; i < m; i++) {
                if (!minusNumbers.isEmpty()) {
                    minusNumbers.poll();
                }
            }
            return num;
        }

        if (minusNumbers.peek() >= plusNumbers.peek()) {
            int num = minusNumbers.peek();
            for (int i = 0; i < m; i++) {
                if (!minusNumbers.isEmpty()) {
                    minusNumbers.poll();
                }
            }
            return num;
        }

        if (plusNumbers.peek() > minusNumbers.peek()) {
            int num = plusNumbers.peek();
            for (int i = 0; i < m; i++) {
                if (!plusNumbers.isEmpty()) {
                    plusNumbers.poll();
                }
            }
            return num;
        }

        throw new IllegalArgumentException();
    }
}
