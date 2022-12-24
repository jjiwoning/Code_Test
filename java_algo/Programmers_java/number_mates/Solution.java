package Programmers_java.number_mates;

/**
 * 프로그래머스 - 숫자 짝꿍
 */
public class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();

        int[] xArr = new int[10];
        int[] yArr = new int[10];

        countNumber(X, xArr);
        countNumber(Y, yArr);

        for (int i = xArr.length - 1; i >= 0; i--) {
            while (xArr[i] >= 1 && yArr[i] >= 1) {
                xArr[i]--;
                yArr[i]--;

                answer.append(i);
            }
        }

        return getAnswer(answer);
    }

    private String getAnswer(StringBuilder answer) {
        if (answer.toString().equals("")) {
            return "-1";
        } else if (answer.toString().startsWith("0")) {
            return "0";
        } else {
            return answer.toString();
        }
    }

    private void countNumber(String string, int[] array) {
        for (int i = 0; i < string.length(); i++) {
            int index = string.charAt(i) - '0';
            array[index]++;
        }
    }
}
