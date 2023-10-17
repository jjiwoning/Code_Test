package baekjoon_java.P9084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int coinCount = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int targetMoney = Integer.parseInt(br.readLine());

            int[] dp = new int[targetMoney + 1];

            dp[0] = 1; // dp init

            for (int j = 0; j < coinCount; j++) {
                int coin = Integer.parseInt(st.nextToken());
                for (int money = coin; money < targetMoney + 1; money++) {
                    dp[money] += dp[money - coin];
                }
            }

            System.out.println(dp[targetMoney]);
        }
    }
}
