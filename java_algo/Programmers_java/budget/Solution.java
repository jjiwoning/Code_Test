package Programmers_java.budget;

import java.util.Arrays;

public class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int money : d) {
            if (budget < money) {
                break;
            }
            budget -= money;
            answer++;
        }
        return answer;
    }
}
