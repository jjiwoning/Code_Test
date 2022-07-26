package baekjoon_java.Prac.P10986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int sum = 0;
        long[] c = new long[M];
        long answer = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            sum = (sum + Integer.parseInt(st.nextToken())) % M;
            c[sum]++;
        }

        answer = c[0];

        for (int i = 0; i < M; i++) {
            if(c[i] > 1){
                answer = answer + (c[i] * (c[i] - 1) / 2);
            }
        }

        System.out.println(answer);

    }

}
