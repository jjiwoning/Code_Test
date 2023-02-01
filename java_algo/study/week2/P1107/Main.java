package study.week2.P1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int answer;
    static boolean[] numbers;
    static int numLength;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        numbers = new boolean[10];
        Arrays.fill(numbers, true);

        if (m != 0) {
            String[] s = br.readLine().split(" ");

            for (int i = 0; i < m; i++) {
                numbers[Integer.parseInt(s[i])] = false;
            }
        }

        answer = Math.abs(n - 100);

        String num = n + "";
        numLength = num.length();

        if (answer != 0) {
            dfs(0, 0, "");
        }

        System.out.println(answer);
    }

    private static void dfs(int index, int count, String makeNum) {
        if (index == numLength) {
            int newCount = count + Math.abs(Integer.parseInt(makeNum) - n);
            answer = Math.min(answer, newCount);
        }

        if (numLength > 1 && index == numLength - 1) {
            int newCount = count + Math.abs(Integer.parseInt(makeNum) - n);
            answer = Math.min(newCount, answer);
        }

        if (index == numLength + 1) {
            count += Math.abs(Integer.parseInt(makeNum) - n);
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (numbers[i]) {
                dfs(index + 1, count + 1, makeNum + i);
            }
        }
    }
}
