package Programmers_java.P159994;

public class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0;
        int index2 = 0;
        for (String s : goal) {
            if (index1 < cards1.length && cards1[index1].equals(s)) {
                index1++;
                continue;
            }
            if (index2 < cards2.length && cards2[index2].equals(s)) {
                index2++;
                continue;
            }
            return "No";
        }
        return "Yes";
    }
}
