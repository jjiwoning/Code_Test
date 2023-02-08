package baekjoon_java.P15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int m;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        answer = new int[m];

        combination(0, 1);
    }

    private static void combination(int depth, int start) {
        if (depth == m) {
            Arrays.stream(answer).forEach(o1 -> System.out.print(o1 + " "));
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            answer[depth] = i;
            combination(depth + 1, i + 1);
        }
    }
}
