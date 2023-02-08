package baekjoon_java.P11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(input[j - 1]);
            }
        }

        int[][] sum = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = arr[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int startX = Integer.parseInt(input[0]);
            int startY = Integer.parseInt(input[1]);
            int endX = Integer.parseInt(input[2]);
            int endY = Integer.parseInt(input[3]);

            int answer = sum[endX][endY] - sum[startX - 1][endY] - sum[endX][startY - 1] + sum[startX - 1][startY - 1];

            System.out.println(answer);
        }
    }
}
