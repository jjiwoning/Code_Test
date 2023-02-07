package swea.P1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++) {

            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");

            int[] arr = new int[101];
            int answer = 0;
            int minValue = Integer.MAX_VALUE;
            int maxValue = Integer.MIN_VALUE;

            for (String s1 : s) {
                int num = Integer.parseInt(s1);
                minValue = Math.min(minValue, num);
                maxValue = Math.max(maxValue, num);
                arr[num]++;
            }

            for (int i = 0; i < n; i++) {
                if (minValue == maxValue) {
                    break;
                }
                arr[maxValue]--;
                arr[maxValue - 1]++;
                arr[minValue]--;
                arr[minValue + 1]++;
                while (arr[maxValue] == 0) {
                    maxValue--;
                }
                while (arr[minValue] == 0) {
                    minValue++;
                }
            }

            System.out.println("#" + test_case + " " + (maxValue - minValue));
        }
    }

}
