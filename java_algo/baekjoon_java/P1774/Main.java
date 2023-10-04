package baekjoon_java.P1774;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        List<Space> spaces = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            parent[i] = i;
            spaces.add(new Space(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int space1 = Integer.parseInt(st.nextToken());
            int space2 = Integer.parseInt(st.nextToken());

            union(space1, space2);
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(o -> o.cost));

        for (int i = 0; i < spaces.size(); i++) {
            for (int j = i + 1; j < spaces.size(); j++) {
                Space space1 = spaces.get(i);
                Space space2 = spaces.get(j);
                priorityQueue.add(new Node(space1.number, space2.number, getDistance(space1.x, space1.y, space2.x, space2.y)));
            }
        }

        double answer = 0;

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            if (!isSameParent(node.start, node.end)) {
                union(node.start, node.end);
                answer += node.cost;
            }
        }

        System.out.printf("%.2f%n", answer);
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        }

        if (x > y) {
            parent[x] = y;
        }
    }

    private static boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }

    private static double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}

class Space {
    int number;
    int x;
    int y;

    public Space(int number, int x, int y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }
}

class Node {
    int start;
    int end;
    double cost;

    public Node(int start, int end, double cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}
