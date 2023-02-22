package study.week6.P17609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            System.out.println(checkString(s, 0, s.length() -1, false));
        }
    }

    private static int checkString(String s, int startIndex, int endIndex, boolean check) {

        while (startIndex < endIndex) {

            char c1 = s.charAt(startIndex);
            char c2 = s.charAt(endIndex);

            if (c1 == c2) {
                startIndex++;
                endIndex--;
                continue;
            }

            if (check) {
                return 2;
            }

            int find1 = 2;
            int find2 = 2;

            if (c1 == s.charAt(endIndex - 1)) {
                find1 = checkString(s, startIndex + 1, endIndex - 2, true);
            }

            if (c2 == s.charAt(startIndex + 1)) {
                find2 = checkString(s, startIndex + 2, endIndex - 1, true);
            }

            return Math.min(find1, find2);
        }

        if (check) {
            return 1;
        }
        return 0;
    }
}
