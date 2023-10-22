package baekjoon_java.P1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        String s = new BufferedReader(new InputStreamReader(System.in)).readLine();

        int answer = Integer.MAX_VALUE;

        int totalACount = getTotalACount(s);

        for (int i = 0; i < s.length(); i++) {
            int nowBCount = 0;
            nowBCount = getNowBCount(s, totalACount, i, nowBCount);
            answer = Math.min(answer, nowBCount);
        }

        System.out.println(answer);
    }

    private static int getTotalACount(String s) {
        int totalACount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                totalACount++;
            }
        }
        return totalACount;
    }

    private static int getNowBCount(String s, int totalACount, int i, int nowBCount) {
        for (int j = i; j < i + totalACount; j++) {
            int index = j % s.length();
            if (s.charAt(index) == 'b') {
                nowBCount++;
            }
        }
        return nowBCount;
    }
}
