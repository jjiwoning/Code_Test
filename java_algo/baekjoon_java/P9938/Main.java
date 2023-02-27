package baekjoon_java.P9938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        parent = new int[l + 1];
        visited = new boolean[l + 1];

        for (int i = 1; i < l + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());

            if (!visited[a1]) {
                System.out.println("LADICA");
                visited[a1] = true;
                union(a1, a2);
                continue;
            }

            if (!visited[a2]) {
                System.out.println("LADICA");
                visited[a2] = true;
                union(a2, a1);
                continue;
            }

            if (!visited[find(a1)]) {
                System.out.println("LADICA");
                visited[find(a1)] = true;
                union(find(a1), a2);
                continue;
            }

            if (!visited[find(a2)]) {
                System.out.println("LADICA");
                visited[find(a2)] = true;
                union(find(a2), a1);
                continue;
            }

            System.out.println("SMECE");
        }
    }

    private static void union(int a1, int a2) {
        a1 = find(a1);
        a2 = find(a2);

        if (a1 != a2) {
            parent[a1] = a2;
        }
    }

    private static int find(int a1) {
        if (a1 == parent[a1]) {
            return a1;
        }
        return parent[a1] = find(parent[a1]);
    }
}
