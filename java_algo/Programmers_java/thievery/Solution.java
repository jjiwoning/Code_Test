package Programmers_java.thievery;

public class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int[] dp1 = new int[money.length];
        int[] dp2 = new int[money.length];

        dp1[0] = money[0];
        dp1[1] = money[0];
        dp2[1] = money[1];

        // 첫 번째를 고른다. -> 마지막을 못 고름
        for (int i = 2; i < money.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
        }

        // 두 번째를 고른다. -> 마지막 고를 수 있음
        for (int i = 2; i < money.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }

        answer = Math.max(dp1[money.length - 2], dp2[money.length - 1]);

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[]{1, 2, 3, 1});
        System.out.println(solution);
    }
}
