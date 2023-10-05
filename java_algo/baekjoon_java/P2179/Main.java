package baekjoon_java.P2179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Word> words = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            words.add(new Word(i, br.readLine()));
        }

        Word answerWord1 = words.get(0);
        Word answerWord2 = words.get(1);

        Map<Character, List<Word>> map = new HashMap<>();
        List<Character> keys = new ArrayList<>();

        for (Word word : words) {
            if (!map.containsKey(word.value.charAt(0))) {
                map.put(word.value.charAt(0), new ArrayList<>());
                keys.add(word.value.charAt(0));
            }
            map.get(word.value.charAt(0)).add(word);
        }

        int answerLength = 0;

        for (Character key : keys) {
            List<Word> value = map.get(key);
            if (value.size() <= 1) {
                continue;
            }
            for (int i = 0; i < value.size(); i++) {
                for (int j = i + 1; j < value.size(); j++) {
                    Word word1 = value.get(i);
                    Word word2 = value.get(j);
                    int length = findLength(word1, word2);
                    if (answerLength < length) {
                        answerWord1 = word1;
                        answerWord2 = word2;
                        answerLength = length;
                    }
                }
            }
        }


        if (answerWord1.index < answerWord2.index) {
            System.out.println(answerWord1.value);
            System.out.println(answerWord2.value);
            return;
        }
        System.out.println(answerWord2.value);
        System.out.println(answerWord1.value);
    }

    private static int findLength(Word word1, Word word2) {
        int index = 0;

        int maxLen = Math.min(word1.value.length(), word2.value.length());

        while (index < maxLen) {
            char c1 = word1.value.charAt(index);
            char c2 = word2.value.charAt(index);

            if (c1 != c2) {
                return index;
            }

            index++;
        }

        return index;
    }
}

class Word {
    int index;
    String value;

    public Word(int index, String value) {
        this.index = index;
        this.value = value;
    }
}
