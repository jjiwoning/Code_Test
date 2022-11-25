package Programmers_java.eng_ending;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        char lastChar = words[0].charAt(words[0].length() - 1);
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            int now = i % n;
            int turn = i / n;
            String word = words[i];
            if (word.charAt(0) != lastChar || set.contains(word)) {
                answer[0] = now + 1;
                answer[1] = turn + 1;
                break;
            }
            set.add(word);
            lastChar = word.charAt(word.length() - 1);
        }

        return answer;
    }
}
