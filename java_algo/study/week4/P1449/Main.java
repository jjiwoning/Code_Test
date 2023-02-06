package study.week4.P1449;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");

        int n = Integer.parseInt(s1[0]);
        int l = Integer.parseInt(s1[1]);

        int[] pipes = new int[n];

        for (int i = 0; i < n; i++) {
            pipes[i] = Integer.parseInt(s2[i]);
        }

        Arrays.sort(pipes);

        int answer = 0;
        boolean taping = false;
        int now = 0;

        for (int pipe : pipes) {
            if (!taping) {
                answer++;
                taping = true;
                now = pipe + l - 1;
            }
            if (taping) {
                if (pipe > now) {
                    answer++;
                    now = pipe + l - 1;
                }
            }
        }

        System.out.println(answer);
    }
}
