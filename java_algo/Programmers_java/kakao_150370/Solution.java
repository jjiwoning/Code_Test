package Programmers_java.kakao_150370;

import java.util.*;

public class Solution {

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> endList = new ArrayList<>();

        int[] privacyToDay = convertTimeToInt(privacies);
        int todayToInt = convertTimeToInt(today);
        Map<String, Integer> termsMap = setTermsMap(terms);

        for(int i = 0; i < privacyToDay.length; i++) {
            String term = privacies[i].split(" ")[1];
            if (checkPrivacyEnd(privacyToDay[i], todayToInt, termsMap.get(term))) {
                endList.add(i + 1);
            }
        }

        int[] answer = new int[endList.size()];

        for(int i = 0; i < endList.size(); i++) {
            answer[i] = endList.get(i);
        }

        return answer;
    }

    private Map<String, Integer> setTermsMap(String[] terms) {
        Map<String, Integer> termsMap = new HashMap<>();

        for(String term : terms) {
            String[] termInfo = term.split(" ");
            termsMap.put(termInfo[0], Integer.parseInt(termInfo[1]) * 28);
        }

        return termsMap;
    }

    private int[] convertTimeToInt(String[] privacies) {
        int[] convertArr = new int[privacies.length];

        for(int i = 0; i < privacies.length; i++) {
            String[] day = privacies[i].split(" ");
            String[] hms = day[0].split("\\.");
            convertArr[i] += Integer.parseInt(hms[0]) * 28 * 12;
            convertArr[i] += Integer.parseInt(hms[1]) * 28;
            convertArr[i] += Integer.parseInt(hms[2]);
        }

        return convertArr;
    }

    private int convertTimeToInt(String today) {
        int todayToInt = 0;

        String[] hms = today.split("\\.");
        todayToInt += Integer.parseInt(hms[0]) * 28 * 12;
        todayToInt += Integer.parseInt(hms[1]) * 28;
        todayToInt += Integer.parseInt(hms[2]);

        return todayToInt;
    }

    private boolean checkPrivacyEnd(int time, int today, int term) {
        return time + term <= today;
    }
}
