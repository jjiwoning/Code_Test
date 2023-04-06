package baekjoon_java.P2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] wantedMoney = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxMoney = Integer.parseInt(br.readLine());
        int start = 0;
        int end = Arrays.stream(wantedMoney).max().orElseThrow(() -> new IllegalArgumentException("틀림"));

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = findSum(wantedMoney, mid);

            if (sum <= maxMoney) {
                start = mid + 1;
            }

            if (sum > maxMoney) {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }

    private static int findSum(int[] arr, int money) {
        int sum = 0;
        for (int m : arr) {
            if (m < money) {
                sum += m;
                continue;
            }
            sum += money;
        }
        return sum;
    }
}
