 package Programmers_java.P152995;

import java.util.Arrays;

/**
 * 프로그래머스 - 인사고과
 */
public class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int[] wanho = scores[0];
        int wanhoSum = wanho[0] + wanho[1];

        Arrays.sort(scores, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o2[0], o1[0]);
        }));

        int value = 0;

        for (int[] score : scores) {
            if (score[1] < value) {
                if (score.equals(wanho)) {
                    return -1;
                }
            } else {
                int sum = score[0] + score[1];
                if (sum > wanhoSum) {
                    answer++;
                }
                value = Math.max(value, score[1]);
            }
        }

        return ++answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new int[][]{{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}});
    }
}
