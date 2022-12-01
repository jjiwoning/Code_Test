package Programmers_java.sell_fruit;

import java.util.Arrays;

/**
 * 프로그래머스 - 과일장수
 */
public class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int[] arr = new int[k];

        for (int i : score) {
            arr[i - 1]++;
        }

        int totalBox = score.length / m;

        for (int i = 0; i < totalBox; i++) {
            int count = m;
            int price = 0;
            for (int j = k - 1; j > -1; j--) {
                if (count - arr[j] <= 0) {
                    arr[j] -= count;
                    price = (j + 1) * m;
                    answer += price;
                    break;
                } else {
                    count -= arr[j];
                    arr[j] = 0;
                }
            }
        }

        return answer;
    }

    public int solution2(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        for(int i = score.length; i >= m; i -= m){
            answer += score[i - m] * m;
        }

        return answer;
    }
}
