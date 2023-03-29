package baekjoon_java.P1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int n = parseInt(st.nextToken());
            int m = parseInt(st.nextToken());
            BigInteger answer = new BigInteger("1");
            for (int i = 0; i < n; i++) {
                answer = answer.multiply(new BigInteger(String.valueOf(m)));
                m--;
            }
            int n1 = n;
            for (int i = 0; i < n; i++) {
                answer = answer.divide(new BigInteger(String.valueOf(n1)));
                n1--;
            }
            System.out.println(answer);
        }
    }
}
