package Programmers_java.collect_stickers;

/**
 * 프로그래머스 - 스티커 모으기(2)
 */
public class Solution {
    public int solution(int[] sticker) {

        if (sticker.length == 1) {
            return sticker[0];
        }

        // 경우의 수
        // 1. 첫 스티커를 고르는 경우 -> 마지막 스티커는 고를 수 없음
        // 2. 두 번째 스티커를 고르는 경우 -> 마지막 스티커 고를 수 있음
        // 점화식
        // dp[i] = max(dp[i - 1], dp[i - 2] + sticker[i]) -> 이전 스티커를 골라 지금 스티커를 안고르는 경우 또는 지금 스티커를 고르는 경우

        int[] dp1 = new int[sticker.length]; // 첫 스티커 고르기
        int[] dp2 = new int[sticker.length]; // 두 번째 스티커 고르기
        
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];

        for (int i = 2; i < sticker.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }
        
        dp2[0] = 0;
        dp2[1] = sticker[1];

        for (int i = 2; i < sticker.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        return Math.max(dp1[sticker.length - 2], dp2[sticker.length - 1]);
    }
}
