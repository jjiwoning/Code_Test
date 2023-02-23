package swea.P2806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int n;
    static boolean[] col;
    static boolean[] cross1;
    static boolean[] cross2;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= t; testCase++) {
            answer = 0;
            n = Integer.parseInt(br.readLine());
            col = new boolean[n];
            cross1 = new boolean[n * 2];
            cross2 = new boolean[n * 2];

            setQueen(0);
            System.out.println("#" + testCase + " " + answer);
        }
    }

    private static void setQueen(int depth) {
        if(depth == n) {
            answer++;
            return;
        }

        for(int i = 0; i < n; i++) {
            if (checkQueen(depth, i)) {
                col[i] = true;
                cross1[depth + i] = true;
                cross2[n - depth + i] = true;
                setQueen(depth + 1);
                cross2[n - depth + i] = false;
                cross1[depth + i] = false;
                col[i] = false;
            }
        }
    }

    private static boolean checkQueen(int depth, int i) {
        if (col[i] || cross1[depth + i] || cross2[n - depth + i]) {
            return false;
        }
        return true;
    }
}