package study.week3.P1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.util.Comparator.*;

public class Main {

    static int finalWeight;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] arr = new int[m][3];
        finalWeight = 0;
        parent = new int[n + 1];
        parent[0] = -1;
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            arr[i] = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        }

        Arrays.sort(arr, comparingInt(o -> o[2]));

        // 크루스칼 알고리즘 사용
        for (int i = 0; i < m; i++) {
            if (!isSameParent(arr[i][0], arr[i][1])) { // 연결이 안 돼있는 경우
                union(arr[i][0], arr[i][1]); // 둘이 연결
                finalWeight += arr[i][2]; // 코스트 순서로 정렬을 했기 때문에 바로 더해줘도 된다.
            }
            find(arr[i][0]); // 갱신
            find(arr[i][1]); // 갱신
        }

        System.out.println(finalWeight); // 최종 가중치 출력
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
