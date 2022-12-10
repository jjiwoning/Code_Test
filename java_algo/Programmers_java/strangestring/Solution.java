package Programmers_java.strangestring;

/**
 * 프로그래머스 - 이상한 문자 만들기
 */
public class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strings = s.split(" ");
        for (String string : strings) {
            String change = "";
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                String find = c + "";
                if ((i + 1) % 2 == 1) {
                    String upperString = find.toUpperCase();
                    change += upperString;
                } else {
                    String lowerString = find.toLowerCase();
                    change += lowerString;
                }
            }
            answer += (change + " ");
        }
        return answer.substring(0, answer.length() - 1);
    }
}
