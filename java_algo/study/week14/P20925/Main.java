package study.week14.P20925;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] mapInfo = new int[n][2]; // 사냥터 정보
        int[][] dp = new int[n][t + 1]; // dp 배열
        int[][] movingTimeInfo = new int[n][n]; // 다른 사냥터 이동하는데 걸리는 시간 정보

        // 사냥터 정보 -> 0: 경험치 제한, 1: 1분 사냥 당 경험치
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            mapInfo[i][0] = Integer.parseInt(st.nextToken());
            mapInfo[i][1] = Integer.parseInt(st.nextToken());
        }

        // 다른 사냥터 이동 시간 초기화
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                movingTimeInfo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= t; i++) {
            // 기준 사냥터
            for (int j = 0; j < n; j++) {
                if (mapInfo[j][0] <= dp[j][i - 1]) { // 사냥터 입장 조건을 만족해야됨
                    dp[j][i] = Math.max(dp[j][i], dp[j][i - 1] + mapInfo[j][1]);
                }
                // 나를 제외한 다른 사냥터
                for (int k = 0; k < n; k++) {
                    int moveTime = movingTimeInfo[k][j]; // 이동 시간
                    if (i - moveTime > 0 && dp[k][i - moveTime] >= mapInfo[j][0]) { // 이전 사냥터에서 모은 경험치가 현재 사냥터 입장 조건을 만족 해야됨
                        dp[j][i] = Math.max(dp[j][i], dp[k][i - moveTime]); // 이동하는데 소요한 시간이니 더해주지 않기
                    }
                }
            }
        }

        int answer = -1; // 마지막 t를 기점으로 최대값 찾기
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[i][t]);
        }
        System.out.println(answer);
    }
}
