package baekjoon_java.P2887;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Main {

    static int n;
    static int[] parent;
    static long answer;
    static List<Node> listSortingByX;
    static List<Node> listSortingByY;
    static List<Node> listSortingByZ;
    static List<int[]> edgeList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        parent = new int[n];
        answer = 0;

        listSortingByX = new ArrayList<>(); // 좌표 별로 정렬
        listSortingByY = new ArrayList<>();
        listSortingByZ = new ArrayList<>();
        edgeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] distanceInfo = br.readLine().split(" ");
            int x = Integer.parseInt(distanceInfo[0]);
            int y = Integer.parseInt(distanceInfo[1]);
            int z = Integer.parseInt(distanceInfo[2]);
            Node node = new Node(i, x, y, z);
            listSortingByX.add(node);
            listSortingByY.add(node);
            listSortingByZ.add(node);
            parent[i] = i;
        }

        // 각 좌표별로 정렬을 수행한다.
        listSortingByX.sort(Comparator.comparingInt(o -> o.x));
        listSortingByY.sort(Comparator.comparingInt(o -> o.y));
        listSortingByZ.sort(Comparator.comparingInt(o -> o.z));

        for (int i = 0; i < n - 1; i++) {
            // 바로 옆에 있는 노드가 한 축을 기준으로 가장 근접한 노드이다.
            Node nodeX1 = listSortingByX.get(i);
            Node nodeX2 = listSortingByX.get(i + 1);
            Node nodeY1 = listSortingByY.get(i);
            Node nodeY2 = listSortingByY.get(i + 1);
            Node nodeZ1 = listSortingByZ.get(i);
            Node nodeZ2 = listSortingByZ.get(i + 1);

            /*
            해당 경우의 edge만 판단해도 되는 이유
            문제에서 원하는 가중치는 min(|xA-xB|, |yA-yB|, |zA-zB|)
            -> 각 행성의 좌표 별로 x, y, z 각각의 가장 근처에 있는 행성들만 고려하면 된다.
            -> x를 기준으로 생각해보면 1, 3, 7, 10이 있다고 할 때 우리가 고려해야되는 간선은 1 -> 3, 3 -> 7, 7 -> 10이지 절대로 1 -> 10을 고려할 이유가 없다.
            이를 바탕으로 정답이 될 가능성이 있는 간선들(특정 좌표에서 가장 근처에 있는 좌표)만을 찾아서 edgeList에 값을 넣어주면 된다.
             */

            edgeList.add(new int[]{nodeX1.number, nodeX2.number, abs(nodeX1.x - nodeX2.x)});
            edgeList.add(new int[]{nodeY1.number, nodeY2.number, abs(nodeY1.y - nodeY2.y)});
            edgeList.add(new int[]{nodeZ1.number, nodeZ2.number, abs(nodeZ1.z - nodeZ2.z)});
        }

        edgeList.sort(Comparator.comparingInt(o -> o[2]));

        for (int i = 0; i < edgeList.size(); i++) {
            int[] now = edgeList.get(i);
            if (!isSameParent(now[0], now[1])) {
                union(now[0], now[1]);
                answer += now[2];
            }
        }

        System.out.println(answer);
    }

    static class Node {

        int number;

        int x;
        int y;
        int z;

        public Node(int number, int x, int y, int z) {
            this.number = number;
            this.x = x;
            this.y = y;
            this.z = z;
        }
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
}
