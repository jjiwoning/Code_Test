package Programmers_java.P178871;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    Map<String, Integer> rankMap;

    public String[] solution(String[] players, String[] callings) {
        rankMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }

        for (String calling : callings) {
            Integer index = rankMap.get(calling);
            String player = players[index - 1];
            swap(players, index);
            rankMap.put(calling, index - 1);
            rankMap.put(player, index);
        }

        return players;
    }

    private void swap(String[] players, int index) {
        String temp = players[index];
        players[index] = players[index - 1];
        players[index - 1] = temp;
    }
}
