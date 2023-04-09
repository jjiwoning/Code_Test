package baekjoon_java.P17404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] homes = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                homes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 첫 번째 집이 빨강 -> 마지막 집 빨강 불가능
        int[][] redDp = new int[n][n];
        Arrays.fill(redDp[0], 1001);
        redDp[0][0] = homes[0][0];

        for (int i = 1; i < n; i++) {
            redDp[i][0] = min(redDp[i - 1][1], redDp[i - 1][2]) + homes[i][0];
            redDp[i][1] = min(redDp[i - 1][0], redDp[i - 1][2]) + homes[i][1];
            redDp[i][2] = min(redDp[i - 1][1], redDp[i - 1][0]) + homes[i][2];
        }
        int redAnswer = min(redDp[n - 1][1], redDp[n - 1][2]);

        // 2. 두 번째 집이 초록 -> 마지막 집 초록 불가능
        int[][] greenDp = new int[n][n];
        Arrays.fill(greenDp[0], 1001);
        greenDp[0][1] = homes[0][1];
        for (int i = 1; i < n; i++) {
            greenDp[i][0] = min(greenDp[i - 1][1], greenDp[i - 1][2]) + homes[i][0];
            greenDp[i][1] = min(greenDp[i - 1][0], greenDp[i - 1][2]) + homes[i][1];
            greenDp[i][2] = min(greenDp[i - 1][1], greenDp[i - 1][0]) + homes[i][2];
        }
        int greenAnswer = min(greenDp[n - 1][0], greenDp[n - 1][2]);

        // 3. 세 번째 집이 파랑 -> 마지막 집 파랑 불가능
        int[][] blueDp = new int[n][n];
        Arrays.fill(blueDp[0], 1001);
        blueDp[0][2] = homes[0][2];
        for (int i = 1; i < n; i++) {
            blueDp[i][0] = min(blueDp[i - 1][1], blueDp[i - 1][2]) + homes[i][0];
            blueDp[i][1] = min(blueDp[i - 1][0], blueDp[i - 1][2]) + homes[i][1];
            blueDp[i][2] = min(blueDp[i - 1][1], blueDp[i - 1][0]) + homes[i][2];
        }
        int blueAnswer = min(blueDp[n - 1][1], blueDp[n - 1][0]);

        System.out.println(min(redAnswer, min(greenAnswer, blueAnswer)));

    }

}
