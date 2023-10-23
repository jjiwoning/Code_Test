package Programmers_java.kakao17680;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

/**
 * 2018 카카오 기출 - [1차] 캐시
 */
public class Solution {

    private static final int CACHE_HIT_COST = 1;
    private static final int CACHE_MISS_COST = 5;

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Queue<String> queue = new LinkedList<>();

        if (cacheSize == 0) {
            return CACHE_MISS_COST * cities.length;
        }

        for (String city : cities) {
            city = city.toLowerCase(Locale.ROOT);
            if (queue.size() < cacheSize) {
                if (!queue.contains(city)) {
                    queue.add(city);
                    answer += CACHE_MISS_COST;
                    continue;
                }
                if (queue.contains(city)) {
                    answer += CACHE_HIT_COST;
                    queue.remove(city);
                    queue.add(city);
                }
                continue;
            }

            if (queue.size() == cacheSize) {
                if (!queue.contains(city)) {
                    queue.poll();
                    queue.add(city);
                    answer += CACHE_MISS_COST;
                    continue;
                }
                if (queue.contains(city)) {
                    answer += CACHE_HIT_COST;
                    queue.remove(city);
                    queue.add(city);
                }
            }
        }

        return answer;
    }
}
