package study.week2.P20291;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            String[] strings = s.split("\\.");
            map.put(strings[1], map.getOrDefault(strings[1], 0) + 1);
        }

        Set<String> set = new TreeSet<>(map.keySet());

        for (String s : set) {
            System.out.println(s + " " + map.get(s));
        }
    }
}
