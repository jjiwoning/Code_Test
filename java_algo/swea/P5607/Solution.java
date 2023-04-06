package swea.P5607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static final int MOD_CONST = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            long result = findAnswer(n, r);

            answer.append("#").append(testCase).append(" ").append(result).append("\n");
        }

        System.out.println(answer);

    }

    private static long findAnswer(int n, int r) {
        long answer = 1L;

        for (int i = 1; i < n + 1; i++) {
            answer *= i;
            answer %= MOD_CONST;
        }

        int m = n - r;

        long nMinusRFactorial = 1L;

        for (int i = 1; i < m + 1; i++) {
            nMinusRFactorial *= i;
            nMinusRFactorial %= MOD_CONST;
        }
        nMinusRFactorial = getPowerValue(nMinusRFactorial, MOD_CONST - 2) % MOD_CONST;

        long rFactorial = 1L;
        for (int i = 1; i < r + 1; i++) {
            rFactorial *= i;
            rFactorial %= MOD_CONST;
        }
        rFactorial = getPowerValue(rFactorial, MOD_CONST - 2) % MOD_CONST;

        answer *= nMinusRFactorial;
        answer %= MOD_CONST;
        answer *= rFactorial;
        answer %= MOD_CONST;

        return answer % MOD_CONST;
    }

    private static long getPowerValue(long value, int power) {
        if (power == 0) {
            return 1;
        }

        long halfPower = getPowerValue(value, power / 2);
        long result = (halfPower * halfPower) % MOD_CONST;

        if (power % 2 == 1) {
            result = (result * value) % MOD_CONST;
        }

        return result;
    }
}
