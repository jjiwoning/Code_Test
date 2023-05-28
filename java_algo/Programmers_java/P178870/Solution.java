package Programmers_java.P178870;

public class Solution {
    public int[] solution(int[] sequence, int k) {

        int[] answer = new int[]{0, 0};
        int start = 0;
        int length = sequence.length;

        int find = 0;

        for (int end = 0; end < sequence.length; end++) {
            find += sequence[end];

            while (find > k) {
                find -= sequence[start++];
            }

            if (find == k) {
                if (length > end - start) {
                    length = end - start;
                    answer[0] = start;
                    answer[1] = end;
                }

                if (length == end - start) {
                    answer[0] = Math.min(answer[0], start);
                    answer[1] = Math.min(answer[1], end);
                }
            }
        }

        return answer;
    }
}
