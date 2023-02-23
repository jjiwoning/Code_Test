package swea.P5644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.*;

public class Solution {

    static int[] dx = new int[]{0, -1, 0, 1, 0};
    static int[] dy = new int[]{0, 0, 1, 0, -1};
    static int[] person1Move;
    static int[] person2Move;
    static int[][][] map;
    static Map<Integer, BatteryCharger> batteryChargerMap;
    static Queue<int[]> queue;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            person1Move = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            person2Move = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            map = new int[10][10][a];
            batteryChargerMap = new HashMap<>();

            for (int i = 1; i <= a; i++) {
                setBatteryCharger(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(), i);
            }

            queue = new LinkedList<>();
            queue.add(new int[]{0, 0});
            queue.add(new int[]{9, 9});

            answer = 0;

            bfs(m);

            System.out.println("#" + testCase + " " + answer);
        }
    }

    private static void setBatteryCharger(int[] input, int type) {
        int x = input[1] - 1;
        int y = input[0] - 1;
        int c = input[2];
        int power = input[3];

        BatteryCharger batteryCharger = new BatteryCharger(type, power);

        batteryChargerMap.put(type, batteryCharger);

        fillMap(x, y, type);

        for (int i = 1; i <= c; i++) {
            fillMap(x + i, y, type);
            fillMap(x - i, y, type);
            fillMap(x, y + i, type);
            fillMap(x, y - i, type);
        }

        for (int i = 1; i <= c - 1; i++) {
            for (int j = c - i; j >= 1; j--) {
                fillMap(x + i, y + j, type);
                fillMap(x + i, y - j, type);
                fillMap(x - i, y + j, type);
                fillMap(x - i, y - j, type);
            }
        }
    }

    private static void fillMap(int x, int y, int type) {

        if (x < 0 || x >= 10 || y < 0 || y >= 10) {
            return;
        }

        for (int i = 0; i < map[0][0].length; i++) {
            if (map[x][y][i] == 0) {
                map[x][y][i] = type;
                return;
            }
        }
    }

    private static void bfs(int m) {

        int count = -1;

        while (!queue.isEmpty()) {
            int[] person1 = queue.poll();
            int[] person2 = queue.poll();

            int[] person1Battery = map[person1[0]][person1[1]];
            int[] person2Battery = map[person2[0]][person2[1]];

            answer += findMaxBatteryPower(person1Battery, person2Battery);

            count++;

            if (count == m) {
                return;
            }

            queue.add(new int[]{person1[0] + dx[person1Move[count]], person1[1] + dy[person1Move[count]]});
            queue.add(new int[]{person2[0] + dx[person2Move[count]], person2[1] + dy[person2Move[count]]});
        }
    }

    private static int findMaxBatteryPower(int[] person1Battery, int[] person2Battery) {
        if (hasBatteryCharger(person1Battery) && hasBatteryCharger(person2Battery)) {
            return twoBatteryPowerSum(person1Battery, person2Battery);
        }
        if (hasBatteryCharger(person1Battery) && !hasBatteryCharger(person2Battery)) {
            return oneBatteryPowerSum(person1Battery);
        }
        if (!hasBatteryCharger(person1Battery) && hasBatteryCharger(person2Battery)) {
            return oneBatteryPowerSum(person2Battery);
        }
        return 0;
    }

    private static int twoBatteryPowerSum(int[] person1Battery, int[] person2Battery) {
        int batteryPower = 0;

        for (int person1 : person1Battery) {
            if (person1 == 0) {
                continue;
            }
            for (int person2 : person2Battery) {
                if (person2 == 0) {
                    continue;
                }
                if (person1 == person2) {
                    batteryPower = max(batteryPower, batteryChargerMap.get(person1).power);
                    continue;
                }
                batteryPower = max(batteryPower, batteryChargerMap.get(person1).power + batteryChargerMap.get(person2).power);
            }
        }

        return batteryPower;
    }

    private static int oneBatteryPowerSum(int[] personBattery) {
        int batteryPower = 0;
        for (int i : personBattery) {
            if (i == 0) {
                return batteryPower;
            }
            batteryPower = max(batteryPower, batteryChargerMap.get(i).power);
        }
        return batteryPower;
    }

    private static boolean hasBatteryCharger(int[] batteryInfo) {
        for (int battery : batteryInfo) {
            if (battery != 0) {
                return true;
            }
        }
        return false;
    }

    private static class BatteryCharger {
        int type;
        int power;

        public BatteryCharger(int type, int power) {
            this.type = type;
            this.power = power;
        }
    }
}
