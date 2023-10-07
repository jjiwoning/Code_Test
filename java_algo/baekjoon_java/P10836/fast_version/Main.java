package baekjoon_java.P10836.fast_version;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        int[] prefixSum = new int[size * 2];

        for (int i = 0; i < day; i++) {
            st = new StringTokenizer(br.readLine());
            int zero = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());

            prefixSum[zero]++;
            prefixSum[zero + one]++;
        }

        for (int i = 1; i < prefixSum.length - 1; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }

        int size2 = 2 * size - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = size - 1; i < size2; i++) {
            sb.append(prefixSum[i] + 1).append(" ");
        }
        sb.append("\n");

        int idx = size - 2;

        for (int j = 1; j < size; j++) {
            sb.append(prefixSum[idx--] + 1).append(" ");
            for (int i = size; i < size2; i++) {
                sb.append(prefixSum[i] + 1).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
