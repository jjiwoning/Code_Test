package study.week2.P3671;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static boolean[] visited; // 방문한 숫자
    static String[] arr; // 입력 값 받아둘 배열
    static Set<Integer> set; // 중복 값 방지를 위한 Set
    static String[] numbers; // 순열로 생성된 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            arr = new String[s.length()];
            set = new HashSet<>();

            for (int j = 0; j < s.length(); j++) {
                arr[j] = s.charAt(j) + "";
            }

            visited = new boolean[arr.length];

            for (int j = 1; j <= arr.length; j++) {
                numbers = new String[j];
                dfs(0, j);
            }

            System.out.println(set.size());
        }
    }

    private static void dfs(int level, int wanted) {
        if (level == wanted) {
            StringBuilder sb = new StringBuilder();
            for (String number : numbers) {
                sb.append(number);
            }
            int num = Integer.parseInt(sb.toString());
            if (isPrimeNumber(num)) {
                set.add(num);
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                numbers[level] = arr[i];
                dfs(level + 1, wanted);
                numbers[level] = null;
                visited[i] = false;
            }
        }
    }

    private static boolean isPrimeNumber(int number) {

        if (number < 2) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        for (int i = 2; i <= (int)Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
