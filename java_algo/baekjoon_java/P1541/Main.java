package baekjoon_java.P1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        List<Character> calList = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-') {
                calList.add(input.charAt(i));
            }
        }

        Character[] calArr = calList.toArray(new Character[0]);

        input = input.replace('+', ' ');
        input = input.replace('-', ' ');

        int[] numArr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < calArr.length - 1; i++) {
            if (calArr[i] == '-') {
                calArr[i + 1] = '-';
            }
        }

        int answer = numArr[0];

        for (int i = 0; i < calList.size(); i++) {
            if (calArr[i] == '+') {
                answer += numArr[i + 1];
            }
            if (calArr[i] == '-') {
                answer -= numArr[i + 1];
            }
        }

        System.out.println(answer);
    }
}
