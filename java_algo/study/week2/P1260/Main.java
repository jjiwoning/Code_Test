package study.week2.P1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] checked;
    static int n;
    static List<List<Integer>> lists;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int start = Integer.parseInt(s[2]);

        lists = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            lists.get(Integer.parseInt(s1[0])).add(Integer.parseInt(s1[1]));
            lists.get(Integer.parseInt(s1[1])).add(Integer.parseInt(s1[0]));
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(lists.get(i));
        }

        checked = new boolean[n + 1];
        answer = new ArrayList<>();
        dfs(start);
        answer.forEach(o1 -> System.out.print(o1 + " "));
        System.out.println();

        checked = new boolean[n + 1];
        answer = new ArrayList<>();
        bfs(start);
        answer.forEach(o1 -> System.out.print(o1 + " "));
    }

    private static void dfs(int start) {
        checked[start] = true;
        answer.add(start);
        for (int i = 0; i < lists.get(start).size(); i++) {
            if (!checked[lists.get(start).get(i)]) {
                dfs(lists.get(start).get(i));
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        checked[start] = true;

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            answer.add(now);

            for (int i = 0; i < lists.get(now).size(); i++) {
                if (!checked[lists.get(now).get(i)]) {
                    checked[lists.get(now).get(i)] = true;
                    queue.add(lists.get(now).get(i));
                }
            }
        }
    }
}
