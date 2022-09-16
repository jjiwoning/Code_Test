package baekjoon_java.programmers.sum_no_number;

public class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        for (int number : numbers) {
            answer -= number;
        }
        return answer;
    }
}
