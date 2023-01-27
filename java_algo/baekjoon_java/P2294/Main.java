package baekjoon_java.P2294;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int wanted = sc.nextInt();

        int[] arr = new int[wanted + 1];
        Arrays.fill(arr, 150000);
        arr[0] = 0;

        for (int i = 0; i < size; i++) {
            int n = sc.nextInt();
            for (int j = n; j < arr.length; j++) {
                arr[j] = Math.min(arr[j], arr[j - n] + 1);
            }
        }

        if (arr[wanted] == 150000) {
            System.out.println(-1);
        } else {
            System.out.println(arr[wanted]);
        }
    }
    
}
