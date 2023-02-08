package baekjoon_java.P11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] arr = new int[n + 1];
        String[] numString = br.readLine().split(" ");

        for (int i = 1; i < n + 1; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(numString[i - 1]);
        }

        for (int i = 0; i < m; i++) {
            findAnswer(br, arr);
        }
    }

    private static void findAnswer(BufferedReader br, int[] arr) throws IOException {
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        System.out.println(arr[end] - arr[start - 1]);
    }
}
