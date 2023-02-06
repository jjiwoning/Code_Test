package baekjoon_java.P11729;

import java.util.Scanner;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println((int)Math.pow(2, n) - 1);
        sb = new StringBuilder();
        hanoi(n, 1, 3, 2);

        System.out.println(sb);
    }

    private static void hanoi(int num, int start, int end, int to) {
        if (num == 0) {
            return;
        }
        hanoi(num - 1, start, to, end);
        sb.append(start).append(" ").append(end).append("\n");
        hanoi(num - 1, to, end, start);
    }
}
