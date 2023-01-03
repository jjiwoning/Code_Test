package Programmers_java.remove_pairs;

import java.util.Stack;

/**
 * 프로그래머스 - 짝지어 제거하기
 */
public class Solution {
    public int solution(String s) {

        if (s.length() % 2 == 1) {
            return 0;
        }

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek().equals(s.charAt(i) + "")) {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i) + "");
        }

        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
}
