package study.week14.P2473;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] answer = new int[3];
        long targetValue = Long.MAX_VALUE;

        Arrays.sort(arr);

        int start = 0;

        while (start < n - 1) {
            int mid = start + 1;
            int end = n - 1;
            long startValue = arr[start];
            while (mid < end) {

                long now = startValue + arr[mid] + arr[end];

                if (Math.abs(now) < targetValue) {
                    targetValue = Math.abs(now);
                    answer[0] = arr[start];
                    answer[1] = arr[mid];
                    answer[2] = arr[end];
                }

                if (now == 0) {
                    System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
                    return;
                }

                if (now > 0) {
                    end--;
                }

                if (now < 0) {
                    mid++;
                }
            }

            start++;
        }

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }

}
