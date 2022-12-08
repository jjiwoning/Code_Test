package Programmers_java.bestalbum;

import java.util.*;

/**
 * 프로그래머스 - 베스트 앨범
 */
public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (!genreMap.containsKey(genres[i])) {
                genreMap.put(genres[i], plays[i]);
            } else {
                genreMap.put(genres[i], genreMap.get(genres[i]) + plays[i]);
            }
        }

        List<String> genreList = new ArrayList<>(genreMap.keySet());
        genreList.sort((o1, o2) -> genreMap.get(o2) - genreMap.get(o1));

        List<Integer> answerList = new ArrayList<>();

        for (String s : genreList) {
            int max = 0;
            int index = -1;
            for (int i = 0; i < genres.length; i++) {
                if (s.equals(genres[i]) && max < plays[i]) {
                    max = plays[i];
                    index = i;
                }
            }

            answerList.add(index);

            max = 0;
            int secondIndex = -1;
            for (int i = 0; i < genres.length; i++) {
                if (s.equals(genres[i]) && max < plays[i] && i != index) {
                    max = plays[i];
                    secondIndex = i;
                }
            }

            if (secondIndex >= 0) {
                answerList.add(secondIndex);
            }
        }

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
