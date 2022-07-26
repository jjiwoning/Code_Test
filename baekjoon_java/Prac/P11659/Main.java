package baekjoon_java.Prac.P11659;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] sum = new int[N + 1];
        int now = 0;

        for (int i = 1; i < N + 1; i++) {
            now += arr[i - 1];
            sum[i] = now;
        }

        for (int i = 0; i < M; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            System.out.println(sum[second] - sum[first - 1]);
        }
    }

}
