package baekjoon_java.P2342;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_cant {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int len = st.countTokens();

        Leg[][] dp = new Leg[len + 1][2]; // 0 왼발, 1 오른발

        int index = 1;
        dp[0][0] = new Leg(0, 0, 0);
        dp[0][1] = new Leg(0, 0, 0);

        while (true) {

            int n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }
            // 왼발
            Leg legLeft1 = dp[index - 1][0].leftMove(n);
            Leg legLeft2 = dp[index - 1][1].leftMove(n);

            if (legLeft1.power >= legLeft2.power) {
                dp[index][0] = legLeft2;
            } else {
                dp[index][0] = legLeft1;
            }

            // 오른발
            Leg legRight1 = dp[index - 1][0].rightMove(n);
            Leg legRight2 = dp[index - 1][1].rightMove(n);

            if (legRight1.power > legRight2.power) {
                dp[index][1] = legRight2;
            } else {
                dp[index][1] = legRight1;
            }

            index++;
        }

        System.out.println(Math.min(dp[index -1][0].power, dp[index -1][1].power));
    }

    private static class Leg {
        int left;
        int right;
        int power;

        public Leg(int left, int right, int power) {
            this.left = left;
            this.right = right;
            this.power = power;
        }

        public Leg leftMove(int direction) {

            Leg leg = new Leg(this.left, this.right, this.power);

            if (this.left == 0) {
                leg.left = direction;
                leg.power = this.power + 2;
                return leg;
            }

            if (this.left == direction) {
                leg.power = this.power + 1;
                return leg;
            }

            if (Math.abs(this.left - direction) == 2) {
                leg.left = direction;
                leg.power = this.power + 4;
                return leg;
            }

            if (Math.abs(this.left - direction) != 2) {
                leg.left = direction;
                leg.power = this.power + 3;
                return leg;
            }

            throw new IllegalArgumentException();
        }

        public Leg rightMove(int direction) {

            Leg leg = new Leg(this.left, this.right, this.power);

            if (this.right == 0) {
                leg.right = direction;
                leg.power = this.power + 2;
                return leg;
            }

            if (this.right == direction) {
                leg.power = this.power + 1;
                return leg;
            }

            if (Math.abs(this.right - direction) == 2) {
                leg.right = direction;
                leg.power = this.power + 4;
                return leg;
            }

            if (Math.abs(this.right - direction) != 2) {
                leg.right = direction;
                leg.power = this.power + 3;
                return leg;
            }

            throw new IllegalArgumentException();
        }
    }
}
