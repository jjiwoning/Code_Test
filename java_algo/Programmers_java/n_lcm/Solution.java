package Programmers_java.n_lcm;

/**
 * 프로그래머스 - N개의 최소공배수
 */
public class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        if (arr.length == 1) {
            return arr[0];
        }

        int findGcd = gcd(arr[0], arr[1]);
        answer = (arr[0] * arr[1]) / findGcd;

        if (arr.length > 2) {
            for(int i = 2; i < arr.length; i++) {
                findGcd = gcd(answer, arr[i]);
                answer = (answer * arr[i]) / findGcd;
            }
        }

        return answer;
    }

    private static int gcd(int first, int second) {
        int temp = first % second;
        if (temp == 0) {
            return second;
        }
        return gcd(second, temp);
    }
}
