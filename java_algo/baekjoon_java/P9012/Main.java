package baekjoon_java.P9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String target = br.readLine();
            sb.append(isGoodParenthesis(target));
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static String isGoodParenthesis(String target) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (c == '(') {
                stack.add(c);
            }
            if (c == ')') {
                if (stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return "YES";
        }

        return "NO";
    }
}
