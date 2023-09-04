package baekjoon_java.P1094;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        int stick = 64;

        while (n > 0) {
            if (stick > n) {
                stick /= 2;
                continue;
            }
            answer++;
            n -= stick;
        }

        System.out.println(answer);
    }
}
