package baekjoon_java.P9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] people;
    static boolean[] visited;
    static boolean[] finished;
    static int cycleCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < t; testCase++) {
            n = Integer.parseInt(br.readLine());

            people = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i < n + 1; i++) {
                people[i] = Integer.parseInt(st.nextToken());
//                if (i == people[i]) {
//                    finished[i] = true;
//                }
            }

            cycleCount = 0;

            for (int i = 1; i < n + 1; i++) {
                if (!finished[i]) {
                    dfs(i);
                }
            }

            System.out.println(n - cycleCount);
        }
    }

    private static void dfs(int now) {
        if (finished[now]) {
            return;
        }
        if (visited[now]) {
            cycleCount++;
            finished[now] = true;
        }
        visited[now] = true;
        dfs(people[now]);
        finished[now] = true;
        visited[now] = false;
    }
}
