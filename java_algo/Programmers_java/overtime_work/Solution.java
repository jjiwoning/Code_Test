package Programmers_java.overtime_work;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 프로그래머스 - 야근지수
 */
public class Solution {
    /*
    public long solution(int n, int[] works) {
        long answer = 0;
        int[] workCount = new int[50001];

        for (int work : works) {
            workCount[work]++;
        }
        int keep = 1;

        for (int i = workCount.length - 1; i > 0; i--) {
            if (workCount[i] == 0) {
                continue;
            }
            if (workCount[i] < n) {
                workCount[i - 1] += workCount[i];
                n -= workCount[i];
                workCount[i] = 0;
            } else {
                workCount[i - 1] += n;
                workCount[i] -= n;
                keep = i;
                break;
            }
        }

        for (int i = 1; i <= keep; i++) {
            if (workCount[i] > 0) {
                answer += (workCount[i]) * (i * i);
            }
        }

        return answer;
    }
     */

    public long solution(int n, int[] works) {
        PriorityQueue<Integer> overtime = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            overtime.offer(work);
        }

        for (int i = 0; i < n; i++) {
            int max = (int)overtime.poll();
            if (max <= 0) break;
            overtime.offer(max - 1);
        }

        return sumPow(overtime);
    }

    long sumPow(PriorityQueue<Integer> works) {
        long sum = 0;
        while (!works.isEmpty()) {
            sum += Math.pow(works.poll(), 2);
        }
        return sum;
    }
}
