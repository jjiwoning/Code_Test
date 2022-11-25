package Programmers_java.parking;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] solution(int[] fees, String[] records) {

        int[] inCar = new int[10000];
        for (int i = 0; i < inCar.length; i++) {
            inCar[i] = -1;
        }
        int[] totalTime = new int[10000];

        for (String record : records) {
            String[] strings = record.split(" ");
            int carNum = Integer.parseInt(strings[1]);
            int carTime = getCarTime(strings[0]);

            if (strings[2].equals("IN")) {
                inCar[carNum] += carTime + 1;
                continue;
            }

            if (strings[2].equals("OUT")) {
                totalTime[carNum] += carTime - inCar[carNum];
                inCar[carNum] = -1;
                continue;
            }
        }

        for (int i = 0; i < inCar.length; i++) {
            if (inCar[i] > -1) {
                totalTime[i] += (1439 - inCar[i]);
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < totalTime.length; i++) {
            if (totalTime[i] > 0) {
                if(totalTime[i] < fees[0]) {
                    list.add(fees[1]);
                    continue;
                }
                if (totalTime[i] >= fees[0]) {
                    Integer fee = fees[1] + (int)Math.ceil(((double)(totalTime[i] - fees[0])) / fees[2]) * fees[3];
                    list.add(fee);
                    continue;
                }
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    private int getCarTime(String string) {
        String[] time = string.split(":");
        int carTime = Integer.parseInt(time[0]) * 60;
        carTime += Integer.parseInt(time[1]);
        return carTime;
    }

}
