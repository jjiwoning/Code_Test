package baekjoon_java.P2744;

import java.util.Scanner;

import static java.lang.Character.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        var s1 = s.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            var s2 = s1.charAt(i);
            if (isLowerCase(s2)) {
                sb.append(toUpperCase(s2));
                continue;
            }
            sb.append(toLowerCase(s2));
        }
        System.out.println(sb);
    }
}
