package Programmers_java.kakao_compression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 프로그래머스 - 압축
 */
public class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> compMap = new HashMap<>();
        int index = 1;

        for (char i = 'A'; i <= 'Z'; i++) {
            compMap.put(String.valueOf(i), index++);
        }

        for (int i = 0; i < msg.length(); i++) {
            int idx = 1;
            while (i + idx <= msg.length() && compMap.containsKey(msg.substring(i, i + idx))) {
                idx++;
            }
            if (i + idx > msg.length()) {
                answer.add(compMap.get(msg.substring(i)));
                break;
            }
            answer.add(compMap.get(msg.substring(i, i + idx - 1)));
            compMap.put(msg.substring(i, i + idx), index++);
            if (idx > 1) {
                i += idx - 2;
            }
        }
        return answer;
    }
}
