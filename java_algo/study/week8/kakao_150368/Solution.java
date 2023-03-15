package study.week8.kakao_150368;

/**
 * 2023 KAKAO BLIND RECRUITMENT - 이모티콘 할인행사
 */
public class Solution {

    int[] answer;
    int[] discounts;
    int[] percent = new int[]{10, 20, 30, 40};

    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[]{0, 0};
        discounts = new int[emoticons.length];

        setDiscount(0, users, emoticons);

        return answer;
    }

    private void setDiscount(int index, int[][] users, int[] emoticons) {
        if (index == discounts.length) {
            findAnswer(users, emoticons);
            return;
        }

        for (int i = 0; i < 4; i++) {
            discounts[index] = percent[i];
            setDiscount(index + 1, users, emoticons);
            discounts[index] = 0;
        }
    }

    private void findAnswer(int[][] users, int[] emoticons) {
        int[] result = new int[]{0, 0};

        for (int[] user : users) {
            int moneySum = 0;
            for (int i = 0; i < discounts.length; i++) {
                if (discounts[i] >= user[0]) {
                    moneySum += getDiscountMoney(discounts[i], emoticons[i]);
                }
            }
            if (moneySum >= user[1]) {
                result[0]++;
            }
            if (moneySum < user[1]) {
                result[1] += moneySum;
            }
        }

        compareAnswer(result);
    }

    private int getDiscountMoney(int discount, int money) {
        return money * (100 - discount) / 100;
    }

    private void compareAnswer(int[] result) {
        if (result[0] > answer[0]) {
            answer = result;
            return;
        }

        if (result[0] == answer[0] && result[1] > answer[1]) {
            answer[1] = result[1];
        }
    }
}
