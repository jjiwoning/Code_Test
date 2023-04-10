package study.week12.P1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr); // binarySearch를 위한 sort

        int answer = 0; // 정답 개수

        for (int i = 0; i < n; i++) { // n개의 수에 대해서 binarySearch
            int wanted = arr[i]; // target Number
            int start = 0;
            int end = n - 1;

            while (start < end) {
                int value = arr[start] + arr[end];

                if (value == wanted) {
                    if (start != i && end != i) {
                        answer++;
                        break;
                    }
                    if (start == i) {
                        start++;
                    }
                    if (end == i) {
                        end--;
                    }
                }

                if (value < wanted) {
                    start++;
                }

                if (value > wanted) {
                    end--;
                }
            }
        }

        System.out.println(answer);
    }
}
