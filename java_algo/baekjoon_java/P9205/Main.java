package baekjoon_java.P9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.*;

public class Main {

    static int n;
    static int[][] mapInfo;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            n = Integer.parseInt(br.readLine());
            int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            mapInfo = new int[n][2];
            visited = new boolean[n];

            for (int j = 0; j < n; j++) {
                mapInfo[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int[] end = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println(bfs(start, end));
        }
    }

    private static String bfs(int[] startInfo, int[] endInfo) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(startInfo);

        while (!queue.isEmpty()) {
            int[] nowInfo = queue.poll();

            if (abs(nowInfo[0] - endInfo[0]) + abs(nowInfo[1] - endInfo[1]) <= 1000) {
                return "happy";
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int x = mapInfo[i][0];
                    int y = mapInfo[i][1];

                    if (abs(nowInfo[0] - x) + abs(nowInfo[1] - y) <= 1000) {
                        visited[i] = true;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }

        return "sad";
    }
}
