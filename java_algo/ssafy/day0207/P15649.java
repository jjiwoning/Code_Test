package ssafy.day0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P15649 {

    static int n;
    static int m;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        visited = new boolean[n + 1];
        answer = new int[m];

        permutation(0);
    }

    private static void permutation(int depth) {
        if (depth == m) {
            Arrays.stream(answer).forEach(o1 -> System.out.print(o1 + " "));
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = i;
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}
