package Programmers_java.secretmap;

import java.util.Arrays;

public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = "";
        }

        int[][] arr1Map = findBinary(arr1, n);
        int[][] arr2Map = findBinary(arr2, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr1Map[i][j] == 1 || arr2Map[i][j] == 1) {
                    answer[i] += '#';
                } else {
                    answer[i] += ' ';
                }
            }
        }

        return answer;
    }

    static int[][] findBinary(int[] arr, int n) {
        int[][] findMap = new int[n][n];
        int idx = 0;
        for (int i : arr) {
            String find = Integer.toBinaryString(i);
            if (find.length() != n) {
                int need = n - find.length();
                for (int j = 0; j < need; j++) {
                    find = "0" + find;
                }
            }
            char[] findCharArray = find.toCharArray();
            for (int j = 0; j < n; j++) {
                int number = findCharArray[j] - '0';
                findMap[idx][j] = number;
            }
            idx++;
        }
        return findMap;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {9, 20, 28, 18, 11};
        int[] arr1 = {30, 1, 21, 17, 28};
        Solution solution = new Solution();
        String[] answer = solution.solution(n, arr, arr1);
        System.out.println(Arrays.toString(answer));
    }
}
