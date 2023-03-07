package Programmers_java.P161989;

/**
 * 프로그래머스 - 덧칠하기
 */
public class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int start = section[0] - 1;
        for (int i = 1; i < section.length; i++) {
            if (start + m > section[i]) {
                continue;
            }
            if (start + m <= section[i]) {
                answer++;
                start = section[i] - 1;
            }
        }
        return answer;
    }
}
