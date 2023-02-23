package study.week4.P4811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) throws IOException {


        // 아직 못품
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] answer = new long[31];

        answer[1] = 1;

        for (int i = 2; i < 31; i++) {
            answer[i] = (long) (answer[i - 1] + pow(3, i - 2));
        }

        while (true) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                break;
            }

            System.out.println(answer[num]);
        }
    }
}
