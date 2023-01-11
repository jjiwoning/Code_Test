package codetree.Extract_only_integers_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int a1 = getNumber(a);
        int b1 = getNumber(b);

        System.out.println(a1 + b1);
    }

    private static int getNumber(String s) {
        String num = "";
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                num += s.charAt(i);
            }
        }

        int answer = Integer.parseInt(num);

        return answer;
    }
}
