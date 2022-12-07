package Programmers_java.discountevent;

import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 - 할인 행사
 */
public class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantedMap = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wantedMap.put(want[i], number[i]);
        }

        for (int i = 0; i < 10; i++) {
            if (wantedMap.containsKey(discount[i])) {
                wantedMap.put(discount[i], wantedMap.get(discount[i]) - 1);
            }
        }

        if (checkMap(wantedMap)) {
            answer++;
        }

        for (int i = 0; i < discount.length - 10; i++) {
            if (wantedMap.containsKey(discount[i])) {
                wantedMap.put(discount[i], wantedMap.get(discount[i]) + 1);
            }

            if (wantedMap.containsKey(discount[i + 10])) {
                wantedMap.put(discount[i + 10], wantedMap.get(discount[i + 10]) - 1);
            }

            if (checkMap(wantedMap)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean checkMap(Map<String, Integer> map) {
        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                return false;
            }
        }
        return true;
    }
}
