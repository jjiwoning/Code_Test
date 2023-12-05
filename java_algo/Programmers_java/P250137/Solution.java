package Programmers_java.P250137;

public class Solution {
	// bandage는 [시전 시간, 초당 회복량, 추가 회복량] 형태의 길이가 3인 정수 배열입니다.
	// attacks[i]는 [공격 시간, 피해량] 형태의 길이가 2인 정수 배열입니다.
	public int solution(int[] bandage, int health, int[][] attacks) {
		int answer = health;
		int time = 0;

		for (int[] attack : attacks) {
			int t = attack[0] - time - 1;
			System.out.println(t);
			answer += t * bandage[1];

			if (t >= bandage[0]) {
				answer += (t / bandage[0]) * bandage[2];
			}

			answer = Math.min(answer, health);

			answer -= attack[1];

			if (answer <= 0) {
				return -1;
			}

			time = attack[0];
		}

		return answer;
	}
}
