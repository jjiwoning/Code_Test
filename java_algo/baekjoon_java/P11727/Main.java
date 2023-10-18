package baekjoon_java.P11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i < n + 1; i++) {
            dp[i] += dp[i - 1] % MOD;
            dp[i] %= MOD;
            if (i > 1) {
                dp[i] += ((dp[i - 2] % MOD) * 2) % MOD;
            }
            dp[i] %= MOD;
        }

        System.out.println(dp[n] % MOD);
    }
}
