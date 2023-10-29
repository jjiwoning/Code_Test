package baekjoon_java.P19637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> map = new HashMap<>();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String message = st.nextToken();
            int number = Integer.parseInt(st.nextToken());
            if (!map.containsKey(number)) {
                map.put(number, message);
                numbers.add(number);
            }
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(br.readLine());

            int start = 0;
            int end = numbers.size();

            while (start < end) {
                int mid = (start + end) / 2;

                if (numbers.get(mid) >= number) {
                    end = mid;
                }
                if (numbers.get(mid) < number) {
                    start = mid + 1;
                }
            }

            answer.append(map.get(numbers.get(end))).append("\n");
        }

        System.out.println(answer);
    }
}
