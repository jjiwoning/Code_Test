package swea.P3289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringBuilder answer = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            setParent(n);

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int type = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (type == 0) {
                    union(a, b);
                }

                if (type == 1) {
                    if (isSameParent(a, b)) {
                        answer.append(1);
                    }
                    if (!isSameParent(a, b)) {
                        answer.append(0);
                    }
                }
            }

            System.out.println("#" + testCase + " " + answer);
        }
    }

    private static void setParent(int n) {
        parent = new int[n + 1];
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

    private static boolean isSameParent(int a, int b) {
        return find(a) == find(b);
    }
}
