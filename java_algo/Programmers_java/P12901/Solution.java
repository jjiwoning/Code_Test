package Programmers_java.P12901;

public class Solution {
    String[] day = new String[]{"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

    public String solution(int a, int b) {
        int passDay = passMonth(a) + b - 1;
        passDay %= 7;
        return day[passDay];
    }

    private int passMonth(int a) {
        int daySum = 0;
        for(int i = 1; i < a; i++) {
            daySum += getMonthToDay(i);
        }
        return daySum;
    }

    private int getMonthToDay(int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        return 29;
    }
}
