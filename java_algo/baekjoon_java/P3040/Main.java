package baekjoon_java.P3040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final int DWARF_COUNT = 9;
    static boolean[] visited;
    static int[] dwarfs;
    static int[] answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dwarfs = new int[DWARF_COUNT];
        visited = new boolean[DWARF_COUNT];
        answer = new int[DWARF_COUNT - 2];

        for (int i = 0; i < DWARF_COUNT; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0);
    }

    private static void dfs(int nowIndex, int count) {
        if (count == 7) {
            if (Arrays.stream(answer).sum() == 100) {
                Arrays.stream(answer).forEach(System.out::println);
            }
            return;
        }

        for (int i = nowIndex; i < DWARF_COUNT; i++) {
            answer[count] = dwarfs[i];
            dfs(i + 1, count + 1);
        }
    }
}
