package baekjoon_java.Prac.P1427;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.next();
        char[] arr;
        arr = N.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            int Max = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] > arr[Max]){
                    Max = j;
                }
            }
            if(arr[i] < arr[Max]){
                char temp = arr[i];
                arr[i] = arr[Max];
                arr[Max] = temp;
            }
        }

        for (char c : arr) {
            System.out.print(c);
        }
    }
}
