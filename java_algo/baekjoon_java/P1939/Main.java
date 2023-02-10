package baekjoon_java.P1939;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] parent;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        parent = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        int[][] arr = new int[m][3];

        for (int i = 0; i < m; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Arrays.sort(arr, (o1, o2) -> o2[2] - o1[2]);

        String[] startEnd = br.readLine().split(" ");
        int start = Integer.parseInt(startEnd[0]);
        int end = Integer.parseInt(startEnd[1]);

        answer = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            if (isSameParent(start, end)) { // 시작점과 끝점이 연결됨 -> 탈출
                break;
            }
            if (!isSameParent(arr[i][0], arr[i][1])) { // 다른 부모 -> 연결되지 않음
                union(arr[i][0], arr[i][1]); // 둘이 연결함
                answer = Math.min(answer, arr[i][2]); // 해당 값 저장
            }
        }

        System.out.println(answer);
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

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }
}
