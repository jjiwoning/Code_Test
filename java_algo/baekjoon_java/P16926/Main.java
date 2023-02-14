package baekjoon_java.P16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Math.*;

public class Main {

    static int n;
    static int m;
    static int[][] arr;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input1[0];
        m = input1[1];
        int rotateCount = input1[2];

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            int[] input2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input2[j];
            }
        }

        int cycle = min(n, m) / 2;

        for (int i = 0; i < rotateCount; i++) {
            arr = rotate(cycle);
        }

        for (int[] ints : arr) {
            Arrays.stream(ints).forEach(o1 -> System.out.print(o1 + " "));
            System.out.println();
        }

    }

    private static int[][] rotate(int cycle) {

        int[][] newArr = new int[n][m];

        for (int i = 0; i < cycle; i++) {
            int startX = i;
            int startY = i;
            for (int j = 0; j < 4; j++) {
                while (true) {
                    int mx = startX + dx[j];
                    int my = startY + dy[j];
                    if (mx < i || mx >= n - i || my < i || my >= m - i) {
                        break;
                    }
                    newArr[mx][my] = arr[startX][startY];
                    startX = mx;
                    startY = my;
                }
            }
        }

        return newArr;
    }

}
