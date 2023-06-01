package Programmers_java.P135807;

public class Solution {

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int aGcd = arrayA[0];
        int bGcd = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            aGcd = getGcd(aGcd, arrayA[i]);
            bGcd = getGcd(bGcd, arrayB[i]);
        }

        if (canNotDivision(arrayB, aGcd)) {
            answer = Math.max(answer, aGcd);
        }

        if (canNotDivision(arrayA, bGcd)) {
            answer = Math.max(answer, bGcd);
        }

        return answer;
    }

    // 유클리드 호제법
    public int getGcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGcd(num2, num1 % num2);
    }

    public boolean canNotDivision(int[] arr, int divNum) {
        for (int num : arr) {
            if (num % divNum == 0) {
                return false;
            }
        }
        return true;
    }
}
