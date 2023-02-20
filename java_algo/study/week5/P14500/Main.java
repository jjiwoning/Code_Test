package study.week5.P14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int m;
    static int[][] tetris;
    static int answer;
    static int[][][] move = new int[][][]
            {
                    {{1, 1, 1}, {0, 0, 0}}, // ㅁㅁㅁㅁ
                    {{0, 0, 0}, {1, 1, 1}},

                    {{1, 1, 0}, {0, 0, 1}}, // ㅁㅁㅁ
                    {{1, 1, 0}, {0, 0, -1}}, //   ㅁ
                    {{-1, -1, 0}, {0, 0, -1}},
                    {{-1, -1, 0}, {0, 0, 1}},
                    {{0, 0, 1}, {1, 1, 0}},
                    {{0, 0, -1}, {1, 1, 0}},
                    {{0, 0, -1}, {-1, -1, 0}},
                    {{0, 0, 1}, {-1, -1, 0}},

                    {{1, 0, -1}, {0, -1, 0}}, // ㅁㅁ
                                              // ㅁㅁ

                    {{1, 1, -1}, {0, 0, 1}}, //   ㅁ
                    {{1, 1, -1}, {0, 0, -1}}, // ㅁㅁㅁ
                    {{0, 0, -1}, {1, 1, -1}},
                    {{0, 0, 1}, {1, 1, -1}},

                    {{1, 0, 1}, {0, 1, 0}}, // ㅁㅁ
                    {{1, 0, 1}, {0, -1, 0}}, //  ㅁㅁ
                    {{0, 1, 0}, {1, 0, 1}},
                    {{0, -1, 0}, {1, 0, 1}},
            };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");

        n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);

        tetris = new int[n][m];

        for (int i = 0; i < n; i++) {
            tetris[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int[][] block : move) {
                    dfs(i, j, 0, tetris[i][j], block);
                }
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int x, int y, int level, int sum, int[][] block) {
        if (level == 3) {
            answer = Math.max(answer, sum);
            return;
        }

        int dx = x + block[0][level];
        int dy = y + block[1][level];

        if (dx < 0 || dx >= n || dy < 0 || dy >= m) {
            return;
        }

        dfs(dx, dy, level + 1, sum + tetris[dx][dy], block);
    }
}
