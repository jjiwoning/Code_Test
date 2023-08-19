package baekjoon_java.P5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int testCase = 0; testCase < t; testCase++) {
            String commands = br.readLine();
            int commandCount = Integer.parseInt(br.readLine());
            Deque<Integer> numbers = parseInputNumbers(br.readLine());

            boolean reversed = false;
            for (int i = 0; i < commandCount; i++) {
                char command = commands.charAt(i);
            }
        }
    }

    private static Deque<Integer> parseInputNumbers(String inputString) {
        Deque<Integer> deque = new LinkedList<>();
        inputString = inputString.substring(1, inputString.length() - 1);
        String[] split = inputString.split(",");
        for (String s : split) {
            if (s.equals("")) {
                return deque;
            }
            deque.add(Integer.parseInt(s));
        }
        return deque;
    }
}
