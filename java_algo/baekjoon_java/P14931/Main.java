package baekjoon_java.P14931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int l = Integer.parseInt(br.readLine());
        int[] river = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        findMaxScore(l, river).printInfo();
    }

    private static Info findMaxScore(final int l, final int[] river) {
        int minInterval = -1;
        long maxScore = -1;

        for (int interval = 1; interval <= l; interval++) {
            long score = findScore(l, river, interval);

            if (score > maxScore) {
                maxScore = score;
                minInterval = interval;
            }
            
            interval++;
        }


        return new Info(minInterval, maxScore);
    }

    private static long findScore(
            final int l,
            final int[] river,
            final int interval
    ) {
        long score = 0;
        for (int i = interval - 1; i < l; i += interval) {
            score += river[i];
        }
        return score;
    }
}

class Info {
    private final int interval;
    private final long score;

    public Info(
            final int interval,
            final long score
    ) {
        this.interval = interval;
        this.score = score;
    }

    public void printInfo() {
        if (this.score <= 0L) {
            System.out.println("0 0");
            return;
        }

        System.out.println(interval + " " + score);
    }
}
