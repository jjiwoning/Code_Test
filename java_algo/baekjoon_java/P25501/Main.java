package baekjoon_java.P25501;

import java.util.Scanner;

public class Main {

    private static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            count = 0;
            String s = sc.next();
            int answer = isPalindrome(s);
            System.out.println(answer + " " + count);
        }
    }

    private static int recursion(String s, int l, int r){
        count++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    private static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
}
