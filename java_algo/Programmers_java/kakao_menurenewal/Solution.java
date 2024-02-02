package Programmers_java.kakao_menurenewal;

import java.util.*;

/**
 * 프로그래머스 - 카카오 메뉴 리뉴얼
 */
public class Solution {

    private Map<String, Integer> map;

    public String[] solution(String[] orders, int[] courses) {

        List<String> answers = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            orders[i] = sortString(orders[i]);
        }

        for (int course : courses) {
            map = new HashMap<>();
            for (String order : orders) {
                dfs("", order, course);
            }

            List<Integer> counts = new ArrayList<>(map.values());

            if (map.isEmpty()) {
                continue;
            }

            Integer findMax = counts.stream()
                .max(Comparator.comparingInt(o -> o))
                .orElseThrow();

            if (findMax > 1) {
                for (String key : map.keySet()) {
                    if (Objects.equals(map.get(key), findMax)) {
                        answers.add(key);
                    }
                }
            }
        }

        answers.sort(String::compareTo);
        String[] answer = new String[answers.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answers.get(i);
        }

        return answer;
    }

    private void dfs(String order, String other, int count) {
        if (count == 0) {
            map.put(order, map.getOrDefault(order, 0) + 1);
            return;
        }

        for (int i = 0; i < other.length(); i++) {
            dfs(order + other.charAt(i), other.substring(i + 1), count - 1);
        }
    }

    private String sortString(String string) {
        char[] charArray = string.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
}
