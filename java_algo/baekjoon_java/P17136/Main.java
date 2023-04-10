package baekjoon_java.P17136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] paper = new int[10][10];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(new int[]{5, 5, 5, 5, 5}, paper, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }

    private static void dfs(int[] paperInfo, int[][] paperMap, int count) {

        if (answer <= count) {
            return;
        }

        if (isAllDelete(paperMap)) {
            answer = count;
            return;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (paperMap[i][j] == 1) {
                    for (int k = 4; k >= 0; k--) {
                        if (paperInfo[k] > 0) {
                            if (checkPaper(k + 1, i, j, paperMap)) {
                                removePaper(k + 1, i, j, paperMap);
                                paperInfo[k]--;
                                dfs(paperInfo, paperMap, count + 1);
                                paperInfo[k]++;
                                recoverPaper(k + 1, i, j, paperMap);
                            }
                        }
                    }
                    return;
                }
            }
        }
    }

    private static boolean isAllDelete(int[][] paperMap) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (paperMap[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void recoverPaper(int range, int x, int y, int[][] paperMap) {
        for (int i = x; i < x + range; i++) {
            for (int j = y; j < y + range; j++) {
                paperMap[i][j] = 1;
            }
        }
    }

    private static boolean checkPaper(int range, int x, int y, int[][] paperMap) {
        for (int i = x; i < x + range; i++) {
            for (int j = y; j < y + range; j++) {
                if (i < 0 || i >= 10 || j < 0 || j >= 10) {
                    return false;
                }
                if (paperMap[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void removePaper(int range, int x, int y, int[][] paperMap) {
        for (int i = x; i < x + range; i++) {
            for (int j = y; j < y + range; j++) {
                paperMap[i][j] = 0;
            }
        }
    }

}
