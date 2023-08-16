package baekjoon_java.P1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] nums = new int[10];

        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            nums[n]++;
        }

        int count = (nums[6] + nums[9]) / 2 + 1;

        if ((nums[6] + nums[9]) % 2 == 0) {
            count--;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 6 || i == 9) {
                continue;
            }
            count = Math.max(count, nums[i]);
        }

        System.out.println(count);
    }
}
