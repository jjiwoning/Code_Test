package Programmers_java.vowel_dictionary;

import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 - 모음 사전
 */
public class Solution {
    public int solution(String word) {
        int answer = 0;
        // 맨 앞부터 알파벳이 바뀔때마다 781, 156, 31, 6, 1 씩 사전 순서가 더해진다.
        int[] sumNumbers = new int[]{781, 156, 31, 6, 1};
        Map<Character, Integer> vowelMap = new HashMap<>();
        // 각 알파벳의 순서에 따라 값 넣어주기
        vowelMap.put('A', 0);
        vowelMap.put('E', 1);
        vowelMap.put('I', 2);
        vowelMap.put('O', 3);
        vowelMap.put('U', 4);

        for (int i = 0; i < word.length(); i++) {
            answer++;
            answer += sumNumbers[i] * vowelMap.get(word.charAt(i));
        }

        return answer;
    }
}
