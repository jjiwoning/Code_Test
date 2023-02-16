package Programmers_java.P155651;

/**
 * 프로그래머스 - 호텔 대실
 */
public class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] bookTimeToInteger = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            bookTimeToInteger[i] = formattingToInt(book_time[i]);
        }

        int[] totalRoom = new int[1460];

        for (int[] bookTime : bookTimeToInteger) {

            for (int i = bookTime[0]; i < bookTime[1] + 10; i++) {
                totalRoom[i]++;
                if (totalRoom[i] > answer) {
                    answer = totalRoom[i];
                }
            }
        }

        return answer;
    }

    private int[] formattingToInt(String[] book_time) {
        int[] formattingArr = new int[2];
        String[] startTime = book_time[0].split(":");
        String[] endTime = book_time[1].split(":");

        formattingArr[0] = 60 * Integer.parseInt(startTime[0]) + Integer.parseInt(startTime[1]);
        formattingArr[1] = 60 * Integer.parseInt(endTime[0]) + Integer.parseInt(endTime[1]);

        return formattingArr;
    }
}
