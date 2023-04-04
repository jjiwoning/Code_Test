package baekjoon_java.P18917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        long sum = 0;
        long xorValue = 0;

        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");

            if (command[0].equals("1")) {
                sum += Integer.parseInt(command[1]);
                xorValue ^= Integer.parseInt(command[1]);
            }

            if (command[0].equals("2")) {
                sum -= Integer.parseInt(command[1]);
                xorValue ^= Integer.parseInt(command[1]);
            }

            if (command[0].equals("3")) {
                answer.append(sum).append("\n");
            }

            if (command[0].equals("4")) {
                answer.append(xorValue).append("\n");
            }
        }

        System.out.println(answer);
    }
}
