package Programmers_java.seesaw_pair;

public class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        int[] memory = new int[1001];

        for (int weight : weights) {

            if (memory[weight] != 0) {
                answer += memory[weight];
            }

            if (weight * 2 <= 1000 && memory[weight * 2] != 0) {
                answer += memory[weight * 2];
            }

            if (weight % 2 == 0 && weight / 2 >= 100 && memory[weight / 2] != 0) {
                answer += memory[weight / 2];
            }

            if (weight % 2 == 0 && (weight / 2) * 3 <= 1000 && memory[(weight / 2) * 3] != 0) {
                answer += memory[(weight / 2) * 3];
            }

            if (weight % 3 == 0 && (weight / 3) * 2 >= 100 && memory[(weight / 3) * 2] != 0) {
                answer += memory[(weight / 3) * 2];
            }

            if (weight % 3 == 0 && (weight / 3) * 4 <= 1000 && memory[(weight / 3) * 4] != 0) {
                answer += memory[(weight / 3) * 4];
            }

            if (weight % 4 == 0 && (weight / 4) * 3 >= 100 && memory[(weight / 4) * 3] != 0) {
                answer += memory[(weight / 4) * 3];
            }

            memory[weight]++;
        }

        return answer;
    }
}
