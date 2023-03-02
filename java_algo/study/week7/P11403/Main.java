package study.week7.P11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_VAL = 2000000;
    static int n;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 0) {
                    matrix[i][j] = MAX_VAL;
                    continue;
                }
                matrix[i][j] = n;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = Math.min(matrix[j][k], matrix[j][i] + matrix[i][k]);
                }
            }
        }

        for (int[] r : matrix) {
            for (int num : r) {
                if (num == MAX_VAL) {
                    System.out.print(0 + " ");
                    continue;
                }
                System.out.print(1 + " ");
            }
            System.out.println();
        }
    }
}
