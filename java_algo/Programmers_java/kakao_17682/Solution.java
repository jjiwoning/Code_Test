package Programmers_java.kakao_17682;

import java.util.Arrays;

public class Solution {
    public int solution(String dartResult) {
        int[] answer = new int[3];

        int dartIndex = -1;
        int resultIndex = 0;

        while(resultIndex < dartResult.length()) {

            char now = dartResult.charAt(resultIndex);

            if (Character.isDigit(now)) {
                dartIndex++;
                resultIndex++;
                answer[dartIndex] = now - '0';
                if (Character.isDigit(dartResult.charAt(resultIndex))) {
                    resultIndex++;
                    answer[dartIndex] = 10;
                }
                continue;
            }

            if (now == '*') {
                for(int i = Math.max(0, dartIndex - 1); i <= dartIndex; i++) {
                    answer[i] *= 2;
                }
                resultIndex++;
                continue;
            }

            if (now == '#') {
                answer[dartIndex] *= -1;
                resultIndex++;
                continue;
            }

            if (now == 'D') {
                answer[dartIndex] = (int) Math.pow(answer[dartIndex], 2);
            }

            if (now == 'T') {
                answer[dartIndex] = (int) Math.pow(answer[dartIndex], 3);
            }

            resultIndex++;
        }

        return Arrays.stream(answer).sum();
    }
}
