package swea.P2383;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static Set<int[]> stairsSet1;
    static Set<int[]> stairsSet2;
    static List<int[]> personList;
    static List<int[]> outList;
    static int[][] roomInfo;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder output = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase < t + 1; testCase++) {
            int n = Integer.parseInt(br.readLine());

            roomInfo = new int[n][n];
            personList = new ArrayList<>();
            outList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) {
                        personList.add(new int[]{i, j});
                    }
                    if (num > 1) {
                        outList.add(new int[]{i, j, num});
                    }
                }
            }

            answer = Integer.MAX_VALUE;
            stairsSet1 = new HashSet<>();
            stairsSet2 = new HashSet<>();
            combination(0);

            output.append("#").append(testCase).append(" ").append(answer).append("\n");
        }

        System.out.println(output);
    }

    private static void combination(int depth) {
        if (depth == personList.size()) {
            getTotalTime();
            return;
        }

        int[] nowPerson = personList.get(depth);
        int[] stair1 = outList.get(0);
        int[] stair2 = outList.get(1);

        int[] nowPersonMoveStair1 =
                new int[]{nowPerson[0], nowPerson[1], Math.abs(nowPerson[0] - stair1[0]) + Math.abs(nowPerson[1] - stair1[1])};
        int[] nowPersonMoveStair2 =
                new int[]{nowPerson[0], nowPerson[1], Math.abs(nowPerson[0] - stair2[0]) + Math.abs(nowPerson[1] - stair2[1])};

        stairsSet1.add(nowPersonMoveStair1);
        combination(depth + 1);
        stairsSet1.remove(nowPersonMoveStair1);

        stairsSet2.add(nowPersonMoveStair2);
        combination(depth + 1);
        stairsSet2.remove(nowPersonMoveStair2);
    }

    private static void getTotalTime() {
        // 계단 최대 3명
        List<int[]> stairList1 = new ArrayList<>(stairsSet1);
        List<int[]> stairList2 = new ArrayList<>(stairsSet2);

        stairList1.sort((o1, o2) -> o1[2] - o2[2]);
        stairList2.sort((o1, o2) -> o1[2] - o2[2]);

        int totalTime = 0;

        if (!stairList1.isEmpty()) {
            int find1 = getStairTime(stairList1, 0);
            totalTime = find1;
        }

        if (!stairList2.isEmpty()) {
            int find2 = getStairTime(stairList2, 1);
            totalTime = Math.max(totalTime, find2);
        }

        if (totalTime == 0) {
            return;
        }
        answer = Math.min(totalTime, answer);
    }

    private static int getStairTime(List<int[]> stairList, int type) {
        if (stairList.size() <= 3) {
            int[] lastPerson = stairList.get(stairList.size() - 1);
            return lastPerson[2] + outList.get(type)[2] + 1;
        }

        int time = 0;
        int[] stairQueue = new int[3];
        int index = 0;

        while (true) {
            if (index == stairList.size()) {
                int lastTime = 0;
                for (int i = 0; i < 3; i++) {
                    if (stairQueue[i] != 0) {
                        lastTime = Math.max(lastTime, stairQueue[i]);
                    }
                }
                time += lastTime;
                break;
            }

            for (int i = 0; i < 3; i++) {
                if (stairQueue[i] == 0 && index < stairList.size() && stairList.get(index)[2] <= time) {
                    index++;
                    stairQueue[i] = outList.get(type)[2];
                    continue;
                }

                if (stairQueue[i] > 0) {
                    stairQueue[i]--;
                    if (stairQueue[i] == 0 && index < stairList.size() && stairList.get(index)[2] <= time) {
                        index++;
                        stairQueue[i] = outList.get(type)[2];
                    }
                }
            }

            time++;
        }

        return time;
    }
}
