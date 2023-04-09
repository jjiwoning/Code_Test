package Programmers_java.P12904;

public class Solution {
    public int solution(String s) {

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < s.length() - i; j++) {
                if (isPalindrome(s, j, j + i)) {
                    return i + 1;
                }
            }
        }
        return 1;
    }

    private boolean isPalindrome(String s, int startIndex, int endIndex) {

        while (startIndex < endIndex) {
            if (s.charAt(startIndex++) != s.charAt(endIndex--)) {
                return false;
            }
        }

        return true;
    }
}
