package Programmers_java.P12977;

public class Solution {
    int[] nums;
    int answer;

    public int solution(int[] nums) {
        answer = 0;
        this.nums = nums;

        combination(0, 0, 0);

        return answer;
    }

    private void combination(int index, int check, int makeNum) {
        if (check == 3) {
            if (checkPrimeNumber(makeNum)) {
                answer++;
            }
            return;
        }

        if (index >= nums.length) {
            return;
        }

        makeNum += nums[index];
        combination(index + 1, check + 1, makeNum);
        makeNum -= nums[index];
        combination(index + 1, check, makeNum);
    }

    private boolean checkPrimeNumber(int makeNum) {
        for (int i = 2; i <= (int)Math.sqrt(makeNum); i++) {
            if (makeNum % i == 0) {
                return false;
            }
        }
        return true;
    }
}
