package baekjoon_java.P2577;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int result = mul(a, b, c);

        int[] answer = countNumber(result);

        for (int i : answer) {
            System.out.println(i);
        }
    }

    static int mul(int a, int b, int c) {
        return a * b * c;
    }

    static int[] countNumber(int number) {
        int[] answer = new int[10];
        while (number > 0) {
            answer[number % 10]++;
            number /= 10;
        }
        return answer;
    }
}
