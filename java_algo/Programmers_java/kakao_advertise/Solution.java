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

            for (int i = startTime; i < endTime; i++) {
                sum[i]++;
            }
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
        int totalTime = hour + min + sec;
        return totalTime;
    }

    private String getStringTime(long secTime) {
        String hour, min, sec;
        hour = (secTime/3600)>9? (secTime/3600)+"":"0"+secTime/3600;
        secTime%=3600;
        min = (secTime/60)>9? (secTime/60)+"":"0"+secTime/60;
        secTime%=60;
        sec = secTime>9? secTime+"":"0"+secTime;

        return hour+":"+min+":"+sec;
    }
}
