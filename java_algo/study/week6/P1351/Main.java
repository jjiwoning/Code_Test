package study.week6.P1351;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static long n;
    static int p;
    static int q;
    static Map<Long, Long> map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        map.put(0L, 1L);

        System.out.println(find(n));
    }

    private static long find(long n) {
        if (map.getOrDefault(n, -1L) != -1L) {
            return map.get(n);
        }
        map.put(n, map.getOrDefault(n / p, find(n / p)) + map.getOrDefault(n / q, find(n / q)));
        return map.get(n);
    }
}
