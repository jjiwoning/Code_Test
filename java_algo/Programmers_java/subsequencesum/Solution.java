package Programmers_java.subsequencesum;

import java.util.HashSet;
import java.util.Set;

/**
 * 프로그래머스 - 연속 부분 수열 합의 개수
 */
public class Solution {
    public int solution(int[] elements) {
        Set<Integer> sumSet = new HashSet<>();

        for (int i = 1; i <= elements.length; i++) {
            int sum = 0;
            // 초기값 세팅
            for (int j = 0; j < i; j++) {
                sum += elements[j]; // i 개의 부분 합의 시작지점
            }
            sumSet.add(sum); // 시작지점 Set에 넣어주기

            for (int j = 0; j < elements.length; j++) {
                // 지금부터는 length 범위를 넘어가기 때문에 나머지 연산으로 인덱스를 맞춰줘야 함 -> 원형 수열
                sum -= elements[j % elements.length]; // 현재 위치에서 맨 앞의 값 빼기
                sum += elements[(j + i) % elements.length]; // 현재 맨 앞 위치에서 i 개 뒤에 있는 값 더해주기
                sumSet.add(sum);
            }
        }
        return sumSet.size();
    }
}
