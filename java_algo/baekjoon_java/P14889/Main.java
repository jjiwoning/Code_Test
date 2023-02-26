package baekjoon_java.P14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.*;

public class Main {

    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        combination(0, 0);

        System.out.println(answer);
    }

    private static void combination(int index, int count) {
        if (count == n / 2) {
            findDiff();
            return;
        }

        for (int i = index; i < n; i++) {
            visited[i] = true;
            combination(i + 1, count + 1);
            visited[i] = false;
        }
    }

    private static void findDiff() {
        int startSum = 0;
        int linkSum = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    startSum += arr[i][j];
                    startSum += arr[j][i];
                }
                if (!visited[i] && !visited[j]) {
                    linkSum += arr[i][j];
                    linkSum += arr[j][i];
                }
            }
        }

        answer = min(answer, abs(startSum - linkSum));
    }
}