package baekjoon_java.P15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int m;
    static boolean[] visited;
    static int[] answer;
    static int[] numbers;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        visited = new boolean[n];
        answer = new int[m];

        Arrays.sort(numbers);

        permutation(0);
    }

    private static void permutation(int depth) {
        if (depth == m) {
            Arrays.stream(answer).forEach(o1 -> System.out.print(o1 + " "));
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = numbers[i];
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}
