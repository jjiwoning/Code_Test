package baekjoon_java.P2493;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Stack<int[]> stack = new Stack<>();

        for (int i = 1; i <= n; i++) {
            int now = sc.nextInt();

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
