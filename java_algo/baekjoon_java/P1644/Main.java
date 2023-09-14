package baekjoon_java.P1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> primeNumbers = findAllPrimeNumbers(n);

        int answer = 0;

        for (int i = 0; i < primeNumbers.size(); i++) {
            int value = 0;
            for (int j = i; j < primeNumbers.size(); j++) {
                value += primeNumbers.get(j);
                if (value == n) {
                    answer++;
                    break;
                }
                if (value > n) {
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    private static List<Integer> findAllPrimeNumbers(int n) {
        if (n <= 1) {
            return List.of();
        }

        List<Integer> primeNumbers = new ArrayList<>();
        boolean[] numbers = new boolean[n + 1];

        checkNotPrimeNumber(n, numbers);

        for (int i = 2; i < n + 1; i++) {
            if (!numbers[i]) {
                primeNumbers.add(i);
            }
        }

        return primeNumbers;
    }

    private static void checkNotPrimeNumber(int n, boolean[] numbers) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (!numbers[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    numbers[j] = true;
                }
            }
        }
    }
}
