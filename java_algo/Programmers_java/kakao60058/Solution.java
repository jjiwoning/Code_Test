package Programmers_java.kakao60058;

/**
 * 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
 * 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
 * 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
 *   3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
 * 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
 *   4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
 *   4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
 *   4-3. ')'를 다시 붙입니다.
 *   4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
 *   4-5. 생성된 문자열을 반환합니다.
 */
public class Solution {
	public String solution(String p) {
		return convert(p);
	}

	private String convert(String w) {
		// 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
		if (w.equals("")) {
			return "";
		}
		StringBuilder sb = new StringBuilder();

		int number = 0;
		String u = null;
		String v = null;

		// 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
		for (int i = 0; i < w.length(); i++) {
			char now = w.charAt(i);
			number += checkChar(now);
			if (number == 0) {
				u = w.substring(0, i + 1);
				v = w.substring(i + 1);
				break;
			}
		}

		// 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
		// 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
		if (isCorrectString(u)) {
			sb.append(u).append(convert(v));
			return sb.toString();
		}

		// 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
		// 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
		//   4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
		//   4-3. ')'를 다시 붙입니다.
		//   4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
		//   4-5. 생성된 문자열을 반환합니다.
		if (!isCorrectString(u)) {
			sb.append("(").append(convert(v)).append(")").append(reverse(u));
			return sb.toString();
		}

		return sb.toString();
	}

	private boolean isCorrectString(String s) {
		if (s.equals("")) {
			return true;
		}

		int number = 0;

		for (int i = 0; i < s.length(); i++) {
			number += checkChar(s.charAt(i));
			if (number < 0) {
				return false;
			}
		}

		return true;
	}

	private int checkChar(char c) {
		if (c == ')') {
			return -1;
		}
		if (c == '(') {
			return 1;
		}
		throw new IllegalArgumentException();
	}

	private String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < s.length() - 1; i++) {
			if (checkChar(s.charAt(i)) == 1) {
				sb.append(')');
			}
			if (checkChar(s.charAt(i)) == -1) {
				sb.append('(');
			}
		}
		return sb.toString();
	}
}
