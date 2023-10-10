package baekjoon_java.P2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] solutions = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(solutions);

        int startIndex = 0;
        int endIndex = n - 1;
        int minVal = Integer.MAX_VALUE;
        int answer1 = 0;
        int answer2 = 0;

        while (startIndex < endIndex) {
            int find = solutions[startIndex] + solutions[endIndex];

            if (find == 0) {
                System.out.println(solutions[startIndex] + " " + solutions[endIndex]);
                return;
            }

            if (Math.abs(find) < minVal) {
                answer1 = solutions[startIndex];
                answer2 = solutions[endIndex];
                minVal = Math.abs(find);
            }

            if (find < 0) {
                startIndex++;
            }
            if (find > 0) {
                endIndex--;
            }
        }

        System.out.println(answer1 + " " + answer2);
    }
}
