package baekjoon_java.P14658;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		List<Star> stars = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			stars.add(new Star(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int answer = Integer.MAX_VALUE;

		for (Star xStar : stars) {
			for (Star yStar : stars) {
				int cnt = k;
				for (Star star : stars) {
					if (canCatch(xStar, yStar, star, l)) {
						cnt--;
					}
				}
				answer = Math.min(answer, cnt);
			}
		}

		System.out.println(answer);
	}

	private static boolean canCatch(Star xStar, Star yStar, Star star, int length) {
		return (xStar.x <= star.x && star.x <= xStar.x + length)
			&& (yStar.y <= star.y && star.y <= yStar.y + length);
	}
}

class Star {
	int x;
	int y;

	public Star(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
