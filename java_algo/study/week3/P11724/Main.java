package study.week3.P11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static boolean[] visited;
    static List<List<Integer>> lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        visited = new boolean[n + 1];
        lists = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int n1 = Integer.parseInt(s1[0]);
            int n2 = Integer.parseInt(s1[1]);
            lists.get(n1).add(n2);
            lists.get(n2).add(n1);
        }

        int answer = 0;

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int n) {
        if (!visited[n]) {
            visited[n] = true;
            for (Integer integer : lists.get(n)) {
                dfs(integer);
            }
        }
    }
}
