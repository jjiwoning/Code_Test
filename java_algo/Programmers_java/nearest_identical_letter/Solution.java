package Programmers_java.nearest_identical_letter;

import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 - 가장 가까운 같은 글자
 */
public class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<String, Integer> stringMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stringMap.containsKey(s.charAt(i) + "")) {
                stringMap.put(s.charAt(i) + "", i);
                answer[i] = -1;
            } else {
                Integer index = stringMap.get(s.charAt(i) + "");
                answer[i] = i - index;
                stringMap.put(s.charAt(i) + "", i);
            }
        }

        return answer;
    }
}
