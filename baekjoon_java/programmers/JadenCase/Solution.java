package baekjoon_java.programmers.JadenCase;

public class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isSpace = true;

        String[] strings = s.toLowerCase().split("");
        for (String string : strings) {
            sb.append(isSpace ? string.toUpperCase() : string);
            isSpace = string.equals(" ");
        }
        return sb.toString();
    }
}
