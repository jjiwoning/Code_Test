package baekjoon_java.programmers.boat;

import java.util.Arrays;

public class Solution {

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int minIdx = 0;

        for (int i = people.length - 1;  minIdx <= i; i--) {
            if (people[minIdx] + people[i] <= limit) {
                minIdx++;
            }
            answer++ ;
        }

        return answer;
    }

}
