package Programmers_java.kakao92342;

// 어피치가 화살 n발을 다 쏜 후에 라이언이 화살 n발을 쏩니다.
// k(k는 1~10사이의 자연수)점을 어피치가 a발을 맞혔고 라이언이 b발을 맞혔을 경우 더 많은 화살을 k점에 맞힌 선수가 k 점을 가져갑니다.
// 라이언과 어피치 모두 k점에 단 하나의 화살도 맞히지 못한 경우는 어느 누구도 k점을 가져가지 않습니다.
// 단, a = b일 경우는 어피치가 k점을 가져갑니다.
// 최종 점수가 같을 경우 어피치를 우승자로 결정합니다.
// 라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우, 가장 낮은 점수를 더 많이 맞힌 경우를 return 해주세요.
public class Solution {
	// 풀이: 낮은 점수 부터 완탐 때리기
	private int n;
	private int score;
	private int[] answer;
	private int[] apeachInfo;

	public int[] solution(int n, int[] info) {
		this.n = n;
		this.apeachInfo = info;
		this.answer = new int[]{-1};
		this.score = -1;

		dfs(n, 10, new int[info.length]);

		return answer;
	}

	private void dfs(int depth, int index, int[] rionInfo) {
		if (depth == 0) {
			findAnswer(rionInfo);
			return;
		}

		if (index == -1) {
			return;
		}

		for (int i = depth; i >= 0; i--) {
			rionInfo[index] = i;
			dfs(depth - i, index - 1, rionInfo);
			rionInfo[index] = 0;
		}
	}

	private void findAnswer(int[] rionInfo) {
		int rionScore = 0;
		int apeachScore = 0;

		for (int i = 0; i < 11; i++) {
			if (apeachInfo[i] == 0 && rionInfo[i] == 0) {
				continue;
			}
			if (apeachInfo[i] >= rionInfo[i]) {
				apeachScore += 10 - i;
				continue;
			}
			if (rionInfo[i] > apeachInfo[i]) {
				rionScore += 10 - i;
			}
		}

		if (rionScore > apeachScore) { // 라이언이 이기는 경우
			if (rionScore - apeachScore > score) {
				score = rionScore - apeachScore;
				answer = rionInfo.clone();
				return;
			}
		}
	}
}

