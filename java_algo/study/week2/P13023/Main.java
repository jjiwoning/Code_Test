package study.week2.P13023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static boolean[] checked;
    static List<Integer>[] friends;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        friends = new ArrayList[n]; // 배열 말고 인접 리스트를 만들어서 풀어주기

        for (int i = 0; i < n; i++) {
            friends[i] = new ArrayList<>(); // 내부 배열 List 초기화
        }

        answer = 0;

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            friends[a].add(b);
            friends[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            checked = new boolean[n];
            checked[i] = true;
            dfs(0, i);
            if (answer == 1) {
                break;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int level, int start) {
        if (level == 4) {
            answer = 1;
            return;
        }

        for (Integer val : friends[start]) {
            if (!checked[val]) {
                checked[val] = true;
                dfs(level + 1, val);
                checked[val] = false;
            }
        }

    }
}
