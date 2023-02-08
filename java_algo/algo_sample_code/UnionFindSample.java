package algo_sample_code;

public class UnionFindSample {

    private static int[] parent;

    public static void main(String[] args) {
        parent = new int[8];
        for (int i = 0; i < 8; i++) {
            parent[i] = i;
        }

        union(0, 3);
        union(0, 1);

        System.out.println(isSameParent(1, 3));
    }

    private static int find(int num) {
        if (num == parent[num]) {
            return num;
        }
        return parent[num] = find(parent[num]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            // 부모가 다른 경우
            // x, y 중 더 작은 값을 부모로 두어야 한다.
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
