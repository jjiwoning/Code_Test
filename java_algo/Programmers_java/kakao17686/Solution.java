package Programmers_java.kakao17686;

import java.util.Arrays;

public class Solution {
	public String[] solution(String[] files) {
		File[] file = new File[files.length];

		for (int i = 0; i < files.length; i++) {
			file[i] = new File(i, files[i]);
			// System.out.println(file[i].originName);
			// System.out.println(file[i].head);
			// System.out.println(file[i].number);
			// System.out.println("===================");
		}

		// 정렬 조건
		// 파일명은 우선 HEAD 부분을 기준으로 사전 순으로 정렬한다. 이때, 문자열 비교 시 대소문자 구분을 하지 않는다. MUZI와 muzi, MuZi는 정렬 시에 같은 순서로 취급된다.
		// 파일명의 HEAD 부분이 대소문자 차이 외에는 같을 경우, NUMBER의 숫자 순으로 정렬한다. 9 < 10 < 0011 < 012 < 13 < 014 순으로 정렬된다. 숫자 앞의 0은 무시되며, 012와 12는 정렬 시에 같은 같은 값으로 처리된다.
		// 두 파일의 HEAD 부분과, NUMBER의 숫자도 같을 경우, 원래 입력에 주어진 순서를 유지한다. MUZI01.zip과 muzi1.png가 입력으로 들어오면, 정렬 후에도 입력 시 주어진 두 파일의 순서가 바뀌어서는 안 된다.
		Arrays.sort(file, (o1, o2) -> {

			if (o1.head.equals(o2.head)) {
				if (o1.number == o2.number) {
					return o1.order - o2.order;
				}
				return Long.compare(o1.number, o2.number);
			}

			return o1.head.compareTo(o2.head);
		});

		return Arrays.stream(file).map(file1 -> file1.originName).toArray(String[]::new);
	}
}

class File {
	int order; // 순서
	String originName; // 파일 원래 이름
	String head; // head
	long number; // number
	String tail; // tail

	public File(int order, String originName) {
		this.order = order;
		this.originName = originName;
		String[] parseName = parseName(originName);
		this.head = parseName[0].toLowerCase();
		this.number = Long.parseLong(parseName[1]);
		this.tail = parseName[2];
	}

	private String[] parseName(String originName) {
		String[] result = new String[3];
		int i = 0;
		for (i = 0; i < originName.length(); i++) {
			if ('0' <= originName.charAt(i) && originName.charAt(i) <= '9') {
				result[0] = originName.substring(0, i);
				break;
			}
		}

		for (int j = i; j < originName.length(); j++) {
			if ('0' > originName.charAt(j) || originName.charAt(j) > '9') {
				result[1] = originName.substring(i, j);
				result[2] = originName.substring(j, originName.length());
				break;
			}
		}
		if (result[1] == null) {
			result[1] = originName.substring(i, originName.length());
			result[2] = null;
		}
		return result;
	}
}
