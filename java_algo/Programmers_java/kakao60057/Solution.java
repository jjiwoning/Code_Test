package Programmers_java.kakao60057;

public class Solution {
	public int solution(String s) {
		int answer = s.length();

		for (int i = 1; i <= s.length() / 2; i++) {
			StringBuilder sb = new StringBuilder();
			String start = s.substring(0, i);
			int count = 1;
			int j = i; // i개 씩 자른다고 할 때 남는 부분이 생길 때를 대비해서 j를 밖에서 선언
			for (j = i; j < s.length() - i + 1; j += i) { // i개 씩 잘라서 확인하기
				String target = s.substring(j, j + i);

				// 둘이 다르다면 sb에 넣어주기
				if (!start.equals(target)) {
					if (count == 1) {
						sb.append(start);
					}
					if (count != 1) {
						sb.append(count).append(start);
					}
					start = target; // 새로운 값 지정
					count = 1; // 새로운 값 지정
					continue;
				}

				// 둘이 같기 때문에 count++
				count++;
			}

			// 끝까지 왔을 때 마지막으로 체크한거 넣어주기
			if (count == 1) {
				sb.append(start);
			}
			if (count != 1) {
				sb.append(count).append(start);
			}
			// j 이후로 i개가 만들어지지 않는 String 넣어주기
			sb.append(s.substring(j));

			answer = Math.min(answer, sb.length());
		}

		return answer;
	}
}
