package Programmers_java;

import java.util.Scanner;

class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        String star = "";
        for (int j = 0; j < a; j++) {
            star += "*";
        }

        for (int i = 0; i < b; i++) {
            System.out.println(star);
        }

        sc.close();
    }
}