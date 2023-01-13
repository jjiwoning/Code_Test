package baekjoon_java.P14888;

import java.util.Scanner;

public class Main {

    private static int max = -1000000001;
    private static int min = 1000000001;
    private static int[] cal;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        cal = new int[4];
        // 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다.
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            cal[i] = sc.nextInt();
        }

        dfs(1, n, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int index, int n, int sum) {
        if (index == n) {
            max = Math.max(sum, max);
            min = Math.min(sum, min);
        }

        for (int i = 0; i < 4; i++) {
            if (i == 0) { // 덧셈
                if (cal[i] > 0) {
                    cal[i]--;
                    dfs(index + 1, n, sum + arr[index]);
                    cal[i]++;
                }
            }

            if (i == 1) { // 뺄셈
                if (cal[i] > 0) {
                    cal[i]--;
                    dfs(index + 1, n, sum - arr[index]);
                    cal[i]++;
                }
            }

            if (i == 2) { // 곱셈
                if (cal[i] > 0) {
                    cal[i]--;
                    dfs(index + 1, n, sum * arr[index]);
                    cal[i]++;
                }
            }

            if (i == 3) { // 나눗셈
                if (cal[i] > 0) {
                    cal[i]--;
                    dfs(index + 1, n, sum / arr[index]);
                    cal[i]++;
                }
            }
        }
    }
}
