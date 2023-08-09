package baekjoon_java.P2109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Info> infos = new ArrayList<>();

        int maxDay = -1;

        for (int i = 0; i < n; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            maxDay = Math.max(maxDay, inputs[1]);
            infos.add(new Info(inputs[0], inputs[1]));
        }

        infos.sort((o1, o2) -> {
            if (o1.cost == o2.cost) {
                return o2.day - o1.day;
            }
            return o2.cost - o1.cost;
        });

        int answer = 0;
        boolean[] reservation = new boolean[maxDay + 1];

        for (Info info : infos) {
            for (int day = info.day; day >= 1; day--) {
                if (!reservation[day]) {
                    reservation[day] = true;
                    answer += info.cost;
                    break;
                }
            }
        }

        System.out.println(answer);

    }
}

class Info {

    int cost;
    int day;

    public Info(int cost, int day) {
        this.cost = cost;
        this.day = day;
    }
}
