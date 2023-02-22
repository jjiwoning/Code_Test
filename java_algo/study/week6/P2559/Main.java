package study.week6.P2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int len = Integer.parseInt(input1[1]);

        int findSum = 0;

        for (int i = 0; i < len; i++) {
            findSum += arr[i];
        }

        int answer = findSum;

        for (int i = len; i < arr.length; i++) {
            findSum -= arr[i - len];
            findSum += arr[i];
            answer = Math.max(findSum, answer);
        }

        System.out.println(answer);
    }
}
