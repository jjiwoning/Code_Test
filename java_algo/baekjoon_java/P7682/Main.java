package baekjoon_java.P7682;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		while (true) {
			String s = br.readLine();

			if ("end".equals(s)) {
				System.out.println(answer);
				return;
			}

			char[][] map = new char[3][3];

			int xCount = 0;
			int oCount = 0;

			int index = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					map[i][j] = s.charAt(index++);

					if (map[i][j] == 'X') {
						xCount++;
					}
					if (map[i][j] == 'O') {
						oCount++;
					}
				}
			}

			if (xCount == oCount + 1) {
				if (xCount + oCount == 9 && !canMakeBingo('O', map)) {
					answer.append("valid").append("\n");
					continue;
				}
				if (!canMakeBingo('O', map) && canMakeBingo('X', map)) {
					answer.append("valid").append("\n");
					continue;
				}
				answer.append("invalid").append("\n");
				continue;
			}
			if (xCount == oCount) {
				if (!canMakeBingo('X', map) && canMakeBingo('O', map)) {
					answer.append("valid").append("\n");
					continue;
				}
				answer.append("invalid").append("\n");
				continue;
			}
			answer.append("invalid").append("\n");
		}
	}

	private static boolean canMakeBingo(char target, char[][] map) {
		for (int i = 0; i < 3; i++) {
			if (map[i][0] == target && map[i][1] == target && map[i][2] == target) {
				return true;
			}
		}

		for (int i = 0; i < 3; i++) {
			if (map[0][i] == target && map[1][i] == target && map[2][i] == target) {
				return true;
			}
		}

		if (map[0][0] == target
			&& map[1][1] == target
			&& map[2][2] == target
		) {
			return true;
		}

		if (map[0][2] == target
			&& map[1][1] == target
			&& map[2][0] == target
		) {
			return true;
		}

		return false;
	}
}
