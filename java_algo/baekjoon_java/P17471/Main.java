package baekjoon_java.P17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;
import static java.lang.Math.*;

public class Main {

    static int n;
    static int answer;
    static int totalCost;
    static int[] costs;
    static boolean[] visited;
    static boolean[] validVisited;
    static List<List<Integer>> lists;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = parseInt(br.readLine());

        costs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        totalCost = Arrays.stream(costs).sum();
        answer = MAX_VALUE;
        lists = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int m = parseInt(st.nextToken());

            for (int j = 0; j < m; j++) {
                lists.get(i).add(parseInt(st.nextToken()) - 1);
            }
        }

        for (int i = 0; i <= n / 2; i++) {
            visited = new boolean[n];
            findSubSet(i, 0, 0);
        }

        System.out.println(getAnswer());
    }

    private static void findSubSet(int wantedCount, int depth, int index) {
        if (depth == wantedCount) {
            if (validSubSet()) {
                findSub();
            }
            return;
        }

        if (index == n) {
            return;
        }

        visited[index] = true;
        findSubSet(wantedCount, depth + 1, index + 1);
        visited[index] = false;
        findSubSet(wantedCount, depth, index + 1);
    }

    private static boolean validSubSet() {
        validVisited = new boolean[n];

        int trueStart = -1;
        int falseStart = -1;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                trueStart = i;
            }
            if (!visited[i]) {
                falseStart = i;
            }
        }

        if (trueStart == -1 || falseStart == -1) {
            return false;
        }

        validVisited[trueStart] = true;
        validDfs(trueStart, true);
        validVisited[falseStart] = true;
        validDfs(falseStart, false);

        for (boolean b : validVisited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private static void validDfs(int start, boolean type) {
        for (Integer next : lists.get(start)) {
            if (visited[next] == type && !validVisited[next]) {
                validVisited[next] = true;
                validDfs(next, type);
            }
        }
    }

    private static void findSub() {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sum += costs[i];
            }
        }

        answer = min(answer, abs(2 * sum - totalCost));
    }

    private static int getAnswer() {
        if (answer == MAX_VALUE) {
            return -1;
        }
        return answer;
    }

}
