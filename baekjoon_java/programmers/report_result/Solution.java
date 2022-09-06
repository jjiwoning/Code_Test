package baekjoon_java.programmers.report_result;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        //리폿 횟수 저장 맵 선언
        Map<String, Integer> reportMap = new HashMap<>();
        //누가 누구 리폿했는지 저장 맵 선언
        Map<String, HashSet<String>> whoReport = new HashMap<>();

        //배열 -> 집합 : 중복 제거
        HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));
        for (String s : reportSet) {
            String[] s1 = s.split(" ");
            if(!reportMap.containsKey(s1[1])){
                reportMap.put(s1[1], 0);
            }
            reportMap.put(s1[1], reportMap.get(s1[1]) + 1);

            if(!whoReport.containsKey(s1[0])){
                whoReport.put(s1[0], new HashSet<>());
            }
            whoReport.get(s1[0]).add(s1[1]);
        }

        for (String s : reportMap.keySet()) {
            Integer count = reportMap.get(s);
            if(count >= k){
                for (int i = 0; i < id_list.length; i++) {
                    if(whoReport.containsKey(id_list[i]) && whoReport.get(id_list[i]).contains(s)){
                        answer[i]++;
                    }
                }
            }
        }

        return answer;
    }
}
