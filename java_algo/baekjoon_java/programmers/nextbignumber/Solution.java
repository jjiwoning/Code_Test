package baekjoon_java.programmers.nextbignumber;

public class Solution {
    public int solution(int n) {
        int answer = n;
        int count = Integer.bitCount(n);
        while (true) {
            answer++;
            int findCount = Integer.bitCount(answer);
            if (findCount == count) {
                break;
            }
        }
        return answer;
    }
}
