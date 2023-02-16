package swea.P4012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class Solution {
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
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

            System.out.println("#" + t + " " + answer);
        }
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
        int foodSum1 = 0;
        int foodSum2 = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    foodSum1 += arr[i][j];
                    foodSum1 += arr[j][i];
                }
                if (!visited[i] && !visited[j]) {
                    foodSum2 += arr[i][j];
                    foodSum2 += arr[j][i];
                }
            }
        }

        answer = min(answer, abs(foodSum1 - foodSum2));
    }
}
