package Programmers_java.kakao150367;

public class Solution {
	public int[] solution(long[] numbers) {
		int[] answer = new int[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			String num = Long.toBinaryString(numbers[i]); // 길이 맞춰줘야됨
			int idx = 1; // 길이 맞춰주기 위한 idx
			while (true) {
				int targetSize = (int) Math.pow(2, idx) - 1;
				if (num.length() <= targetSize) {
					StringBuilder sb = new StringBuilder();
					for (int k = 0; k < targetSize - num.length(); k++) {
						sb.append("0");
					}
					sb.append(num);
					num = sb.toString();
					break;
				}
				idx++;
			}

			if (canMakeBinaryTree(num, num.length() / 2, idx - 2)) {
				answer[i] = 1;
			}
		}

		return answer;
	}

	private boolean canMakeBinaryTree(String binary, int index, int depth) {

		if (depth == -1) {
			return true;
		}

		int nextIndex = (int) Math.pow(2, depth);

		// 1번 케이스: 현재 타겟이 0일 때
		if (binary.charAt(index) == '0') {
			if (binary.charAt(index - nextIndex) == '1' ||
				binary.charAt(index + nextIndex) == '1'
			) {
				return false;
			}
		}

		return canMakeBinaryTree(binary, index - nextIndex, depth - 1) && canMakeBinaryTree(binary, index + nextIndex, depth - 1);

	}
}
