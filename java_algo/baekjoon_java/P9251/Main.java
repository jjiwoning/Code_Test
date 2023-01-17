package baekjoon_java.P9251;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] chars1 = sc.next().toCharArray();
        char[] chars2 = sc.next().toCharArray();

        int char1Length = chars1.length;
        int char2Length = chars2.length;

        int[][] dp = new int[char1Length + 1][char2Length + 1];

        for (int i = 1; i <= char1Length; i++) {
            for (int j = 1; j <= char2Length; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println(dp[char1Length][char2Length]);
    }
}
