package Programmers_java.P155652;

public class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        String target = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < skip.length(); i++) {
            target = target.replace(skip.charAt(i) + "", "");
        }

        for (int i = 0; i < s.length(); i++) {

            int findIndex = target.indexOf(s.charAt(i)) + index;

            while (findIndex >= target.length()) {
                findIndex -= target.length();
            }

            answer.append(target.charAt(findIndex));
        }

        return answer.toString();
    }
}
