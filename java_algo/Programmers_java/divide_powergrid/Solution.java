package Programmers_java.divide_powergrid;

/**
 * 프로그래머스 - 전력망을 둘로 나누기
 */
public class Solution {

    int count;
    boolean[] checked;
    int[][] graph;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        graph = new int[n + 1][n + 1];

        for (int i = 0; i < wires.length; i++) {
            graph[wires[i][0]][wires[i][1]] = 1;
            graph[wires[i][1]][wires[i][0]] = 1;
        }

        for (int i = 0; i < wires.length; i++) {
            checked = new boolean[n + 1];

            int x = wires[i][0];
            int y = wires[i][1];

            graph[x][y] = 0;
            graph[y][x] = 0;
            count = 0;

            for (int j = 1; j <= n; j++) {
                if (dfs(j, n)) {
                    answer = Math.min(answer, Math.abs(n - count - count));
                    break;
                }
            }

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        return answer;
    }

    private boolean dfs(int num, int n) {
        if (!checked[num]) {
            checked[num] = true;
            count++;
            for (int i = 1; i <= n; i++) {
                if (graph[num][i] == 1) {
                    dfs(i, n);
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}});
    }
}
