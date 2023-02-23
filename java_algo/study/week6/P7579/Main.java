package study.week6.P7579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] memory = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxCost = Arrays.stream(cost).sum();

        int[] dp = new int[maxCost + 1];

        for (int i = 0; i < n; i++) {
            int nowMemory = memory[i];
            int nowCost = cost[i];
            for (int j = 0; j < maxCost - nowCost; j++) {
                if (dp[j] != 0) {
                    dp[j + nowCost] = Math.max(dp[j + nowCost], dp[j] + nowMemory);
                }
            }
            dp[nowCost] = Math.max(dp[nowCost], nowMemory);
        }

        for (int i = 0; i < maxCost + 1; i++) {
            if (dp[i] >= m) {
                System.out.println(i);
                break;
            }
        }
    }
}
