package algo_sample_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoyerMooreSample {
    public static List<Integer> search(String text, String keyword) {
        List<Integer> indices = new ArrayList<>();

        Map<Character, Integer> skipTable = createSkipTable(keyword);

        int textPointer = keyword.length() - 1;
        while (textPointer > 0 && textPointer <= text.length() - keyword.length()) {
            int keywordPointer = keyword.length() - 1;
            int matchCount = 0;

            while (keywordPointer >= 0 && text.charAt(textPointer) == keyword.charAt(keywordPointer)) {
                textPointer--;
                keywordPointer--;
                matchCount++;
            }

            if (keywordPointer < 0) {
                indices.add(++textPointer);
                textPointer += keyword.length() + (keyword.length() - 1);
            } else {
                // skip 테이블의 값에서 앞서 일치한 수 만큼 뺀 값 만큼 skip
                // 이후 포인터를 다시 비교할 부분의 끝으로 돌려야 하므로 다시 matchCount 더함
                // 의미를 명확히 하기 위해 -matchCount + matchCount = 0으로 소거하지 않았음
                textPointer +=
                        skipTable.getOrDefault(text.charAt(textPointer), keyword.length()) - matchCount + matchCount;
            }
        }

        return indices;
    }

    private static Map<Character, Integer> createSkipTable(String keyword) {
        Map<Character, Integer> skipTable = new HashMap<>();
        int count = keyword.length() - 1;
        for (char ch : keyword.toCharArray()) {
            skipTable.put(ch, count--);
        }
        return skipTable;
    }
}
