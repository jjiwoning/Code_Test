package Programmers_java.P131130;

import java.util.Arrays;

/**
 * 프로그래머스 - 혼자 놀기의 달인
 */
public class Solution {
    private int parent[];

    public int solution(int[] cards) {
        parent = new int[cards.length + 1];

        for (int i = 1; i < cards.length + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < cards.length; i++) {
            union(i + 1, cards[i]);
        }

        Integer[] answerArr = new Integer[cards.length + 1];

        for (int i = 0; i < cards.length + 1; i++) {
            answerArr[i] = 0;
        }

        for (int i = 1; i < cards.length + 1; i++) {
            find(i);
            answerArr[parent[i]]++;
        }

        Arrays.sort(answerArr, (o1, o2) -> o2 - o1);

        return answerArr[0] * answerArr[1];
    }

    private int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        }
        if (x > y) {
            parent[x] = y;
        }
    }

    private boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }
}
