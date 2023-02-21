package study.week6.Programmers42576;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        return findAnswer(participant, completion);
    }

    private String findAnswer(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            map.put(s, map.get(s) - 1);
        }

        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                return s;
            }
        }
        throw new IllegalArgumentException("유효하지 않은 입력");
    }
}
