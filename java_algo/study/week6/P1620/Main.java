package study.week6.P1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Map<String, Integer> nameToIntMap = new HashMap<>();
        Map<Integer, String> intToNameMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String mon = br.readLine();
            nameToIntMap.put(mon, i);
            intToNameMap.put(i, mon);
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < k; i++) {
            String s = br.readLine();
            try {
                int no = Integer.parseInt(s);
                answer.append(intToNameMap.get(no)).append("\n");
            } catch (NumberFormatException e) {
                answer.append(nameToIntMap.get(s)).append("\n");
            }
        }

        System.out.println(answer);
    }
}
