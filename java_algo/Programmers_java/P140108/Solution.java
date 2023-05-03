package Programmers_java.P140108;

public class Solution {
    public int solution(String s) {
        int answer = 0;
        char wantChar = s.charAt(0);
        int wantCharCount = 1;
        int notWantCharCount = 0;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (wantCharCount == 0) {
                wantChar = c;
                wantCharCount++;
                continue;
            }
            if (c == wantChar) {
                wantCharCount++;
            }
            if (c != wantChar) {
                notWantCharCount++;
            }
            if (wantCharCount == notWantCharCount) {
                answer++;
                wantCharCount = 0;
                notWantCharCount = 0;
            }
        }

        if (wantCharCount == 0) {
            return answer;
        }

        return answer + 1;
    }
}
