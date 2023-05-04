package Programmers_java.P131704;

import java.util.Stack;

public class Solution {
    public int solution(int[] order) {

        Stack<Integer> stack = new Stack<>();

        int answer = 0;
        int index = 0;
        int nowBox = 1;

        while (index < order.length) {
            if (order[index] > nowBox) {
                for (int i = nowBox; i < order[index]; i++) {
                    stack.push(i);
                }
                nowBox = order[index] + 1;
                index++;
                answer++;
                continue;
            }

            if (order[index] == nowBox) {
                answer++;
                index++;
                nowBox++;
                continue;
            }

            if (order[index] < nowBox) {
                if (stack.peek() == order[index]) {
                    stack.pop();
                    index++;
                    answer++;
                    continue;
                }
                break;
            }
        }
        return answer;
    }
}
