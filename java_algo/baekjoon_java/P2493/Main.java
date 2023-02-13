package baekjoon_java.P2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();

        String[] s = br.readLine().split(" ");

        for (int i = 1; i <= n; i++) {
            int now = Integer.parseInt(s[i - 1]);

            while (!stack.isEmpty()) {
                if (stack.peek()[0] >= now) {
                    System.out.print(stack.peek()[1] + " ");
                    break;
                }
                stack.pop();
            }

            if (stack.isEmpty()) {
                System.out.print(0 + " ");
            }
            stack.add(new int[]{now, i});
        }
    }
}
