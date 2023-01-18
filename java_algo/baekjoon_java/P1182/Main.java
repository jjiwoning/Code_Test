package baekjoon_java.P1182;

import java.util.Scanner;

public class Main {

    static int answer;
    static int wanted;
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        wanted = sc.nextInt();
        arr = new int[n];
        answer = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(0, 0);

        if (wanted == 0) {
            answer--;
        }

        System.out.println(answer);
    }

    private static void dfs(int sum, int level) {
        if (level == n && sum == wanted) {
            answer++;
            return;
        }

        if (level == n) {
            return;
        }

        dfs(sum + arr[level], level + 1);
        dfs(sum, level + 1);
    }
}
