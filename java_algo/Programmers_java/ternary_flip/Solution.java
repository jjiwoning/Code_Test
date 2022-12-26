package Programmers_java.ternary_flip;

public class Solution {
    public int solution(int n) {
        String answer = "";
        while (n != 0) {
            answer += n % 3;
            n /= 3;
        }
        return Integer.parseInt(answer, 3);
    }
}
