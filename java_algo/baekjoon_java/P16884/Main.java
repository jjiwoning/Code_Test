package baekjoon_java.P16884;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num % 2 == 1) {
				answer.append("koosaga").append("\n");
				continue;
			}
			answer.append("cubelover").append("\n");
		}

		System.out.println(answer);
	}
}
