package baekjoon_java.P1629;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        long find = Long.parseLong(s[0]);
        long count = Long.parseLong(s[1]);
        long mod = Long.parseLong(s[2]);

        bw.write(findAnswer(find, count, mod) + "\n");
        bw.flush();
    }

    private static long findAnswer(long find, long count, long mod) {
        if (count == 0) {
            return 1;
        }
        long n = findAnswer(find, count / 2, mod);

        if (count % 2 == 0) {
            return n * n % mod;
        }

        return (n * n % mod) * find % mod;
    }
}
