package study.week12.kakao_92342;

/**
 * 카카오 기출 - 양궁 대회
 */
public class Solution {

    int score;
    int[] answer;
    int[] apeachInfo;

    public int[] solution(int n, int[] info) {
        score = 0;
        answer = new int[]{-1};
        apeachInfo = info;

        dfs(n,10, new int[11]);

        return answer;
    }

    private void dfs(int arrowCount, int index, int[] lionInfo) {
        if (arrowCount == 0) {
            calScore(lionInfo);
            return;
        }

        if (index == -1) {
            return;
        }

        for (int i = arrowCount; i >= 0; i--) {
            lionInfo[index] = i;
            dfs(arrowCount - i, index - 1, lionInfo);
            lionInfo[index] = 0;
        }
    }

    private void calScore(int[] lionInfo) {

        int lion = 0;
        int appeach = 0;

        for (int i = 0; i < 11; i++) {
            if (apeachInfo[i] == 0 && lionInfo[i] == 0) {
                continue;
            }
            if (apeachInfo[i] >= lionInfo[i]) {
                appeach += 10 - i;
                continue;
            }
            if (lionInfo[i] > apeachInfo[i]) {
                lion += 10 - i;
            }
        }

        if (lion > appeach) { // 라이언이 이김
            if (lion - appeach > score) {
                score = lion - appeach;
                answer = lionInfo.clone();
                return;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0});
    }
}
