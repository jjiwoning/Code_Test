package study2024.week2.P1036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	private static final int NUM_36 = 36;

	private static Map<String, Integer> numbers;
	private static Map<String, Node> numberCounts;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numbers = initNumbers();
		numberCounts = new HashMap<>();
		int n = Integer.parseInt(br.readLine());

		BigInteger totalValue = new BigInteger("0");

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			totalValue = totalValue.add(findValue(s));
		}

		int changeCount = Integer.parseInt(br.readLine());

		List<Node> results = new ArrayList<>(numberCounts.values());

		results.sort((o1, o2) -> {
			if (o1.value.equals(o2.value)) {
				return o1.number.compareTo(o2.number);
			}
			return o2.value.compareTo(o1.value);
		});

		// System.out.println(results);

		int cnt = 0;

		if (changeCount != 0) {
			for (Node result : results) {
				if (result.number.equals("Z")) {
					continue; // 바꿀 이유 없음
				}
				totalValue = totalValue.subtract(
					result.depth.multiply(new BigInteger(String.valueOf(numbers.get(result.number)))));;
				totalValue = totalValue.add(result.depth.multiply(new BigInteger(String.valueOf(numbers.get("Z")))));
				cnt++;

				if (cnt == changeCount) {
					break;
				}
			}
		}

		Map<Integer, String> map = new HashMap<>();
		for (String s : numbers.keySet()) {
			map.put(numbers.get(s), s);
		}

		StringBuilder answer = new StringBuilder();

		BigInteger ModNum = new BigInteger(String.valueOf(NUM_36));

		while (true) {
			BigInteger find = totalValue.remainder(ModNum);
			answer.append(map.get(find.intValue()));
			totalValue = totalValue.divide(ModNum);

			if (totalValue.compareTo(new BigInteger("0")) == 0) {
				break;
			}
		}

		System.out.println(answer.reverse());
	}

	private static BigInteger findValue(String s) {
		BigInteger value = new BigInteger("0");
		int depth = 0;
		BigInteger num36Big = new BigInteger(String.valueOf(NUM_36));
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			Integer number = numbers.get(c + "");
			BigInteger find = num36Big.pow(depth).multiply(new BigInteger(String.valueOf(number)));
			value = value.add(find);
			if (!numberCounts.containsKey(c + "")) {
				numberCounts.put(c + "", new Node(c + ""));
			}
			numberCounts.get(c + "").value = numberCounts.get(c + "").value.add(
				new BigInteger(String.valueOf((numbers.get("Z") - number))).multiply(num36Big.pow(depth)));
			numberCounts.get(c + "").depth = numberCounts.get(c + "").depth.add(num36Big.pow(depth));
			depth++;
		}
		return value;
	}

	private static Map<String, Integer> initNumbers() {
		Map<String, Integer> numbers = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			numbers.put(i + "", i);
		}
		int num = 10;
		numbers.put("A", num++);
		numbers.put("B", num++);
		numbers.put("C", num++);
		numbers.put("D", num++);
		numbers.put("E", num++);
		numbers.put("F", num++);
		numbers.put("G", num++);
		numbers.put("H", num++);
		numbers.put("I", num++);
		numbers.put("J", num++);
		numbers.put("K", num++);
		numbers.put("L", num++);
		numbers.put("M", num++);
		numbers.put("N", num++);
		numbers.put("O", num++);
		numbers.put("P", num++);
		numbers.put("Q", num++);
		numbers.put("R", num++);
		numbers.put("S", num++);
		numbers.put("T", num++);
		numbers.put("U", num++);
		numbers.put("V", num++);
		numbers.put("W", num++);
		numbers.put("X", num++);
		numbers.put("Y", num++);
		numbers.put("Z", num++);
		return numbers;
	}
}

class Node {
	String number; // 현재 숫자 0 ~ 9, A ~ Z
	BigInteger value; // 자릿수들 더한 값
	BigInteger depth;

	public Node(String number) {
		this.number = number;
		this.value = new BigInteger("0");
		this.depth = new BigInteger("0");
	}

	@Override
	public String toString() {
		return "Node{" +
			"number='" + number + '\'' +
			", value=" + value +
			", depth=" + depth +
			'}';
	}
}
