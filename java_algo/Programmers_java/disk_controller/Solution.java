package Programmers_java.disk_controller;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 프로그래머스 - 디스크 컨트롤러
 */
public class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int index = 0;
        int endTime = 0;
        int count = 0;

        // 시작 시간을 기준으로 배열 먼저 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        // 실행 시간을 순서로 우선순위 큐 생성
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        // 모든 job이 실행될 때까지 실행
        while (count < jobs.length) {
            // 대기하고 있는 job을 넣어주는 과정 -> endTime 이전에 대기에 들어간 job을 우선순위 큐에 넣어준다.
            while (index < jobs.length && jobs[index][0] <= endTime) {
                priorityQueue.add(jobs[index]);
                index++;
            }

            if (priorityQueue.isEmpty()) {
                endTime = jobs[index][0];
            } else {
                int[] temp = priorityQueue.poll();
                answer += temp[1] - temp[0] + endTime;
                endTime += temp[1];
                count++;
            }
        }

        return (int)Math.floor(answer / jobs.length);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
        System.out.println("answer = " + answer);
    }
}
