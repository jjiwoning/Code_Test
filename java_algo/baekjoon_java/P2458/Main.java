package baekjoon_java.P2458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_VAL = 200000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] distance = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(distance[i], MAX_VAL);
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int person1 = Integer.parseInt(st.nextToken());
            int person2 = Integer.parseInt(st.nextToken());

            distance[person1][person2] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    distance[j][k] = Math.min(distance[j][k], distance[j][i] + distance[i][k]);
                }
            }
        }

        int answer = 0;

        for (int i = 1; i < n + 1; i++) {
            answer++;
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    continue;
                }
                if (distance[i][j] == MAX_VAL && distance[j][i] == MAX_VAL) {
                    answer--;
                    break;
                }
            }
        }

        System.out.println(answer);

    }
}
