package baekjoon_java.P5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    private static boolean reversed;
    private static boolean exception;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int testCase = 0; testCase < t; testCase++) {
            String commands = br.readLine();
            int commandCount = Integer.parseInt(br.readLine());
            Deque<Integer> numbers = parseInputNumbers(br.readLine());

            reversed = false;
            exception = false;

            for (int i = 0; i < commands.length(); i++) {
                char command = commands.charAt(i);
                doCommand(command, numbers);
                if (exception) {
                    break;
                }
            }

            if (exception) {
                output.append("error").append("\n");
                continue;
            }

            output.append("[");
            if (reversed) {
                if (numbers.size() > 0) {
                    output.append(numbers.pollLast());
                    while (!numbers.isEmpty()) {
                        output.append(",").append(numbers.pollLast());
                    }
                }
            }

            if (!reversed) {
                if (numbers.size() > 0) {
                    output.append(numbers.poll());
                    while (!numbers.isEmpty()) {
                        output.append(",").append(numbers.poll());
                    }
                }
            }
            output.append("]").append("\n");
        }

        System.out.println(output);
    }

    private static void doCommand(char command, Deque<Integer> numbers) {
        if (command == 'D' && numbers.isEmpty()) {
            exception = true;
            return;
        }
        if (command == 'D' && reversed) {
            numbers.pollLast();
            return;
        }
        if (command == 'D' && !reversed) {
            numbers.pollFirst();
            return;
        }
        if (command == 'R') {
            reversed = !reversed;
            return;
        }
        throw new IllegalStateException();
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
