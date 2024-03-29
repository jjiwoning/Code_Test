package Programmers_java.numbergame;

import java.util.Arrays;

public class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int bIndex = B.length - 1;

        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] < B[bIndex]) {
                answer++;
                bIndex--;
            }
        }

        return answer;
    }
}
