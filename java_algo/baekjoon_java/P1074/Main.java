package baekjoon_java.P1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {

    static int n;
    static int r;
    static int c;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(dfs(r, c, n) - 1);
    }

    private static long dfs(int x, int y, int level) {

        int piece = (int)pow(2, level - 1) * (int)pow(2, level - 1);
        int newR = x / (int) pow(2, level - 1);
        int newC = y / (int) pow(2, level - 1);

        if (level == 1) {
            return lastPiece(newR, newC);
        }

        long answer = findSum(newR, newC, piece);

        answer += dfs(x % (int) pow(2, level - 1), y % (int) pow(2, level - 1), level - 1);

        return answer;
    }

    private static long lastPiece(int x, int y) {

        if (x == 0 && y == 0) {
            return 1;
        }
        if (x == 0 && y == 1) {
            return 2;
        }
        if (x == 1 && y == 0) {
            return 3;
        }
        if (x == 1 && y == 1) {
            return 4;
        }
        throw new IllegalArgumentException("잘못된 입력");
    }

    private static long findSum(int newR, int newC, int piece) {
        if (newR == 0 && newC == 0) {
            return 0;
        }
        if (newR == 0 && newC == 1) {
            return piece;
        }
        if (newR == 1 && newC == 0) {
            return piece * 2L;
        }
        if (newR == 1 && newC == 1) {
            return piece * 3L;
        }
        throw new IllegalArgumentException("잘못된 입력");
    }
}
