package Programmers_java.kakao_advertise;

/**
 * 프로그래머스 - 카카오 기출 광고 삽입
 */
public class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        long answer = 0;
        int playTimeToSec = getSecTime(play_time);
        int advTimeToSec = getSecTime(adv_time);
        int[] sum = new int[(int) (playTimeToSec + 1)];
        if (playTimeToSec == advTimeToSec) {
            return "00:00:00";
        }

        for (String log : logs) {
            String[] splitStartAndEnd = log.split("-");
            int startTime = getSecTime(splitStartAndEnd[0]);
            int endTime = getSecTime(splitStartAndEnd[1]);

            sum[startTime]++;
            sum[endTime]--;
        }

        for (int i = 0; i < sum.length - 1; i++) {
            sum[i + 1] += sum[i];
        }

        long maxVal = 0;
        for (int i = 1; i < advTimeToSec; i++) {
            maxVal += sum[i];
        }

        long nowTotalTime = maxVal;

        for (int i = 0, j = advTimeToSec; j < playTimeToSec; i++, j++) {
            nowTotalTime += (sum[j] - sum[i]);
            if (nowTotalTime > maxVal) {
                answer = i + 1;
                maxVal = nowTotalTime;
            }
        }

        return getStringTime(answer);
    }
    private int getSecTime(String splitTime) {
        String[] timeToSecArray = splitTime.split(":");
        int hour = Integer.parseInt(timeToSecArray[0]) * 60 * 60;
        int min = Integer.parseInt(timeToSecArray[1]) * 60;
        int sec = Integer.parseInt(timeToSecArray[2]);
        return hour + min + sec;
    }

    private String getStringTime(long secTime) {
        StringBuilder timeString = new StringBuilder();
        // 시
        if (secTime / 3600 > 9) {
            timeString.append(secTime / 3600);
        }
        if (secTime / 3600 <= 9) {
            timeString.append("0").append(secTime / 3600);
        }
        timeString.append(":");

        // 분
        secTime %= 3600;
        if (secTime / 60 > 9) {
            timeString.append(secTime / 60);
        }
        if (secTime / 60 <= 9) {
            timeString.append("0").append(secTime / 60);
        }
        timeString.append(":");

        // 초
        secTime %= 60;
        if (secTime > 9) {
            timeString.append(secTime);
        }
        if (secTime <= 9) {
            timeString.append("0").append(secTime);
        }

        return timeString.toString();
    }
}
