package baekjoon_java.P1786;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] t = br.readLine().toCharArray();
        char[] p = br.readLine().toCharArray();

        int[] pi = getPiArray(p);

        int count = 0;
        StringBuilder answer = new StringBuilder();
//        List<Integer> answerList = new ArrayList<>();

        int index = 0;

        for (int i = 0; i < t.length; i++) {

            while (index > 0 && t[i] != p[index]) {
                index = pi[index - 1];
            }

            if (t[i] == p[index]) {
                if (index == p.length - 1) {
                    count++;
                    answer.append(i - index + 1).append("\n");
//                    answerList.add(i - index + 1);
                    index = pi[index];
                    continue;
                }
                index++;
            }

        }

        System.out.println(count);
//        for (Integer integer : answerList) {
//            System.out.println(integer);
//        }
        System.out.println(answer);
    }

    private static int[] getPiArray(char[] pattern) {
        int[] pi = new int[pattern.length];

        int index = 0;

        for (int i = 1; i < pattern.length; i++) {
            while (index > 0 && pattern[i] != pattern[index]) {
                index = pi[index - 1];
            }

            if (pattern[i] == pattern[index]) {
                index++;
                pi[i] = index;
            }
        }

        return pi;
    }
}
