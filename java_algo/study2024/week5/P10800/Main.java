package study2024.week5.P10800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		List<Ball> balls = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			balls.add(new Ball(i, color, size));
		}

		balls.sort((o1, o2) -> o1.size - o2.size);

		int sum = 0;
		int[] colorSums = new int[n + 1];
		int[] result = new int[n];
		int index = 0;

		for (int i = 0; i < n; i++) {
			Ball ball = balls.get(i);

			while (balls.get(index).size < ball.size) {
				sum += balls.get(index).size;
				colorSums[balls.get(index).color] += balls.get(index).size;
				index++;
			}

			result[ball.id] = sum - colorSums[ball.color];
		}

		StringBuilder answer = new StringBuilder();
		for (int res : result) {
			answer.append(res).append("\n");
		}
		System.out.println(answer);
	}
}

class Ball {
	int id;
	int color;
	int size;

	public Ball(int id, int color, int size) {
		this.id = id;
		this.color = color;
		this.size = size;
	}
}
