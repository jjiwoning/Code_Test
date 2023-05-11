package Programmers_java.P133502;

import java.util.Stack;

public class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int num : ingredient) {

            stack.add(num);

            while (stack.size() >= 4) {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                Integer pop3 = stack.pop();
                Integer pop4 = stack.pop();
                if (pop1 == 1 && pop2 == 3 && pop3 == 2 && pop4 == 1) {
                    answer++;
                    continue;
                }
                stack.add(pop4);
                stack.add(pop3);
                stack.add(pop2);
                stack.add(pop1);
                break;
            }
        }

        return answer;
    }
}
