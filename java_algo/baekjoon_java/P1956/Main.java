package baekjoon_java.P1956;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_COST = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] map = new int[v + 1][v + 1];

        for (int i = 0; i < v + 1; i++) {
            Arrays.fill(map[i], MAX_COST);
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[start][end] = cost;
        }

        for (int mid = 1; mid < v + 1; mid++) {
            for (int start = 1; start < v + 1; start++) {
                for (int end = 1; end < v + 1; end++) {
                    map[start][end] = Math.min(map[start][end], map[start][mid] + map[mid][end]);
                }
            }
        }

        int answer = MAX_COST;

        for (int i = 1; i < v + 1; i++) {
            answer = Math.min(answer, map[i][i]);
        }

        if (answer == MAX_COST) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }
}
