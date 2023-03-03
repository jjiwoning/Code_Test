package swea.P2115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int m;
    static int c;
    static int[][] honey;
    static int answer;
    static int findHoney;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder output = new StringBuilder();
        StringTokenizer st;

        for (int testCase = 1; testCase <= t; testCase++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());


            honey = new int[n][n];
            answer = -1;

            for (int i = 0; i < n; i++) {
                honey[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int totalCount = (int) Math.pow(n, 2);

            for (int i = 0; i < totalCount; i++) {
                for (int j = i; j < totalCount; j++) {
                    combination(i, j);
                }
            }

            output.append("#").append(testCase).append(" ").append(answer).append("\n");
        }

        System.out.println(output);
    }

    private static void combination(int c1, int c2) {
        int x1 = c1 / n;
        int y1 = c1 % n;
        int x2 = c2 / n;
        int y2 = c2 % n;

        if (!validInput(x1, x2, y1, y2)) {
            return;
        }

        getSum(x1, y1, x2, y2);
    }

    private static boolean validInput(int x1, int x2, int y1, int y2) {
        if (x1 == x2) {
            if (y2 - y1 < m) {
                return false;
            }
        }

        if (y2 + m > n) {
            return false;
        }

        if (y1 + m > n) {
            return false;
        }

        return true;
    }

    private static void getSum(int x1, int y1, int x2, int y2) {
        int[] firstHoney = new int[m];
        int[] secondHoney = new int[m];

        int index = 0;
        for (int i = y1; i < y1 + m; i++) {
            firstHoney[index++] = honey[x1][i];
        }

        index = 0;
        for (int i = y2; i < y2 + m; i++) {
            secondHoney[index++] = honey[x2][i];
        }

        answer = Math.max(answer, findMaxHoney(firstHoney) + findMaxHoney(secondHoney));
    }

    private static int findMaxHoney(int[] nowHoney) {
        boolean[] visited = new boolean[m];
        findHoney = 0;
        dfs(0, visited, nowHoney);
        return findHoney;
    }

    private static void dfs(int index, boolean[] visited, int[] nowHoney) {
        if (index == m) {
            validHoneyMaximum(visited, nowHoney);
            return;
        }

        visited[index] = true;
        dfs(index + 1, visited, nowHoney);
        visited[index] = false;
        dfs(index + 1, visited, nowHoney);
    }

    private static void validHoneyMaximum(boolean[] visited, int[] nowHoney) {
        int maxHoney = 0;
        int maxHoneyPower = 0;
        for (int i = 0; i < m; i++) {
            if (visited[i]) {
                maxHoney += nowHoney[i];
                maxHoneyPower += (int) Math.pow(nowHoney[i], 2);
            }
        }

        if (maxHoney > c) {
            return;
        }

        findHoney = Math.max(findHoney, maxHoneyPower);
    }
}
