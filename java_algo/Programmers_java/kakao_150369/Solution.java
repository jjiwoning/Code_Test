package Programmers_java.kakao_150369;

/**
 * 카카오 기출 - 택배 배달과 수거하기
 * 일단 배송 후 회수 패턴으로 뒤에서부터 그리디 방식으로 해결
 */
public class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        while (n > 0) {
            int deliveryNeed = deliveries[n - 1];
            int pickupNeed = pickups[n - 1];
            int nowCap = cap;

            if (deliveryNeed == 0 && pickupNeed == 0) {
                n--;
                continue;
            }

            if (deliveryNeed < nowCap) {
                deliveries[n - 1] = 0;
                int remainCap = nowCap - deliveryNeed;
                int index = 1;
                while (remainCap > 0 && n - 1 - index >= 0) {
                    if (deliveries[n - 1 - index] < remainCap) {
                        remainCap -= deliveries[n - 1 - index];
                        deliveries[n - 1 - index] = 0;
                        index++;
                        continue;
                    }
                    if (deliveries[n - 1 - index] >= remainCap) {
                        deliveries[n - 1 - index] -= remainCap;
                        break;
                    }
                }
            }

            if (deliveryNeed >= nowCap) {
                deliveries[n - 1] -= nowCap;
            }

            if (pickupNeed >= nowCap) {
                pickups[n - 1] -= nowCap;
            }

            if (pickupNeed < nowCap) {
                pickups[n - 1] = 0;
                int remainCap = nowCap - pickupNeed;
                int index = 1;
                while (remainCap > 0 && n - 1 - index >= 0) {
                    if (pickups[n - 1 - index] < remainCap) {
                        remainCap -= pickups[n - 1 - index];
                        pickups[n - 1 - index] = 0;
                        index++;
                        continue;
                    }
                    if (pickups[n - 1 - index] >= remainCap) {
                        pickups[n - 1 - index] -= remainCap;
                        break;
                    }
                }
            }

            answer += n * 2L;
            System.out.println(answer);
            if (deliveries[n - 1] > 0 || pickups[n - 1] > 0) {
                continue;
            }
            n--;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0});
    }
}
