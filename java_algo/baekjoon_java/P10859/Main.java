package baekjoon_java.P10859;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	private static Map<Character, Character> replaceMap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();
		setReplaceMap();

		if (!isPrimeNumber(number)) {
			System.out.println("no");
			return;
		}

		try {
			String num = replaceNumber(number);
			if (!isPrimeNumber(num)) {
				System.out.println("no");
				return;
			}
			System.out.println("yes");
		} catch (Exception e) {
			System.out.println("no");
		}
	}

	private static boolean isPrimeNumber(String number) {
		long num = Long.parseLong(number);

		if (num < 2) {
			return false;
		}

		if (num == 2) {
			return true;
		}

		for (long i = 2; i <= (long)Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static String replaceNumber(String number) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < number.length(); i++) {
			sb.append(replaceMap.get(number.charAt(i)));
		}

		sb.reverse();

		return sb.toString();
	}

	private static void setReplaceMap() {
		replaceMap = new HashMap<>();

		replaceMap.put('1', '1');
		replaceMap.put('0', '0');
		replaceMap.put('2', '2');
		replaceMap.put('5', '5');
		replaceMap.put('8', '8');

		replaceMap.put('6', '9');
		replaceMap.put('9', '6');
	}
}
