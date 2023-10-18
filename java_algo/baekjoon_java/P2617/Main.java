package baekjoon_java.P2617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static boolean[] visited;
    private static int count;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int e = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(e);

            if (!map2.containsKey(e)) {
                map2.put(e, new ArrayList<>());
            }
            map2.get(e).add(s);
        }

        int mid = (n + 1) / 2;

        for (int i = 1; i < n + 1; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            count = 0;
            dfs(i, map);
            if (count >= mid) {
                answer++;
                continue;
            }
            count = 0;
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, map2);
            if (count >= mid) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int num, Map<Integer, List<Integer>> map) {
        if (!map.containsKey(num)) {
            return;
        }
        List<Integer> list = map.get(num);

        for (Integer next : list) {
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            count++;
            dfs(next, map);
        }
    }
}
