package study2024.week5.P1092;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List<Integer> boats = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			boats.add(Integer.parseInt(st.nextToken()));
		}
		boats.sort((o1, o2) -> o2 - o1);

		int m = Integer.parseInt(br.readLine());

		List<Integer> boxes = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			boxes.add(Integer.parseInt(st.nextToken()));
		}

		boxes.sort((o1, o2) -> o2 - o1);

		if (boats.get(0) < boxes.get(0)) {
			System.out.println(-1);
			return;
		}

		int answer = 0;

		while (true) {
			int boxIndex = 0;
			for (int i = 0; i < n; i++) {
				if (boxIndex == boxes.size()) {
					break;
				}
				if (boats.get(i) >= boxes.get(boxIndex)) {
					boxes.remove(boxIndex);
					continue;
				}
				while (true) {
					boxIndex++;
					if (boxIndex == boxes.size()) {
						break;
					}
					if (boats.get(i) >= boxes.get(boxIndex)) {
						boxes.remove(boxIndex);
						break;
					}
				}
			}
			answer++;
			if (boxes.isEmpty()) {
				System.out.println(answer);
				return;
			}
		}
	}
}
