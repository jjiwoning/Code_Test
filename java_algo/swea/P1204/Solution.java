package swea.P1204;

import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int[] totalScore = new int[101];
            int testCase = sc.nextInt();

            for (int i = 0; i < 1000; i++) {
                int score = sc.nextInt();
                totalScore[score]++;
            }

            int maxVal = -1;
            int num = -1;
            for (int i = 0; i < totalScore.length; i++) {
                if (maxVal <= totalScore[i]) {
                    maxVal = totalScore[i];
                    num = i;
                }
            }

            System.out.println("#" + testCase + " " + num);
        }
    }
}
