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

        int[] dpStart = new int[n];
        int[] dpEnd = new int[n];
        dpStart[0] = 1;
        dpEnd[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dpStart[i] = Math.max(dpStart[i], dpStart[j] + 1);
                }
            }
            dpStart[i] = Math.max(dpStart[i], 1);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                if (arr[i] > arr[j]) {
                    dpEnd[i] = Math.max(dpEnd[i], dpEnd[j] + 1);
                }
            }
            dpEnd[i] = Math.max(dpEnd[i], 1);
        }

        int answer = -1;

        for (int i = 0; i < n; i++) {
            answer = Math.max(dpStart[i] + dpEnd[i] - 1, answer);
        }

        System.out.println(answer);
    }

}
