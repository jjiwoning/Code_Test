package study.week11.P11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] leftDp = new int[n];
        int[] rightDp = new int[n];
        leftDp[0] = 1;
        rightDp[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    leftDp[i] = Math.max(leftDp[i], leftDp[j] + 1);
                }
            }
            leftDp[i] = Math.max(leftDp[i], 1);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                if (arr[i] > arr[j]) {
                    rightDp[i] = Math.max(rightDp[i], rightDp[j] + 1);
                }
            }
            rightDp[i] = Math.max(rightDp[i], 1);
        }

        int answer = -1;

        for (int i = 0; i < n; i++) {
            answer = Math.max(leftDp[i] + rightDp[i] - 1, answer);
        }

        System.out.println(answer);
    }

}
