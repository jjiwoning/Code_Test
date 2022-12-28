package Programmers_java.length_of_overlapping_segments;

/**
 * 프로그래머스 - 겹치는 선분의 길이
 */
public class Solution {
    public int solution(int[][] lines) {
        int[] arr = new int[201];
        int answer = 0;
        for (int[] line : lines) {
            int start = line[0] + 100;
            int end = line[1] + 100;
            while (start < end) {
                if (++arr[start++] == 2) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
