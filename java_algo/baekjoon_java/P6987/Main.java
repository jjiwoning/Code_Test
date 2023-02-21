package baekjoon_java.P6987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int answer;
    static int[][] wantedResult;
    static int[][] result;
    static int[][] pair = new int[][]{
            {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5},
            {1, 2}, {1, 3}, {1, 4}, {1, 5},
            {2, 3}, {2, 4}, {2, 5},
            {3, 4}, {3, 5},
            {4, 5}
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            wantedResult = new int[6][3];
            result = new int[6][3];

            for (int j = 0; j < 6; j++) {
                wantedResult[j][0] = Integer.parseInt(st.nextToken());
                wantedResult[j][1] = Integer.parseInt(st.nextToken());
                wantedResult[j][2] = Integer.parseInt(st.nextToken());
            }

            answer = 0;

            dfs(0);

            sb.append(answer).append(" ");
        }

        System.out.println(sb);
    }

    private static void dfs(int depth) {

        if (depth == 15) {
            for (int i = 0; i < 6; i++) {
                if (!Arrays.equals(result[i], wantedResult[i])) {
                    return;
                }
            }
            answer = 1;
            return;
        }

        int team1 = pair[depth][0];
        int team2 = pair[depth][1];

        // 1. 승
        if (wantedResult[team1][0] > result[team1][0] && wantedResult[team2][2] > result[team2][2]) {
            result[team1][0]++;
            result[team2][2]++;
            dfs(depth + 1);
            result[team1][0]--;
            result[team2][2]--;
        }
        // 2. 무
        if (wantedResult[team1][1] > result[team1][1] && wantedResult[team2][1] > result[team2][1]) {
            result[team1][1]++;
            result[team2][1]++;
            dfs(depth + 1);
            result[team1][1]--;
            result[team2][1]--;
        }
        // 3. 패
        if (wantedResult[team1][2] > result[team1][2] && wantedResult[team2][0] > result[team2][0]) {
            result[team1][2]++;
            result[team2][0]++;
            dfs(depth + 1);
            result[team1][2]--;
            result[team2][0]--;
        }

    }

}
