package Programmers_java.P1845;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int[] nums) {
        return Math.min(Arrays.stream(nums).boxed().collect(Collectors.toSet()).size(), nums.length / 2);
    }
}
