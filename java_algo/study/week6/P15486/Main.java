package study.week6.P15486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 2];
        int beforeMax = 0;

        for (int i = 1; i < n + 1; i++) {
            String[] s = br.readLine().split(" ");
            int day = Integer.parseInt(s[0]);
            int cost = Integer.parseInt(s[1]);

            beforeMax = max(beforeMax, dp[i]);

            if (i + day > n + 1) {
                continue;
            }

            dp[i + day] = max(dp[i + day], beforeMax + cost);

        }

        int answer = -1;

        for (int i = 1; i < n + 2; i++) {
            answer = max(answer, dp[i]);
        }

        System.out.println(answer);
    }

}
