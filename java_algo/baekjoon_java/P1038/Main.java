package baekjoon_java.P1038;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Long> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n <= 10) {
            System.out.println(n);
            System.exit(0);
        }

        list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            dfs(1, i);
        }
        Collections.sort(list);

        if (list.size() <= n) {
            System.out.println(-1);
            System.exit(0);
        }

        System.out.println(list.get(n));
    }

    private static void dfs(int level, long num) {
        if (level > 10) {
            return;
        }
        list.add(num);

        for (int i = 0; i < num % 10; i++) {
            dfs(level + 1, 10 * num + i);
        }
    }

}
