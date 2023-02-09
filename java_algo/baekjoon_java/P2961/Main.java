package baekjoon_java.P2961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Math.*;

public class Main {

    static int n;
    static long[][] foods;
    static boolean[] visited;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        foods = new long[n][2];
        visited = new boolean[n];
        answer = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            foods[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        }

        combination(0);

        System.out.println(answer);
    }

    private static void combination(int now) {
        if (now == n) {
            findTaste();
        }

        for (int i = now; i < n; i++) {
            visited[i] = true;
            combination(i + 1);
            visited[i] = false;
            combination(i + 1);
        }
    }

    private static void findTaste() {

        long sourTotal = 1;
        long bitterTotal = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sourTotal *= foods[i][0];
                bitterTotal += foods[i][1];
                continue;
            }
            count++;
        }

        if (count != n) {
            answer = min(answer, abs(sourTotal - bitterTotal));
        }
    }
}
