package swea.P7465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    static Integer[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            setParent(n);

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            for (int i = 1; i < n + 1; i++) {
                find(i);
            }

            Set<Integer> set = new HashSet<>(Arrays.asList(parent));

            System.out.println("#" + testCase + " " + (set.size() - 1));
        }
    }

    private static void setParent(int n) {
        parent = new Integer[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a < b) {
                parent[b] = a;
            }

            if (a > b) {
                parent[a] = b;
            }
        }
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

}
