package Programmers_java.P181188;

import java.util.Arrays;

import static java.util.Comparator.*;

public class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int nowEnd = 0; // 현재 끝 지점

        Arrays.sort(targets, comparingInt(o -> o[1])); // 끝 점 기준으로 정렬

        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];

            if (start < nowEnd) {
                // 요격할 필요 없음 -> 겹침
                continue;
            }

            nowEnd = end;
            answer++;
        }

        return answer;
    }
}
