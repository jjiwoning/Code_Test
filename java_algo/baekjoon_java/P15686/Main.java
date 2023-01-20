package baekjoon_java.P15686;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<int[]> homes;
    static List<int[]> chickens;
    static int m;
    static boolean[] checked;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        m = sc.nextInt();

        homes = new ArrayList<>();
        chickens = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int now = sc.nextInt();
                if (now == 1) {
                    homes.add(new int[]{i, j});
                }
                if (now == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        checked = new boolean[chickens.size()];

        answer = Integer.MAX_VALUE;

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int level, int index) {
        if (level == m) {
            int count = 0;
            for (int[] home : homes) {
                int minVal = Integer.MAX_VALUE;
                for (int i = 0; i < chickens.size(); i++) {
                    if (!checked[i]) {
                        continue;
                    }
                    int find = Math.abs(home[0] - chickens.get(i)[0]) + Math.abs(home[1] - chickens.get(i)[1]);
                    if (find < minVal) {
                        minVal = find;
                    }
                }
                count += minVal;
            }
            if (answer > count) {
                answer = count;
            }
            return;
        }

        if (index >= chickens.size()) {
            return;
        }

        checked[index] = true;
        dfs(level + 1, index + 1);
        checked[index] = false;
        dfs(level, index + 1);
    }
}
