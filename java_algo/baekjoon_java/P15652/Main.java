package baekjoon_java.P15652;

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
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];
        answer = new int[m];

        combination(0, 1);
    }

    private static void combination(int count, int index) {
        if (count == m) {
            Arrays.stream(answer).forEach(o1 -> System.out.print(o1 + " "));
            System.out.println();
            return;
        }
        for (int i = index; i <= n; i++) {
            answer[count] = i;
            combination(count + 1, i);
        }
    }
}
