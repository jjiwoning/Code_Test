package Programmers_java.kakao_42890;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 카카오 기출 - 후보키
 * 생각한 로직
 * 1. 1개부터 후보키를 만족하는 키를 찾는다.
 * 2. 그 다음에는 해당 후보키를 제외하고 만족하는 2개의 후보키를 찾는다. -> 최소성을 만족해야함
 * 3. 마지막까지 반복
 */
public class Solution {

    String[][] relation;
    Set<Set<Integer>> candidateSet;

    public int solution(String[][] relation) {
        this.relation = relation;
        candidateSet = new HashSet<>();

        for (int i = 1; i <= relation[0].length; i++) {
            combination(i, 0, 0, new HashSet<>());
        }

        return candidateSet.size();
    }

    private void combination(int now, int depth, int index, Set<Integer> set) {
        if (depth == now) {
            if (isUnique(set)) {
                candidateSet.add(set);
            }
            return;
        }
        if (index == relation[0].length) {
            return;
        }

        Set<Integer> makeSet = new HashSet<>(set);
        makeSet.add(index);
        combination(now, depth + 1, index + 1, makeSet);
        Set<Integer> makeSet2 = new HashSet<>(set);
        combination(now, depth, index + 1, makeSet2);

    }

    private boolean isUnique(Set<Integer> set) {
        for (Set<Integer> nowSet : candidateSet) {
            if (set.containsAll(nowSet)) {
                return false;
            }
        }

        return relationCheck(set);
    }

    private boolean relationCheck(Set<Integer> set) {
        String[] makeKey = new String[relation.length];
        Arrays.fill(makeKey, "");
        for (Integer col : set) {
            for (int i = 0; i < relation.length; i++) {
                makeKey[i] += relation[i][col];
            }
        }
        Set<String> makeSet = new HashSet<>(List.of(makeKey));
        return makeSet.size() == relation.length;
    }
}
