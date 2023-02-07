package study.week3.P14002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        int[] arr = new int[n];
        int[][] dp = new int[n][2]; // {{dp 값, 이전 dp 인덱스}}

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        // dp 배열 초기화
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
        }

        int answer = 1; // 수열의 길이가 최소 1은 보장하기 때문에 1로 초기화
        int findIndex = 0; // dp가 최대일 때 인덱스를 저장하기 위한 변수 -> 여기서부터 아래로 찾아 값을 출력하기 위함

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i][0] < dp[j][0] + 1) { // 이 경우 dp 값 조정 해야 됨
                    dp[i] = new int[]{dp[j][0] + 1, j}; // dp 값 초기화
                    if (answer < dp[i][0]) { // 현재 dp 값이 answer보다 큰 경우
                        answer = dp[i][0]; // 이 경우를 answer로 저장해야 됨
                        findIndex = i; // 해당 경우의 index를 저장
                    }
                }
            }
        }

        int[] answerArr = new int[answer];

        int idx = answer - 1;

        while (idx >= 0) {
            answerArr[idx] = arr[findIndex];
            findIndex = dp[findIndex][1];
            idx--;
        }

        System.out.println(answer);
        Arrays.stream(answerArr).forEach(o1 -> System.out.print(o1 + " "));
    }
}
