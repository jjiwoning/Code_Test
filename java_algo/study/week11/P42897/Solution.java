package study.week11.P42897;

/**
 * 프로그래머스 - 도둑질
 */
public class Solution {
    public int solution(int[] money) {

        int[] dp1 = new int[money.length]; // 첫 집을 터는 경우의 dp 배열
        int[] dp2 = new int[money.length]; // 첫 집을 털지 않는 경우의 dp 배열

        dp1[0] = money[0]; // 첫 집을 턴다.
        dp1[1] = money[0]; // 다음 집은 못 터니 그대로 간다.

        dp2[1] = money[1]; // 두 번째 집을 턴다.

        for (int i = 2; i < money.length; i++) {
            // 첫 번째를 고른다. -> 마지막을 못 고름
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
            // 두 번째를 고른다. -> 마지막 고를 수 있음
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }

        return Math.max(dp1[money.length - 2], dp2[money.length - 1]);
    }
}
