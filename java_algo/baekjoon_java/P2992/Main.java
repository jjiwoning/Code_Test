package baekjoon_java.P2992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.*;

public class Main {

    static int number;
    static char[] numArray;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String numString = br.readLine();
        number = Integer.parseInt(numString);
        numArray = numString.toCharArray();

        answer = Integer.MAX_VALUE;

        permutation(0);

        System.out.println(getAnswer());
    }

    private static void permutation(int nowIndex) {

        if (nowIndex == numArray.length - 1) {
            findAnswer();
            return;
        }

        for (int i = nowIndex; i < numArray.length; i++) {
            swap(nowIndex, i);
            permutation(nowIndex + 1);
            swap(i, nowIndex);
        }
    }

    private static void swap(int i, int j) {
        char temp = numArray[i];
        numArray[i] = numArray[j];
        numArray[j] = temp;
    }

    private static void findAnswer() {
        int findNumber = makeNum();
        if (findNumber > number) {
            answer = min(findNumber, answer);
        }
    }

    private static int makeNum() {
        int findNum = 0;
        for (int i = 0; i < numArray.length; i++) {
            findNum += (numArray[i] - '0') * pow(10, i);
        }
        return findNum;
    }

    private static int getAnswer() {
        if (answer == Integer.MAX_VALUE) {
            return 0;
        }
        return answer;
    }
}
