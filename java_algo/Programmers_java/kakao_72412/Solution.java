package Programmers_java.kakao_72412;

import java.util.*;

/**
 * 2021 KAKAO - 순위 검색
 */
public class Solution {

    private Map<String, List<Integer>> people;

    private int[] answer;

    public int[] solution(String[] info, String[] query) {
        answer = new int[query.length];
        initCollections();

        parseInfo(info);

        doQuery(query);

        return answer;
    }

    private void parseInfo(String[] infos) {
        for (String info : infos) {
            String[] query = info.split(" ");
            dfs(query, "", 0);
        }
    }

    private void dfs(String[] info, String now, int depth) {
        if (depth == 4) {
            if (!people.containsKey(now)) {
                people.put(now, new ArrayList<>());
            }
            people.get(now).add(Integer.parseInt(info[depth]));
            return;
        }
        dfs(info, now + "-", depth + 1);
        dfs(info, now + info[depth], depth + 1);
    }

    private void doQuery(String[] queries) {
        int index = 0;

        for (String key : people.keySet()) {
            people.get(key).sort(Comparator.comparingInt(o -> o));
        }

        for (String query : queries) {
            query = query.replaceAll(" and ", "");
            String[] q = query.split(" ");
            if (!people.containsKey(q[0])) {
                this.answer[index++] = 0;
                continue;
            }
            int peopleCount = binarySearch(people.get(q[0]), Integer.parseInt(q[1]));
            this.answer[index++] = peopleCount;
        }
    }

    private int binarySearch(List<Integer> findPeople, int target) {
        int start = 0;
        int end = findPeople.size();

        while (start < end) {
            int mid = (start + end) / 2;

            if (findPeople.get(mid) < target) {
                start = mid + 1;
            }
            if (findPeople.get(mid) >= target) {
                end = mid;
            }
        }

        return findPeople.size() - start;
    }

    private void initCollections() {
        people = new HashMap<>();
    }
}
