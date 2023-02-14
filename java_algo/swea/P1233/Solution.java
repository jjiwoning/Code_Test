package swea.P1233;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int n;
    static String[] binaryTree;
    static StringBuilder findCal;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 1; testCase <= 10; testCase++) {
            n = Integer.parseInt(br.readLine());

            binaryTree = new String[n + 1];
            findCal = new StringBuilder();

            for (int i = 1; i <= n; i++) {
                String[] s = br.readLine().split(" ");
                binaryTree[Integer.parseInt(s[0])] = s[1];
            }

            inorder(1);

            String[] s = findCal.toString().split(" ");

            int result = getResult(s);

            System.out.println("#" + testCase + " " + result);
        }
    }

    private static int getResult(String[] s) {
        int result = 1;
        boolean isNumber = true;

        for (String s1 : s) {
            if (isNumber) {
                try {
                    Integer.parseInt(s1);
                } catch (NumberFormatException e) {
                    result = 0;
                    break;
                }
            }else if (!isNumber) {
                int n = -1;
                try {
                    n = Integer.parseInt(s1);
                } catch (NumberFormatException e) {
                }
                if (n != -1) {
                    result = 0;
                    break;
                }
            }
            isNumber = !isNumber;
        }
        return result;
    }

    private static void inorder(int index) {
        if (index > n) {
            return;
        }
        inorder(index * 2);
        findCal.append(binaryTree[index]).append(" ");
        inorder(index * 2 + 1);
    }
}
