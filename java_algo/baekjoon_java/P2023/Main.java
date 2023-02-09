package baekjoon_java.P2023;

import java.util.Scanner;

import static java.lang.Math.*;

public class Main {

    static int[] primeNumberArray = new int[]{1, 2, 3, 5, 7, 9};
    static int depth;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        depth = sc.nextInt();
        dfs(0, 0);
    }

    private static void dfs(int index, int value) {
        if (index == depth) {
            if (isPrimeNumber(value)) {
                System.out.println(value);
            }
            return;
        }
        for (int i = 0; i < 6; i++) {
            int newValue = value * 10 + primeNumberArray[i];
            if (isPrimeNumber(newValue)) {
                dfs(index + 1, newValue);
            }
        }
    }

    private static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= (int) sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
