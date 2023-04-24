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
        int end = n - 1;

        // 투 포인터 + 이진 탐색
        while (start < end) {
            long sum = arr[start] + arr[end];
            int binarySearchStart = start;
            int binarySearchEnd = end;

            while (binarySearchStart < binarySearchEnd) {
                int mid = (binarySearchStart + binarySearchEnd) / 2;

                if (start == mid || end == mid) {
                    break;
                }

                if (Math.abs(sum + arr[mid]) < targetValue) {
                    targetValue = Math.abs(sum + arr[mid]);
                    answer[0] = arr[start];
                    answer[1] = arr[mid];
                    answer[2] = arr[end];
                }

                if (targetValue == 0) {
                    System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
                    return;
                }

                if (sum + arr[mid] > 0) {
                    binarySearchEnd = mid - 1;
                }

                if (sum + arr[mid] < 0) {
                    binarySearchStart = mid + 1;
                }

            }

            if (sum < 0) {
                start++;
            }

            if (sum > 0) {
                end--;
            }
        }

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }

}
