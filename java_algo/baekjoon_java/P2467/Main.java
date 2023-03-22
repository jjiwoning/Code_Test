package baekjoon_java.P2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        Arrays.sort(arr);

        int startIndex = 0;
        int endIndex = n - 1;

        long[] answer = new long[2];
        long minVal = Long.MAX_VALUE;

        while (startIndex < endIndex) {
            long sum = arr[startIndex] + arr[endIndex];
            if (abs(sum) < minVal) {
                answer[0] = arr[startIndex];
                answer[1] = arr[endIndex];
                minVal = abs(sum);
            }
            if (sum < 0) {
                startIndex++;
            }
            if (sum >= 0) {
                endIndex--;
            }
        }

        System.out.print(answer[0] + " " + answer[1]);
    }
}
