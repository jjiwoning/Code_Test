package study.week6.P15961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k - 1; i++) {
            map.put(arr[n - 1 - i], map.getOrDefault(arr[n - 1 - i], 0) + 1);
        }
        map.put(arr[0], map.getOrDefault(arr[0], 0) + 1);

        int start = n - k + 1;

        int answer = sushiCount(map, c);

        for (int end = 1; end < n; end++) {
            if (start == n) {
                start = 0;
            }

            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
            map.put(arr[start], map.get(arr[start]) - 1);

            if (map.get(arr[start]) == 0) {
                map.remove(arr[start]);
            }

            start++;

            answer = Math.max(answer, sushiCount(map, c));
        }

        System.out.println(answer);
    }

    private static int sushiCount(Map<Integer, Integer> map, int c) {
        int count = map.keySet().size();
        if (!map.containsKey(c)) {
            count++;
        }
        return count;
    }

}
