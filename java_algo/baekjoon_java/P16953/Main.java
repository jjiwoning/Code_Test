package baekjoon_java.P16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int wanted;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        wanted = nums[1];
        answer = Integer.MAX_VALUE;
        bfs(nums[0]);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void bfs(int start) {
        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{start, 1});
        while (!queue.isEmpty()) {
            long[] now = queue.poll();
            if (now[0] == wanted) {
                answer = Math.min(answer, (int)now[1]);
                continue;
            }
            if (now[0] > wanted) {
                continue;
            }
            if (now[1] > answer) {
                continue;
            }
            queue.add(new long[]{now[0] * 2, now[1] + 1});
            queue.add(new long[]{now[0] * 10 + 1, now[1] + 1});
        }
    }
}
