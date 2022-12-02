package Programmers_java.word_conversion;

/**
 * 프로그래머스 - 단어 변환
 */
public class Solution {
    static boolean[] visited;
    static int answer;

    public int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }

    private void dfs(String begin, String target, String[] words, int level) {
        if (begin.equals(target)) {
            answer = level;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            int count = checkString(begin, words[i]);

            if (count == begin.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, level + 1);
                visited[i] = false;
            }
        }
    }

    private int checkString(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
