package study.week12.kakao_92342;

/**
 * 카카오 기출 - 양궁 대회
 */
public class Solution {

    int score;
    int[] answer;
    int[] apeachScore;

    public int[] solution(int n, int[] info) {
        score = 0;
        answer = new int[]{-1};
        apeachScore = info;

        dfs(n,10, new int[11]);

        return answer;
    }

    private void dfs(int arrowCount, int index, int[] lionScore) {
        if (arrowCount == 0) {
            calScore(lionScore);
            return;
        }

        if (index == -1) {
            return;
        }

        for (int i = arrowCount; i >= 0; i--) {
            lionScore[index] = i;
            dfs(arrowCount - i, index - 1, lionScore);
            lionScore[index] = 0;
        }
    }

    private void calScore(int[] lionScore) {

        int lion = 0;
        int appeach = 0;

        for (int i = 0; i < 11; i++) {
            if (apeachScore[i] == 0 && lionScore[i] == 0) {
                continue;
            }
            if (apeachScore[i] >= lionScore[i]) {
                appeach += 10 - i;
                continue;
            }
            if (lionScore[i] > apeachScore[i]) {
                lion += 10 - i;
            }
        }

        if (lion > appeach) { // 라이언이 이김
            if (lion - appeach > score) {
                score = lion - appeach;
                answer = lionScore.clone();
                return;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0});
    }
}
