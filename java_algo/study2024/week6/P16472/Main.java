package study2024.week6.P16472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		char[] arr = br.readLine().toCharArray();

		Map<Character, Integer> map = new HashMap<>();

		int answer = 0;

		int start = 0;
		int end = 1;

		map.put(arr[start], map.getOrDefault(arr[start], 0) + 1);
		map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

		while (end < arr.length - 1) {
			if (map.size() <= n) {
				end++;
				map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
			}

			if (map.size() > n && start < end) {
				if (map.get(arr[start]) == 1) {
					map.remove(arr[start]);
				} else {
					map.put(arr[start], map.get(arr[start]) - 1);
				}
				start++;
			}

			answer = Math.max(answer, end - start + 1);
		}

		System.out.println(answer);
	}
}
