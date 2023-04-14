package study.week13.kakao_17676;

import java.util.Arrays;

public class Solution {
    int[] endTime;
    int[] useTime;

    public int solution(String[] lines) {

        parseLines(lines);

        System.out.println(Arrays.toString(endTime));
        System.out.println(Arrays.toString(useTime));

        return findMaximumUsing();
    }

    private void parseLines(String[] lines) {
        endTime = new int[lines.length];
        useTime = new int[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String[] splitTime = lines[i].split(" ");
            useTime[i] = useTimeToDouble(splitTime[2]);
            endTime[i] = endTimeStringToDoubleSec(splitTime[1]);
        }
    }

    private int useTimeToDouble(String useTimeString) {
        useTimeString = useTimeString.replace("s", "");
        return (int) (Double.parseDouble(useTimeString) * 1000);
    }

    private int endTimeStringToDoubleSec(String endTimeString) {
        String[] splitEndTime = endTimeString.split(":");
        double endTimeToDouble = 0;
        endTimeToDouble += Double.parseDouble(splitEndTime[0]) * 3600;
        endTimeToDouble += Double.parseDouble(splitEndTime[1]) * 60;
        endTimeToDouble += Double.parseDouble(splitEndTime[2]);
        int endTimeToInt = (int) (endTimeToDouble * 1000);
        return endTimeToInt;
    }

    private int findMaximumUsing() {
        int answer = 0;

        for (int i = 0; i < endTime.length; i++) {
            int count = 0;
            for (int j = 0; j < endTime.length; j++) {
                if (endTime[i] > endTime[j] || endTime[i] + 999 <= endTime[j] - useTime[j]) {
                    continue;
                }
                count++;
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }
}
