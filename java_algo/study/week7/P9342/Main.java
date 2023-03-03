package study.week7.P9342;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String dna = br.readLine();
            if (checkDna(dna)) {
                answer.append("Infected!").append("\n");
                continue;
            }
            answer.append("Good").append("\n");
        }

        System.out.println(answer);
    }

    //문자열은 {A, B, C, D, E, F} 중 0개 또는 1개로 시작해야 한다.
    //그 다음에는 A가 하나 또는 그 이상 있어야 한다.
    //그 다음에는 F가 하나 또는 그 이상 있어야 한다.
    //그 다음에는 C가 하나 또는 그 이상 있어야 한다.
    //그 다음에는 {A, B, C, D, E, F} 중 0개 또는 1개가 있으며, 더 이상의 문자는 없어야 한다.
    private static boolean checkDna(String dna) {

        Set<String> set = new HashSet<>(List.of(new String[]{"A", "B", "C", "D", "E", "F"}));

        boolean aCheck = false;
        boolean fCheck = false;
        boolean cCheck = false;

        for (int i = 0; i < dna.length(); i++) {

            boolean checkA = (dna.charAt(i) + "").equals("A");

            if (i == 0) {
                if (!set.contains(dna.charAt(i) + "")) {
                    return false;
                }
                if (checkA) {
                    aCheck = true;
                }
                continue;
            }

            if (!aCheck) {
                if (!checkA) {
                    return false;
                }
                if (checkA) {
                    aCheck = true;
                    continue;
                }
            }

            boolean checkF = (dna.charAt(i) + "").equals("F");

            if (aCheck && !fCheck) {
                if (checkA) {
                    continue;
                }
                if (checkF) {
                    fCheck = true;
                    continue;
                }
                return false;
            }

            boolean checkC = (dna.charAt(i) + "").equals("C");

            if (aCheck && fCheck && !cCheck) {
                if (checkF) {
                    continue;
                }
                if (checkC) {
                    cCheck = true;
                    continue;
                }
                return false;
            }

            if (aCheck && fCheck && cCheck) {
                if (checkC) {
                    continue;
                }
                if (!set.contains(dna.charAt(i) + "")) {
                    return false;
                }
            }
        }

        return true;
    }
}
