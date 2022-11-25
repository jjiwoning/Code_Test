package Programmers_java.makemin;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Integer[] B1 = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(B1, Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B1[i];
        }

        return answer;
    }
}
