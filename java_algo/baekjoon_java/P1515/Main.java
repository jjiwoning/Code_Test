package baekjoon_java.P1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        String s = new BufferedReader(new InputStreamReader(System.in)).readLine();

        int num = 1;
        int index = 0;

        while (index < s.length()) {
            String num1 = String.valueOf(num);
            for (int i = 0; i < num1.length(); i++) {
                int target = s.charAt(index) - '0';
                if (num1.charAt(i) - '0' == target) {
                    index++;
                }
                if (index == s.length()) {
                    System.out.println(num);
                    return;
                }
            }
            num++;
        }

        System.out.println(num);
    }
}
