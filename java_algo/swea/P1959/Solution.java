package swea.P1959;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] a = new int[n];
            int[] b = new int[m];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }

            int answer = 0;

            if (n < m) {
                answer = getMaxValue(a, b);
            } else {
                answer = getMaxValue(b, a);
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }

    private static int getMaxValue(int[] a, int[] b) {
        int maxVal = 0;
        for (int i = 0; i < b.length - a.length + 1; i++) {
            int value = 0;
            for (int j = 0; j < a.length; j++) {
                value += (a[j] * b[i + j]);
            }
            maxVal = Math.max(maxVal, value);
        }

        return maxVal;
    }
}
