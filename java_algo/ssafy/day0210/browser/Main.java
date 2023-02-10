package ssafy.day0210.browser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static String nowUrl;
    static Stack<String> forwardStack;
    static Stack<String> backwardStack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        forwardStack = new Stack<>();
        backwardStack = new Stack<>();
        nowUrl = "http://www.acm.org/";
        boolean flag = false;

        while (true) {
            String[] s = br.readLine().split(" ");
            if (s[0].equals("QUIT")) {
                break;
            }
            if ("BACK".equals(s[0])) {
                flag = backward();
            }
            if ("FORWARD".equals(s[0])) {
                flag = forward();
            }
            if (flag) {
                System.out.println("Ignored");
                flag = false;
                continue;
            }
            if ("VISIT".equals(s[0])) {
                backwardStack.add(nowUrl);
                forwardStack.clear();
                nowUrl = s[1];
            }
            System.out.println(nowUrl);
        }
    }

    private static boolean forward() {
        if (forwardStack.isEmpty()) {
            return true;
        }
        backwardStack.add(nowUrl);
        nowUrl = forwardStack.pop();
        return false;
    }

    private static boolean backward() {
        if (backwardStack.isEmpty()) {
            return true;
        }
        forwardStack.add(nowUrl);
        nowUrl = backwardStack.pop();
        return false;
    }
}
