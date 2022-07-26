package baekjoon_java.Prac.P1546;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        long sum = 0;
        long max = 0;

        for (long l : arr) {
            if (max <= l){max = l;}
            sum += l;
        }

        double avg = (sum * 100.0)/max/N; // double로 형 맞춰줘야 된다. -> 100.0 형식으로

        System.out.println(avg);

    }

}
