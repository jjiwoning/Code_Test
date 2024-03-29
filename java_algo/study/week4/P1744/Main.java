package study.week4.P1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> numList = new LinkedList<>();

        int minusCount = 0;
        int zeroCount = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number < 0) {
                minusCount++;
            }
            if (number == 0) {
                zeroCount++;
            }
            numList.add(number);
        }

        numList.sort((o1, o2) -> o2 - o1); // 로직 1

        int answer = 0;

        while (!numList.isEmpty()) {
            Integer num = numList.pollFirst();

            if (num == 0) { // 로직 2
                continue;
            }

            if (num < 0 && minusCount % 2 == 1 && zeroCount > 0) { // 로직 3
                // 상쇄 시켜야 되니까 그냥 넘어감
                zeroCount = 0;
                minusCount--;
                continue;
            }

            if (num < 0 && minusCount % 2 == 1) { // 로직 4
                answer += num;
                minusCount--;
                continue;
            }

            if (numList.isEmpty() || numList.peekFirst() == 0 || num * numList.peekFirst() <= num) {
                answer += num;
                continue;
            }

            Integer nextNum = numList.pollFirst();

            answer += (num * nextNum);
        }

        System.out.println(answer);
    }
}
