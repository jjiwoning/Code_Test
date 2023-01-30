package study.week2.P2668;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainFail {

    static int[] arr;
    static boolean[] visited;
    static boolean checked;
    static int n;
    static int count;
    static boolean[] answer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n];
        visited = new boolean[n];
        checked = false;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = n; i >= 1; i--) {
            combination(0, 0, i);
            if (checked) {
                break;
            }
        }

        System.out.println(count);

        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                System.out.println(i + 1);
            }
        }
    }

    private static void combination(int start, int level, int wanted) {
        if (level == wanted) {
            if (checkNumber()) {
                checked = true;
                count = wanted;
                answer = visited.clone();
            }
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(i + 1, level + 1, wanted);
            visited[i] = false;
        }
    }

    private static boolean checkNumber() {

        Set<Integer> valueSet = new HashSet<>();
        Set<Integer> indexSet = new HashSet<>();

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                valueSet.add(arr[i]);
                indexSet.add(i + 1);
            }
        }

        return valueSet.equals(indexSet);
    }
}
