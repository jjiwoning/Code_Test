package baekjoon_java.P1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(findZeroCount(Integer.parseInt(br.readLine())));
    }

    private static int findZeroCount(int n) {
        int count = 0;

        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }

        return count;
    }
}
