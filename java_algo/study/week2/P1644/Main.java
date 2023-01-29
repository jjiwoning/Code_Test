package study.week2.P1644;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> primeNumbers = findPrimeNumbers(n);

        int count = 0;
        int find = 0;
        int endIndex = 0;

        for (int startIndex = 0; startIndex < primeNumbers.size(); startIndex++) {
            while (endIndex < primeNumbers.size() && find < n) {
                find += primeNumbers.get(endIndex);
                endIndex++;
            }
            if (find == n) {
                count++;
            }
            find -= primeNumbers.get(startIndex);
        }

        System.out.println(count);
    }

    private static List<Integer> findPrimeNumbers(int n) {
        if (n <= 1) {
            return Collections.emptyList();
        }
        List<Integer> primeNumbers = new ArrayList<>();
        boolean[] numbers = new boolean[n + 1];

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (!numbers[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    numbers[j] = true;
                }
            }
        }

        for (int i = 2; i < n + 1; i++) {
            if (!numbers[i]) {
                primeNumbers.add(i);
            }
        }
        
        return primeNumbers;
    }
}
