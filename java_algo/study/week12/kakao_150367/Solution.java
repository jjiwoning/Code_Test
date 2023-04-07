package study.week12.kakao_150367;

/**
 * 카카오 기출 - 표현 가능한 이진트리
 */
public class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            StringBuilder binaryString = new StringBuilder(Long.toBinaryString(numbers[i]));
            int depth = getLog2(binaryString.length());

            while (binaryString.length() != Math.pow(2, depth + 1) - 1) {
                binaryString.insert(0, "0");
            }

            if (checkBinaryString(binaryString.toString(), depth, binaryString.length() / 2)) {
                answer[i] = 1;
                continue;
            }
            answer[i] = 0;
        }

        return answer;
    }

    private boolean checkBinaryString(String bString, int depth, int checkIndex) {
        if (depth == 0) {
            return true;
        }

        int nextDept = (int) Math.pow(2, depth - 1);

        if (bString.charAt(checkIndex) == '0' && ((bString.charAt(checkIndex - nextDept) == '1') || (bString.charAt(checkIndex + nextDept) == '1'))) {
            return false;
        }

        boolean check1 = checkBinaryString(bString, depth - 1, checkIndex + nextDept);
        boolean check2 = checkBinaryString(bString, depth - 1, checkIndex - nextDept);

        return check1 && check2;
    }

    private int getLog2(int length) {
        return (int) (Math.log(length) / Math.log(2));
    }

}
