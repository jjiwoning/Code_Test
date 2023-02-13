package study.week4.P2447;

import java.util.Scanner;

public class Main {

    static StringBuilder sb;
    static char[][] answer;
    static final char STAR = '*';
    static final char SPACE = ' ';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        int n = sc.nextInt();

        answer = new char[n][n];
        printStar(n, 0, 0);


        for (char[] chars : answer) {
            for (char aChar : chars) {
                sb.append(aChar);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void printStar(int count, int x, int y) {
        int newCount = count / 3;
        int startCount = 0;

        if (count == 1) {
            answer[x][y] = STAR;
            return;
        }

        for (int i = x; i < x + count; i += newCount) {
            for (int j = y; j < y + count; j += newCount) {
                startCount++;
                if (startCount == 5) {
                    printSpace(newCount, i, j);
                    continue;
                }
                printStar(newCount, i, j);
            }
        }
    }

    private static void printSpace(int count, int x, int y) {
        for (int i = x; i < x + count; i++) {
            for (int j = y; j < y + count; j++) {
                answer[i][j] = SPACE;
            }
        }
    }
}
