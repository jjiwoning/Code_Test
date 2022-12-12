package Programmers_java.basestationinstall;

/**
 * 프로그래머스 - 기지국 설치
 */
public class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int cover = 2 * w + 1;
        int start = 1;

        for (int station : stations) {
            int end = station - 1 - w;
            if (end >= start) {
                answer += findCount(start, end, cover);
            }
            start = station + w + 1;
        }

        if (stations[stations.length - 1] + w + 1 <= n) {
            answer += findCount(stations[stations.length - 1] + 1 + w, n, cover);
        }

        return answer;
    }

    private int findCount(int start, int end, int cover) {
        int length = end - start + 1;
        int count = 0;

        count += (length / cover);
        if (length % cover != 0) {
            count++;
        }

        return count;
    }
}
