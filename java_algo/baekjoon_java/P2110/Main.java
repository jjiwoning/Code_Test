package baekjoon_java.P2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int answer = binarySearch(c, arr);

        System.out.println(answer);
    }

    private static int binarySearch(int c, int[] arr) {
        int start = 1;
        int end = arr[arr.length - 1] - arr[0] + 1;

        while (start < end) {
            int mid = (start + end) / 2;

            if (canSetRouter(c, arr, mid)) {
                start = mid + 1;
                continue;
            }

            end = mid;
        }

        return end - 1;
    }

    private static boolean canSetRouter(int c, int[] arr, int distance) {
        int start = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - start >= distance) {
                count++;
                start = arr[i];
            }
        }

        return count >= c;
    }
}
