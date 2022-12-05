package Programmers_java.eatground;

/**
 * 프로그래머스 - 땅 따먹기
 */
public class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[1].length; j++) {
                int maxValue = 0;
                for (int k = 0; k < land[1].length; k++) {
                    if (k == j) {
                        continue;
                    }
                    maxValue = Math.max(land[i - 1][k], maxValue);
                }
                land[i][j] += maxValue;
            }
        }

        for (int i = 0; i < land[1].length; i++) {
            answer = Math.max(land[land.length - 1][i], answer);
        }

        return answer;
    }
}
