package Programmers_java.P12936;

public class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        int[] numArr = new int[n];
        boolean[] visited = new boolean[n];

        long now = 1;

        for(int i = 0; i < n; i++) {
            numArr[i] = i + 1;
            now *= i + 1;
        }

        int index = 0;
        k--;
        for(int i = n; i > 0; i--) {
            now /= i;
            long findIndex = k / now;
            for(int j = 0; j < n; j++) {
                if(!visited[j]) {
                    if (--findIndex == -1) {
                        visited[j] = true;
                        answer[index++] = numArr[j];
                    }
                }
            }
            k %= now;
        }

        return answer;
    }
}
