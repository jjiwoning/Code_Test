package Programmers_java.P142085;

import java.util.*;

public class Solution {

    private int n;
    private int k;
    private int[] enemy;

    public int solution(int n, int k, int[] enemy) {
        this.n = n;
        this.k = k;
        this.enemy = enemy;
        return binarySearch();
    }

    private int binarySearch() {
        int start = 0;
        int end = enemy.length;
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            if (isCanDefence(mid)) {
                start = mid + 1;
                continue;
            }
            end = mid;
        }

        return start + 1;
    }

    private boolean isCanDefence(int mid) {
        int[] findArr = new int[mid];
        for (int i = 0; i < mid; i++) {
            findArr[i] = enemy[i];
        }
        Arrays.sort(findArr);
        int now = n;
        for (int i = 0; i < mid; i++) {
            now -= findArr[i];
            if (now < 0) {
                if (k >= mid - i) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1});
        solution.solution(2, 4, new int[]{3, 3, 3, 3});
    }
}
