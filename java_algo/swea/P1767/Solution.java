package swea.P1767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    static int n;
    static List<Core> coreList;
    static int[][] processorInfo;
    static boolean[][] visited;
    static int answer;
    static int selectedProcessorCount;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int testCase = 1; testCase <= t; testCase++) {

            n = Integer.parseInt(br.readLine());

            processorInfo = new int[n][n];
            visited = new boolean[n][n];
            answer = Integer.MAX_VALUE;
            selectedProcessorCount = -1;
            coreList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                processorInfo[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < n; j++) {
                    if (processorInfo[i][j] == 1) {
                        if (i == 0 || j == 0 || i == n -1 || j == n - 1) {
                            continue;
                        }
                        coreList.add(new Core(i, j));
                    }
                }
            }

            dfs(0, 0, 0);
            output.append("#").append(testCase).append(" ").append(answer).append("\n");
        }

        System.out.println(output);
    }

    private static void dfs(int depth, int count, int coreSelectCount) {
        if (depth == coreList.size()) {
            if (coreSelectCount > selectedProcessorCount) {
                selectedProcessorCount = coreSelectCount;
                answer = count;
                return;
            }
            if (coreSelectCount == selectedProcessorCount) {
                answer = Math.min(count, answer);
            }
            return;
        }

        for (int j = 0; j < 4; j++) {
            int findCount = getCount(coreList.get(depth), j);
            if (findCount != 0) {
                dfs(depth + 1, count + findCount, coreSelectCount + 1);
                deleteVisited(coreList.get(depth), j, findCount);
            } else {
                dfs(depth + 1, count, coreSelectCount);
            }
        }

    }

    private static int getCount(Core core, int j) {
        int count = 0;
        int x = core.x;
        int y = core.y;

        while (true) {
            x += dx[j];
            y += dy[j];

            if (x < 0 || y < 0 || x >= n || y >= n) {
                break;
            }

            if (visited[x][y] || processorInfo[x][y] == 1) {
                deleteVisited(core, j, count);
                return 0;
            }

            visited[x][y] = true;
            count++;
        }

        return count;
    }

    private static void deleteVisited(Core core, int direction, int findCount) {
        int x = core.x;
        int y = core.y;

        for (int i = 0; i < findCount; i++) {
            x += dx[direction];
            y += dy[direction];

            visited[x][y] = false;
        }
    }

    private static class Core {
        int x;
        int y;

        public Core(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
