package Programmers_java.P132265;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    Set<Integer> set1;
    Set<Integer> set2;
    Map<Integer, Integer> map;

    public int solution(int[] topping) {
        int answer = 0;

        set1 = new HashSet<>();
        set2 = new HashSet<>();
        map = new HashMap<>();

        for (int i : topping) {
            set2.add(i);
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : topping) {
            set1.add(i);
            map.put(i, map.get(i) - 1);
            if (map.get(i) == 0) {
                set2.remove(i);
            }
            if (set1.size() == set2.size()) {
                answer++;
            }
        }

        return answer;
    }
}
