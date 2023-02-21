package study.week6.P7795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            String[] input1 = br.readLine().split(" ");
            int aLen = Integer.parseInt(input1[0]);
            int bLen = Integer.parseInt(input1[1]);

            int[] aArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] bArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(aArr);
            Arrays.sort(bArr);

            int aIndex = 0;
            int bIndex = 0;

            int count = 0;

            while (aIndex < aLen && bIndex < bLen) {
                if (aArr[aIndex] <= bArr[bIndex]) {
                    aIndex++;
                    continue;
                }

                if (aArr[aIndex] > bArr[bIndex]) {
                    count += (aLen - aIndex);
                    bIndex++;
                }
            }

            answer.append(count).append("\n");
        }

        System.out.println(answer);
    }

}
