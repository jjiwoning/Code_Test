package Programmers_java.kakao_convertbrackets;

public class Solution {
    public String solution(String p) {
        if (checkBracket(p)) {
            return p;
        }

        return convert(p);
    }

    private String convert(String bracket) {

        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        if (bracket.length() == 0) {
            return "";
        }

        int start = 0;
        for (int i = 0; i < bracket.length(); i++) {
            if (bracket.charAt(i) == '(') {
                start++;
            } else {
                start--;
            }

            if (start == 0) {
                u.append(bracket.substring(0, i + 1));
                v.append(bracket.substring(i + 1, bracket.length()));

                if (checkBracket(u.toString())) {
                    u.append(convert(v.toString()));
                } else {
                    String sb = "(" +
                            convert(v.toString()) +
                            ")" +
                            reverse(u.toString());
                    return sb;
                }
                break;
            }
        }

        return u.toString();
    }

    private String reverse(String bracket) {
        StringBuilder s = new StringBuilder();

        for(int i = 1; i<bracket.length()-1;i++){
            if (bracket.charAt(i) == '(') {
                s.append(")");
            } else {
                s.append("(");
            }
        }
        return s.toString();
    }

    private boolean checkBracket(String bracket) {
        int start = 0;
        if (bracket.charAt(0) == ')') {
            return false;
        }

        for (int i = 0; i < bracket.length(); i++) {
            if (bracket.charAt(i) == '(') {
                start++;
                continue;
            }
            if (bracket.charAt(i) == ')') {
                start--;
                if (start < 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
