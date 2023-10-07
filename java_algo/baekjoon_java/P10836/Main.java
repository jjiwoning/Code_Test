package baekjoon_java.P10836;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        Bees bees = new Bees(size);

        bees.add(makePrefixSum(br, size, day));

        System.out.println(bees);
    }

    private static int[] makePrefixSum(BufferedReader br, int size, int day) throws IOException {
        StringTokenizer st;
        int[] prefixSum = new int[size * 2 - 1];

        for (int i = 0; i < day; i++) {
            st = new StringTokenizer(br.readLine());
            int zero = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            if (zero < size * 2 - 1) {
                prefixSum[zero]++;
            }
            if (zero + one < size * 2 - 1) {
                prefixSum[zero + one]++;
            }
        }

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }

        return prefixSum;
    }

}

class Bees {

    int size;
    int[][] bees;

    public Bees(int size) {
        this.size = size;
        this.bees = new int[size][size];
    }

    public void add(int[] prefixSum) {
        int startX = this.size - 1;
        int startY = 0;

        for (int sum : prefixSum) {
            this.bees[startX][startY] += sum;
            if (startX > 0) {
                startX--;
                continue;
            }
            if (startX == 0) {
                startY++;
            }
        }

        for (int i = 1; i < this.size; i++) {
            for (int j = 1; j < this.size; j++) {
                bees[i][j] = Math.max(bees[i - 1][j], Math.max(bees[i][j - 1], bees[i - 1][j - 1]));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] bee : bees) {
            for (int value : bee) {
                sb.append(value + 1).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
