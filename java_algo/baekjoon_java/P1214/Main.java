package baekjoon_java.P1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int target = Integer.parseInt(st.nextToken());
        int value1 = Integer.parseInt(st.nextToken());
        int value2 = Integer.parseInt(st.nextToken());
        long answer = Long.MAX_VALUE;

        int maxValue = Math.max(value1, value2);
        int minValue = Math.min(value1, value2);

        int loopCount = target / maxValue + 1;

        for (int i = 0; i <= loopCount; i++) {
            long maxValueTotal = (long) maxValue * i;
            if (maxValueTotal >= target) {
                answer = Math.min(answer, maxValueTotal);
                continue;
            }
            long targetMinusMaxValue = target - maxValueTotal;
            if (targetMinusMaxValue % minValue == 0) {
                long find = maxValueTotal + minValue * (targetMinusMaxValue / minValue);
                if (answer == find) {
                    break;
                }
                answer = Math.min(answer, find);
                continue;
            }
            long find = maxValueTotal + minValue * ((targetMinusMaxValue / minValue) + 1);
            if (answer == find) {
                break;
            }
            answer = Math.min(answer, find);
        }

        System.out.println(answer);
    }
}
