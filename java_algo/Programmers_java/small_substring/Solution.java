package Programmers_java.small_substring;

public class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pLen = p.length();
        long pLong = Long.parseLong(p);
        for (int i = 0; i < t.length() - pLen + 1; i++) {
            String findString = t.substring(i, i + pLen);
            long findLong = Long.parseLong(findString);
            if (findLong <= pLong) {
                answer++;
            }
        }
        return answer;
    }
}
