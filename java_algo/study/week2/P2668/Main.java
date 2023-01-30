package study.week2.P2668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static Set<Integer> set;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        set = new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            dfs(i, i);
        }

        System.out.println(set.size());
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }

    private static void dfs(int now, int wanted) {
        if (!visited[arr[now]]) {
            visited[arr[now]] = true;
            dfs(arr[now], wanted);
            visited[arr[now]] = false;
        }

        if (arr[now] == wanted) {
            set.add(wanted);
        }
    }
}
