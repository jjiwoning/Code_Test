package study.week4.P4811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] answer = new long[31];

        answer[0] = 1;
        answer[1] = 1;
        answer[2] = 2;

        for (int i = 3; i < 31; i++) {
            long count = 0;

            for (int j = 0; j < i; j++) {
                count += answer[j] * answer[i - j - 1];
            }

            answer[i] = count;
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            System.out.println(answer[n]);
        }
    }
}
