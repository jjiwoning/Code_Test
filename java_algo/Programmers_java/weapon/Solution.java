package Programmers_java.weapon;

import java.util.Arrays;

/**
 * 프로그래머스 - 기사단원의 무기
 */
public class Solution {
    public int solution(int number, int limit, int power) {
        int[] arr = new int[number];

        for (int i = 1; i <= number; i++) {
            int findNum = countDivisors(i);
            if (findNum > limit) {
                findNum = power;
            }
            arr[i - 1] = findNum;
        }

        int answer = Arrays.stream(arr).sum();

        return answer;
    }

    static int countDivisors(int n) {
        int cnt = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    cnt++;
                } else {
                    cnt = cnt + 2;
                }
            }
        }
        return cnt;
    }
}
