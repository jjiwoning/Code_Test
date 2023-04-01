package baekjoon_java.P12015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] lis = new int[n];

        int nowIndex = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > lis[Math.max(0, nowIndex - 1)]) {
                lis[nowIndex++] = arr[i];
                continue;
            }
            int findIndex = binarySearch(arr[i], lis, nowIndex);
            lis[findIndex] = arr[i];
        }
        System.out.println(nowIndex);
    }

    private static int binarySearch(int target, int[] lis, int endPoint) {
        int start = 0;
        while (start < endPoint) {
            int mid = (start + endPoint) / 2;
            if (lis[mid] < target) {
                start = mid + 1;
                continue;
            }
            if (lis[mid] >= target) {
                endPoint = mid;
            }
        }

        return endPoint;
    }

}
