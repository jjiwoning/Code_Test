package Programmers_java.immigration;

import java.util.Arrays;

/**
 * 프로그래머스 - 입국심사
 */
public class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start = 0;
        long end = (long) times[times.length - 1] * n;

        while (start <= end) {
            long mid = (start + end) / 2;
            long pass = 0;
            for (int i = 0; i < times.length; i++) {
                pass += mid / times[i];
                if (pass >= n) {
                    break;
                }
            }
            if (pass < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = Math.min(answer, mid);
            }

        }
        return answer;
    }
}
