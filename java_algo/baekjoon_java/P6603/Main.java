package baekjoon_java.P6603;

import java.util.Scanner;

public class Main {

    static int n;
    static int[] lotto;
    static boolean[] checked;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            n = sc.nextInt();

            if (n == 0) {
                break;
            }

            lotto = new int[n];
            checked = new boolean[n];

            for (int i = 0; i < n; i++) {
                lotto[i] = sc.nextInt();
            }

            dfs(0,0);
            System.out.println();
        }
    }

    private static void dfs(int index, int level) {
        if (level == 6) {
            printArr();
            return;
        }

        if (index == n) {
            return;
        }

        checked[index] = true;
        dfs(index + 1, level + 1);
        checked[index] = false;
        dfs(index + 1, level);
    }

    private static void printArr() {
        for (int i = 0; i < n; i++) {
            if (checked[i]) {
                System.out.print(lotto[i] + " ");
            }
        }
        System.out.println();
    }
}
