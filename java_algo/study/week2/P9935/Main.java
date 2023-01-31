package study.week2.P9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String wanted = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (sb.length() >= wanted.length()) { // 원하는 문자열의 길이를 넘어갈 때 체크
                boolean flag = false;

                for (int j = 0; j < wanted.length(); j++) {
                    char findChar = sb.charAt(sb.length() - wanted.length() + j); // 끝에서 부터 원하는 문자까지 자르기
                    char wantedChar = wanted.charAt(j);
                    if (findChar != wantedChar) {
                        flag = true; // 문자열이 다름 -> 안터짐
                        break;
                    }
                }

                if (flag) {
                    continue;
                }
                
                sb.delete(sb.length() - wanted.length(), sb.length());
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}
