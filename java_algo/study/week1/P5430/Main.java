package study.week1.P5430;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Deque<Integer> deque = new LinkedList<>();
            String command = sc.next();
            int index = sc.nextInt();
            String input = sc.next();
            String subInput = input.substring(1, input.length() - 1);
            String[] inputs = subInput.split(",");
            boolean checked = false;
            boolean reverse = false;
            // 4 -> 9, 1 -> 3, 6 -> 13
            for (String s : inputs) {
                if (s.equals("")) {
                    break;
                }
                int num = Integer.parseInt(s);
                deque.add(num);
            }
            for (int j = 0; j < command.length(); j++) {
                char c = command.charAt(j);
                if (c == 'R') {
                    reverse = !reverse;
                } else if (c == 'D') {
                    if (deque.isEmpty()) {
                        System.out.println("error");
                        checked = true;
                        break;
                    }
                    if (reverse) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if (!checked && !reverse) {
                if (deque.size() > 0) {
                    sb.append(deque.poll());
                    while (!deque.isEmpty()) {
                        sb.append(",").append(deque.poll());
                    }
                }
            } else if (!checked && reverse) {
                if (deque.size() > 0) {
                    sb.append(deque.pollLast());
                    while (!deque.isEmpty()) {
                        sb.append(",").append(deque.pollLast());
                    }
                }
            }
            sb.append("]");
            if (!checked) {
                System.out.println(sb.toString());
            }
        }
    }
}
