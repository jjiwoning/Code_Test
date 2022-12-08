package Programmers_java.bit2diff;

/**
 * 프로그래머스 - 2개 이하로 다른 비트
 */
public class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                String binaryString = Long.toBinaryString(numbers[i]);
                int findZeroIndex = binaryString.length();
                for (int index = binaryString.length() - 1; index >= 0; index--) {
                    char c = binaryString.charAt(index);
                    if (c == '0') {
                        findZeroIndex = binaryString.length() - index;
                        break;
                    }
                }
                long findNumber = (long) (numbers[i] + Math.pow(2, findZeroIndex) - Math.pow(2, findZeroIndex - 1));
                answer[i] = findNumber;
            }
        }
        return answer;
    }
}
