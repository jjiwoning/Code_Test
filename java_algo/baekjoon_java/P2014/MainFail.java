package baekjoon_java.P2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MainFail {

    static int n;
    static int[] arr;
    static PriorityQueue<Integer> priorityQueue;
    static Set<Integer> set;
    static int wantedIndex;
    static int maxVal;
    static int level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        wantedIndex = Integer.parseInt(s1[1]);

        arr = new int[n];
        priorityQueue = new PriorityQueue<>();
        set = new HashSet<>();
        maxVal = 0;
        level = 0;

        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(s2[i]);
            arr[i] = num;
            priorityQueue.add(num);
            set.add(num);
        }

        bfs();

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        System.out.println(list.get(wantedIndex - 1));

    }

    private static void bfs() {

        while (!priorityQueue.isEmpty()) {
            Integer value = priorityQueue.poll();

            for (int i = 0; i < n; i++) {
                int find = value * arr[i];
                if (set.size() == wantedIndex && maxVal < find) {
                    continue;
                }
                if (set.size() == wantedIndex && maxVal > find && !set.contains(find)) {
                    set.remove(maxVal);
                    maxVal = set.stream().mapToInt(x -> x).max().orElseThrow();
                }
                maxVal = Math.max(maxVal, find);
                set.add(find);
                priorityQueue.add(find);
            }
        }
    }

}
