package swea.P1961;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int[][] rotate90 = rotate(arr);
            int[][] rotate180 = rotate(rotate90);
            int[][] rotate270 = rotate(rotate180);

            System.out.println("#" + test_case);

            for (int i = 0; i < n; i++) {
                printArr(rotate90, i);
                printArr(rotate180, i);
                printArr(rotate270, i);
                System.out.println();
            }
        }

    }

    private static void printArr(int[][] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[n][i]);
        }
        System.out.print(" ");
    }

    private static int[][] rotate(int[][] arr) {
        int[][] rotateArr = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                rotateArr[i][j] = arr[arr.length - 1 - j][i];
            }
        }

        return rotateArr;
    }
}
