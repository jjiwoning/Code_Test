package baekjoon_java.P2879;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int answer = 0;

        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s1[i]) - Integer.parseInt(s2[i]);
        }

        int temp = arr[0];

        for (int i = 1; i < n; i++) {
            if (temp * arr[i] < 0) {
                answer += abs(temp);
                temp = arr[i];
                continue;
            }
            if (abs(temp) >= abs(arr[i])) {
                answer += (abs(temp) - abs(arr[i]));
            }
            temp = arr[i];
        }

        answer += abs(temp);

        System.out.println(answer);
    }
}
