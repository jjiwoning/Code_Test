package baekjoon_java.P16927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.min;

public class Main {

    static int n;
    static int m;
    static int[][] arr;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input1[0];
        m = input1[1];
        int rotateCount = input1[2];

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            int[] input2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input2[j];
            }
        }

        int cycle = min(n, m) / 2;
        int[] rotateNeed = new int[cycle];

        for (int i = 0; i < rotateNeed.length; i++) {
            rotateNeed[i] = rotateCount % (2 * (n + m - 4 * i) - 4);
        }

        for (int i = 0; i < rotateNeed.length; i++) {
            rotate(i, rotateNeed[i]);
        }

        for (int[] ints : arr) {
            Arrays.stream(ints).forEach(o1 -> System.out.print(o1 + " "));
            System.out.println();
        }

    }

    private static void rotate(int cycle, int rotateNeed) {
        int startX = cycle;
        int startY = cycle;
        Queue<Integer> queue = new LinkedList<>();

        for (int j = 0; j < 4; j++) {
            while (true) {
                int mx = startX + dx[j];
                int my = startY + dy[j];
                if (mx < cycle || mx >= n - cycle || my < cycle || my >= m - cycle) {
                    break;
                }
                queue.add(arr[mx][my]);
                startX = mx;
                startY = my;
            }
        }

        for (int i = 0; i < rotateNeed; i++) {
            queue.add(queue.poll());
        }

        startX = cycle;
        startY = cycle;

        for (int j = 0; j < 4; j++) {
            while (true) {
                int mx = startX + dx[j];
                int my = startY + dy[j];
                if (mx < cycle || mx >= n - cycle || my < cycle || my >= m - cycle) {
                    break;
                }
                arr[mx][my] = queue.poll();
                startX = mx;
                startY = my;
            }
        }
    }

}
