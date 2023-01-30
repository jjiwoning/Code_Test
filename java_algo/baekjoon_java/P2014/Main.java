package baekjoon_java.P2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int wantedIndex = Integer.parseInt(s1[1]);

        int[] arr = new int[n];
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(s2[i]);
            arr[i] = num;
            set.add((long) num);
        }

        long answer = 0;

        for (int i = 0; i < wantedIndex; i++) {
            answer = set.pollFirst();

            for (int j = 0; j < n; j++) {
                long find = answer * arr[j];
                if (find > Integer.MAX_VALUE) {
                    break;
                }
                set.add(find);
                if (answer % arr[j] == 0) {
                    break;
                }
            }
        }

        System.out.println(answer);

    }
}
