package Programmers_java.kakao92335;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	Map<Long, Boolean> primeNumbers = new HashMap<>();

	public int solution(int n, int k) {
		int answer = 0;
		String nNumber = makeNNumber(n, k);

		String[] targets = nNumber.split("0");

		for (String target : targets) {
			if (target.equals("")) {
				continue;
			}
			long number = Long.parseLong(target);
			if (!primeNumbers.containsKey(number)) {
				if (isPrimeNumber(number)) {
					answer++;
				}
				continue;
			}
			if (primeNumbers.get(number)) {
				answer++;
			}
		}

		return answer;
	}

	private String makeNNumber(int n, int k) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sb.append(n % k);
			n /= k;
		}
		return sb.reverse().toString();
	}

	private boolean isPrimeNumber(long number) {
		if(number <= 1){
			primeNumbers.put(number, Boolean.FALSE);
			return false;
		}
		if(number == 2){
			primeNumbers.put(number, Boolean.TRUE);
			return true;
		}
		for (int i = 2; i <= (long)Math.sqrt(number); i++) {
			if(number % i == 0){
				primeNumbers.put(number, Boolean.FALSE);
				return false;
			}
		}
		primeNumbers.put(number, Boolean.TRUE);
		return true;
	}
}
