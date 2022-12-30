package swea.P1209;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++) {
            int testCase = sc.nextInt();
            int answer = 0;
            int[][] arr = new int[100][100];

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int sum3 = 0;
            int sum4 = 0;

            for (int i = 0; i < 100; i++) {
                int sum1 = 0;
                int sum2 = 0;
                sum3 += arr[i][i];
                sum4 += arr[i][99 - i];

                for (int j = 0; j < 100; j++) {
                    sum1 += arr[i][j];
                    sum2 += arr[j][i];
                }

                answer = Math.max(sum1, answer);
                answer = Math.max(sum2, answer);
            }

            answer = Math.max(sum3, answer);
            answer = Math.max(sum4, answer);

            System.out.println("#" + testCase + " " + answer);
        }
    }

}
