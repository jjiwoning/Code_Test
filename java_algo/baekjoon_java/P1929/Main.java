package baekjoon_java.P1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] primeNumberCheck = isPrimeNumber(m);

        printAnswer(n, primeNumberCheck);
    }

    private static boolean[] isPrimeNumber(int maxNumber) {
        boolean[] primeNumberCheck = setPrimeNumberCheckArray(maxNumber);

        for (int i = 2; i * i < maxNumber + 1; i++) {
            fillPrimeNumbers(maxNumber, primeNumberCheck, i);
        }

        return primeNumberCheck;
    }

    private static boolean[] setPrimeNumberCheckArray(int maxNumber) {
        boolean[] primeNumberCheck = new boolean[maxNumber + 1];
        Arrays.fill(primeNumberCheck, true);
        primeNumberCheck[0] = false;
        primeNumberCheck[1] = false;
        return primeNumberCheck;
    }

    private static void fillPrimeNumbers(int maxNumber, boolean[] primeNumberCheck, int target) {
        if (primeNumberCheck[target]) {
            for (int j = target * target; j < maxNumber + 1; j += target) {
                primeNumberCheck[j] = false;
            }
        }
    }

    private static void printAnswer(int n, boolean[] primeNumberCheck) {
        for (int i = n; i < primeNumberCheck.length; i++) {
            if (primeNumberCheck[i]) {
                System.out.println(i);
            }
        }
    }
}
