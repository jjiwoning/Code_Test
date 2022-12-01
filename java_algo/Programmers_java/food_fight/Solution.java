package Programmers_java.food_fight;

/**
 * 프로그래머스 - 푸드 파이트 대회
 */
public class Solution {
    public String solution(int[] food) {
        String answer = "";
        for (int i = 1; i < food.length; i++) {
            food[i] /= 2;
            for (int j = 0; j < food[i]; j++) {
                answer += i;
            }
        }
        StringBuffer sb = new StringBuffer(answer);
        String reverse = sb.reverse().toString();
        answer += "0";
        answer += reverse;

        return answer;
    }
}
