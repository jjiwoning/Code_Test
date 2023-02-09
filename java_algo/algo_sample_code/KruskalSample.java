package algo_sample_code;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Comparator.*;

public class KruskalSample {
    static int v, e;
    static int[][] graph;
    static int[] parent; // 각 노드의 부모
    static int final_cost; // 최종적으로 연결된 최소 신장 트리 연결 비용

    public static void main(String[] args) {
        // 그래프의 연결상태(노드1, 노드2, 비용)를 초기화.
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();
        graph = new int[e][3];

        for (int i = 0; i < e; i++) {
            graph[i][0] = sc.nextInt();
            graph[i][1] = sc.nextInt();
            graph[i][2] = sc.nextInt();
        }
        parent = new int[v];
        final_cost = 0;

        // 간선 비용 순으로 오름차순 정렬
        Arrays.sort(graph, comparingInt(o -> o[2]));

        // makeSet
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }

        // 낮은 비용부터 크루스칼 알고리즘 진행
        for (int i = 0; i < e; i++) {
            // 사이클이 존재하지 않는 경우에만 간선을 선택한다(여기서는 최종 비용만 고려하도록 하겠다).
            if (find(graph[i][0] - 1) != find(graph[i][1] - 1)) {
                System.out.println(Arrays.toString(graph[i]));
                union(graph[i][0] - 1, graph[i][1] - 1);
                final_cost += graph[i][2];
                System.out.println(Arrays.toString(parent));
            }
        }

        System.out.println("최종 비용 : " + final_cost);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
