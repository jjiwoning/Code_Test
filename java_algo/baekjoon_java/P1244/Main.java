package baekjoon_java.P1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static boolean[] switches;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");
        switches = new boolean[n];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(s[i]);
            if (num == 1) {
                switches[i] = true;
            }
            if (num == 0) {
                switches[i] = false;
            }
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            int[] person = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (person[0] == 1) {
                man(person[1]);
            }
            if (person[0] == 2) {
                woman(person[1] - 1);
            }
        }

        for (int i = 0; i < n; i++) {

            if (switches[i]) {
                System.out.print("1 ");
            }
            if (!switches[i]) {
                System.out.print("0 ");
            }

            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }

    private static void man(int index) {
        int startIndex = index - 1;
        while (startIndex < n) {
            switches[startIndex] = !switches[startIndex];
            startIndex += index;
        }
    }

    private static void woman(int index) {
        int move = 0;
        while (true) {
            move++;
            if (index - move < 0 || index + move > n - 1) {
                break;
            }
            if (switches[index - move] != switches[index + move]) {
                break;
            }
        }

        switches[index] = !switches[index];

        for (int i = 1; i < move; i++) {
            switches[index + i] = !switches[index + i];
            switches[index - i] = !switches[index - i];
        }
    }
}
