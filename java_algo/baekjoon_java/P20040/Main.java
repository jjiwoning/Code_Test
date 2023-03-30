package baekjoon_java.P20040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (isSameParent(s, e)) {
                System.out.println(i + 1);
                return;
            }
            union(s, e);
        }

        System.out.println(0);
    }

    private static void union(int n1, int n2) {
        n1 = find(n1);
        n2 = find(n2);

        if (n1 < n2) {
            parent[n2] = n1;
        }

        if (n1 > n2) {
            parent[n1] = n2;
        }
    }

    private static int find(int n) {
        if (n == parent[n]) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }

    private static boolean isSameParent(int n1, int n2) {
        return find(n1) == find(n2);
    }
}
