package Programmers_java.caesar_cipher;

public class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer.append(s.charAt(i));
                continue;
            }
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                if (s.charAt(i) + n > 'z') {
                    answer.append((char) (s.charAt(i) - 26 + n));
                } else {
                    answer.append((char) (s.charAt(i) + n));
                }
                continue;
            }
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                if (s.charAt(i) + n > 'Z') {
                    answer.append((char) (s.charAt(i) - 26 + n));
                } else {
                    answer.append((char) (s.charAt(i) + n));
                }
            }
        }
        return answer.toString();
    }
}
