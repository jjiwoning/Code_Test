package study.week4.P10830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[][] answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        long b = Long.parseLong(s[1]);

        int[][] matrix = new int[n][n];
        answer = new int[n][n];

        for (int i = 0; i < n; i++) {
            answer[i][i] = 1; // 단위 행렬 만들어주기 위함
        }

        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(s1[j]);
            }
        }

        findMatrixPower(matrix, b);

        for (int i = 0; i < n; i++) {
            Arrays.stream(answer[i]).forEach(o1 -> System.out.print(o1 + " "));
            System.out.println();
        }
    }

    static void findMatrixPower(int[][] matrix, long b) {
        if (b == 1) {
            answer = matrixMul(answer, matrix); // 이 경우 다 찾았으니 리턴
            return;
        }

        int[][] newMatrix = matrixMul(matrix, matrix);

        if (b % 2 == 1) {
            answer = matrixMul(answer, matrix); // 나머지가 있으면 행렬 하나가 고립된다. -> 미리 곱해줌
        }

        findMatrixPower(newMatrix, b / 2);

    }

    static int[][] matrixMul(int[][] matrix1, int[][] matrix2) {
        int[][] newMatrix = new int[n][n];

        // 행렬 곱 구하는 코드
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int find = 0;
                for (int k = 0; k < n; k++) {
                    find += (matrix1[i][k] * matrix2[k][j]) % 1000;
                }
                newMatrix[i][j] = find % 1000;
            }
        }

        return newMatrix;
    }

}
