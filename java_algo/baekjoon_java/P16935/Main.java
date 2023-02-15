package baekjoon_java.P16935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n;
    static int m;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] commands = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int command : commands) {
            selectCommand(command);
        }

        for (int[] answer : arr) {
            Arrays.stream(answer).forEach(o1 -> System.out.print(o1 + " "));
            System.out.println();
        }
    }

    private static void selectCommand(int command) {
        if (command == 1) {
            operation1();
            return;
        }

        if (command == 2) {
            operation2();
            return;
        }

        if (command == 3) {
            operation3();
            return;
        }

        if (command == 4) {
            operation4();
            return;
        }

        if (command == 5) {
            operation5();
            return;
        }

        if (command == 6) {
            operation6();
            return;
        }
    }

    private static void operation1() {
        int cycle = n / 2;
        for (int x = 0; x < cycle; x++) {
            for (int y = 0; y < m; y++) {
                int temp = arr[x][y];
                arr[x][y] = arr[n - 1 - x][y];
                arr[n - 1 - x][y] = temp;
            }
        }
    }

    private static void operation2() {
        int cycle = m / 2;
        for (int y = 0; y < cycle; y++) {
            for (int x = 0; x < n; x++) {
                int temp = arr[x][y];
                arr[x][y] = arr[x][m - 1 - y];
                arr[x][m - 1 - y] = temp;
            }
        }
    }

    private static void operation3() {
        int[][] newArr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newArr[i][j] = arr[n - 1 - j][i];
            }
        }

        arr = newArr;
        changeNM();
    }

    private static void operation4() {
        int[][] newArr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newArr[i][j] = arr[j][m - 1 - i];
            }
        }

        arr = newArr;
        changeNM();
    }

    private static void changeNM() {
        int temp = n;
        n = m;
        m = temp;
    }

    private static void operation5() {
        // 5번 연산은 1번 그룹의 부분 배열을 2번 그룹 위치로, 2번을 3번으로, 3번을 4번으로, 4번을 1번으로 이동시키는 연산이다.
        int divideN = n / 2;
        int divideM = m / 2;

        Queue<Integer> queue = new LinkedList<>();

        int[][] startPoint = new int[][]{{0, 0}, {0, divideM}, {divideN, divideM}, {divideN, 0}};

        for (int[] start : startPoint) {
            for (int x = start[0]; x < start[0] + divideN; x++) {
                for (int y = start[1]; y < start[1] + divideM; y++) {
                    queue.add(arr[x][y]);
                }
            }
        }

        int[][] endPoint = new int[][]{{0, divideM}, {divideN, divideM}, {divideN, 0}, {0, 0}};

        for (int[] end : endPoint) {
            for (int x = end[0]; x < end[0] + divideN; x++) {
                for (int y = end[1]; y < end[1] + divideM; y++) {
                    arr[x][y] = queue.poll();
                }
            }
        }
    }

    private static void operation6() {
        // 6번 연산은 1번 그룹의 부분 배열을 4번 그룹 위치로, 4번을 3번으로, 3번을 2번으로, 2번을 1번으로 이동시키는 연산이다.
        int divideN = n / 2;
        int divideM = m / 2;

        Queue<Integer> queue = new LinkedList<>();

        int[][] startPoint = new int[][]{{0, 0}, {divideN, 0}, {divideN, divideM}, {0, divideM}};

        for (int[] start : startPoint) {
            for (int x = start[0]; x < start[0] + divideN; x++) {
                for (int y = start[1]; y < start[1] + divideM; y++) {
                    queue.add(arr[x][y]);
                }
            }
        }

        int[][] endPoint = new int[][]{{divideN, 0}, {divideN, divideM}, {0, divideM}, {0, 0}};

        for (int[] end : endPoint) {
            for (int x = end[0]; x < end[0] + divideN; x++) {
                for (int y = end[1]; y < end[1] + divideM; y++) {
                    arr[x][y] = queue.poll();
                }
            }
        }
    }
}
