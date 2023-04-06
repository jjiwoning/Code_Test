package swea.P5643;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Math.*;

public class Solution {

    static final int MAX_VAL = 200000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = parseInt(br.readLine());

        for (int testCase = 1; testCase < t + 1; testCase++) {

            int n = parseInt(br.readLine());
            int m = parseInt(br.readLine());

            int[][] distance = new int[n + 1][n + 1];

            for (int i = 0; i < n + 1; i++) {
                Arrays.fill(distance[i], MAX_VAL);
            }


            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int person1 = parseInt(st.nextToken());
                int person2 = parseInt(st.nextToken());

                distance[person1][person2] = 1;
            }

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    for (int k = 1; k < n + 1; k++) {
                        distance[j][k] = min(distance[j][k], distance[j][i] + distance[i][k]);
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

            System.out.println("#" + testCase + " " + answer);
        }
    }
}
