package baekjoon_java.P4386;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    static List<double[]> edgeList;
    static List<Node> listSortingByX;
    static List<Node> listSortingByY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        parent = new int[n];
        edgeList = new ArrayList<>();
        listSortingByX = new ArrayList<>();
        listSortingByY = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Node node = new Node(i, Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
            listSortingByY.add(node);
            listSortingByX.add(node);
            parent[i] = i;
        }

        listSortingByX.sort((o1, o2) -> (int) (o1.x - o2.x));
        listSortingByY.sort((o1, o2) -> (int) (o1.y - o2.y));

        for (int i = 0; i < n - 1; i++) {
            Node node1 = listSortingByX.get(i);
            Node node2 = listSortingByX.get(i + 1);
            Node node3 = listSortingByY.get(i);
            Node node4 = listSortingByY.get(i + 1);

            edgeList.add(new double[]{node1.number, node2.number, getDistance(node1, node2)});
            edgeList.add(new double[]{node3.number, node4.number, getDistance(node3, node4)});
        }

        edgeList.sort((o1, o2) -> (int) (o1[2] - o2[2]));

        double answer = 0;

        for (double[] now : edgeList) {
            if (!isSameParent((int) now[0], (int) now[1])) {
                union((int) now[0], (int) now[1]);
                answer += now[2];
            }
        }

        System.out.println(answer);
    }

    static double getDistance(Node node1, Node node2) {
        return Math.sqrt(Math.pow(node1.x - node2.x, 2) + Math.pow(node1.y - node2.y, 2));
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

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            }

            if (x > y) {
                parent[x] = y;
            }
        }
    }

    private static boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }

    static class Node {
        int number;
        double x;
        double y;

        public Node(int number, double x, double y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }
    }

}
