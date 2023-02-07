package ssafy.day0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Permu {
    static int n;
    static int r;
    static int arr[];
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        r = Integer.parseInt(s[1]);

        arr = new int[n];
        visited = new boolean[n];
        answer = new int[r];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        permutation(0);
    }

    private static void permutation(int depth) {
        if (depth == r) {
            Arrays.stream(answer).forEach(o1 -> System.out.print(o1 + " "));
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = arr[i];
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}
