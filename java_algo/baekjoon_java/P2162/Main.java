package baekjoon_java.P2162;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Line[] lines = new Line[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            lines[i] = new Line(s);
            parent[i] = i;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                if (isCross(lines[i], lines[j])) {
                    union(i, j);
                }
            }
        }

        Map<Integer, Integer> unionMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            find(i);
            unionMap.put(parent[i], unionMap.getOrDefault(parent[i], 0) + 1);
        }

        System.out.println(unionMap.keySet().size());
        System.out.println(unionMap.values().stream().mapToInt(o1 -> o1).max().orElseThrow());
    }

    private static boolean isCross(Line line1, Line line2) {

        if (ccw(line1.x1, line1.y1, line1.x2, line1.y2, line2.x1, line2.y1) * ccw(line1.x1, line1.y1, line1.x2, line1.y2, line2.x2, line2.y2) <= 0
                && ccw(line2.x1, line2.y1, line2.x2, line2.y2, line1.x1, line1.y1) * ccw(line2.x1, line2.y1, line2.x2, line2.y2, line1.x2, line1.y2) <= 0) {
            if ((line1.x1 > line2.x1 && line1.x1 > line2.x2 && line1.x2 > line2.x1 && line1.x2 > line2.x2) || (line2.x1 > line1.x1 && line2.x1 > line1.x2 && line2.x2 > line1.x1 && line2.x2 > line1.x2)) {
                return false;
            }
            if ((line1.y1 > line2.y1 && line1.y1 > line2.y2 && line1.y2 > line2.y1 && line1.y2 > line2.y2) || (line2.y1 > line1.y1 && line2.y1 > line1.y2 && line2.y2 > line1.y1 && line2.y2 > line1.y2)) {
                return false;
            }
            return true;
        }

        return false;
    }

    private static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        long result = (long) x1 * y2 + (long) x2 * y3 + (long) x3 * y1 - (long) y1 * x2 - (long) y2 * x3 - (long) y3 * x1;
        if (result > 0) {
            return 1;
        }
        if (result < 0) {
            return -1;
        }
        return 0;
    }

    private static int find(int n1) {
        if (n1 == parent[n1]) {
            return n1;
        }
        return parent[n1] = find(parent[n1]);
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

    private static boolean isSameParent(int n1, int n2) {
        return find(n1) == find(n2);
    }

    static class Line {
        int x1;
        int y1;
        int x2;
        int y2;

        public Line(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public Line(String[] strings) {
            this.x1 = Integer.parseInt(strings[0]);
            this.y1 = Integer.parseInt(strings[1]);
            this.x2 = Integer.parseInt(strings[2]);
            this.y2 = Integer.parseInt(strings[3]);
        }
    }

}
