package swea.P1974;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {

            int[][] sudoku = new int[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = sc.nextInt();
                }
            }

            if (checkRowAndCol(sudoku) && check33(sudoku)) {
                System.out.println("#" + test_case + " 1");
            } else {
                System.out.println("#" + test_case + " 0");
            }
        }
    }

    private static boolean checkRowAndCol(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < 9; j++) {
                rowSum += sudoku[i][j];
                colSum += sudoku[j][i];
            }

            if (rowSum != 45 || colSum != 45) {
                return false;
            }
        }

        return true;
    }

    private static boolean check33(int[][] sudoku) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                int sum = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        sum += sudoku[i + k][j + l];
                    }
                }
                if (sum != 45) {
                    return false;
                }
            }
        }

        return true;
    }
}
