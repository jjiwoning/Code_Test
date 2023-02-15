package study.week4.P1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            meetings[i] = new Meeting(input[0], input[1]);
        }

        Arrays.sort(meetings, (o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        int answer = 0;
        int time = 0;

        for (Meeting meeting : meetings) {
            if (time <= meeting.start) {
                time = meeting.end;
                answer++;
            }
        }

        System.out.println(answer);
    }

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
