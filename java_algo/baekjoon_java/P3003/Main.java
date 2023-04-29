package baekjoon_java.P3003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] need = {1, 1, 2, 2, 2, 8};
        int[] arr = Arrays.stream(new BufferedReader(new InputStreamReader(System.in))
                .readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < need.length; i++) {
            System.out.print((need[i] - arr[i]) + " ");
        }
    }
}
