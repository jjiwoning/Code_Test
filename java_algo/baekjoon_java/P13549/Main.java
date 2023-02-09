package baekjoon_java.P13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int wanted;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        wanted = arr[1];
        visited = new boolean[100001];
        System.out.println(bfs(arr[0]));
    }

    private static int bfs(int start) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.add(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[now[0]] = true;
            if (now[0] == wanted) {
                return now[1];
            }
            if (now[0] * 2 <= 100000 && now[0] * 2 >= 0 && !visited[now[0] * 2]) {
                queue.add(new int[]{now[0] * 2, now[1]});
            }
            if (now[0] + 1 <= 100000 && now[0] + 1 >= 0 && !visited[now[0] + 1]) {
                queue.add(new int[]{now[0] + 1, now[1] + 1});
            }
            if (now[0] - 1 <= 100000 && now[0] - 1 >= 0 && !visited[now[0] - 1]) {
                queue.add(new int[]{now[0] - 1, now[1] + 1});
            }
        }
        return -1;
    }
}
