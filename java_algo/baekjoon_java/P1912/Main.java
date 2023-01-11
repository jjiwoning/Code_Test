package baekjoon_java.P1912;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            arr[i] = Math.max(arr[i - 1] + arr[i], arr[i]);
        }

        int answer = Arrays.stream(arr).max().getAsInt();

        System.out.println(answer);
    }
}
