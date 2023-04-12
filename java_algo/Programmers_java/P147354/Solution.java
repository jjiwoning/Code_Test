package Programmers_java.P147354;

import java.util.Arrays;

public class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] > o2[col - 1]) {
                return 1;
            }
            if (o1[col - 1] == o2[col - 1]) {
                return o2[0] - o1[0];
            }
            return -1;
        });

        for (int i = row_begin; i <= row_end; i++) {
            int find = 0;
            for (int num : data[i - 1]) {
                find += num % i;
            }
            if (answer == 0) {
                answer = find;
                continue;
            }
            answer ^= find;
        }

        return answer;
    }
}
