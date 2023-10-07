package baekjoon_java.P10836.fast2;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        int[][] bees = new int[size][size];

        int[] prefixSum = new int[size * 2];

        for (int i = 0; i < day; i++) {
            st = new StringTokenizer(br.readLine());
            int zero = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());

            prefixSum[zero]++;
            prefixSum[zero + one]++;

        }

        int startY = 0;
        int startX = size - 1;
        int nowSum = 0;

        for (int i = 0; i < prefixSum.length - 1; i++) {
            nowSum += prefixSum[i];
            bees[startX][startY] += nowSum;
            if (startX > 0) {
                startX--;
                continue;
            }
            startY++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j == 0) {
                    sb.append(bees[i][j] + 1).append(" ");
                    continue;
                }
                sb.append(bees[0][j] + 1).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
