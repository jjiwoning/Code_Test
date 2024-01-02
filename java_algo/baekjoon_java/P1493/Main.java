package baekjoon_java.P1493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static long total;
	private static long answer;
	private static int[] cubes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int n = Integer.parseInt(br.readLine());
		cubes = new int[21];
		answer = 0;
		total = (long)l * w * h;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			cubes[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		recur(l, w, h);

		if (total > 0) {
			System.out.println(-1);
			return;
		}

		System.out.println(answer);
	}

	private static void recur(int l, int w, int h) {
		if (l <= 0 || w <= 0 || h <= 0) {
			return;
		}
		for (int i = 20; i >= 0; i--) {
			if (cubes[i] == 0) {
				continue;
			}
			int length = (int)Math.pow(2, i);

			if (l < length || w < length || h < length) {
				continue;
			}

			total -= (long)Math.pow(length, 3);
			cubes[i]--;
			answer += 1;

			recur(l - length, w, length);
			recur(l, w, h - length);
			recur(length, w - length, length);
			return;
		}
	}
}
