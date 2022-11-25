package baekjoon_java.programmers.max_min_value;

public class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        String[] strings = s.split(" ");

        int max = Integer.parseInt(strings[0]);
        int min = Integer.parseInt(strings[0]);

        for (String string : strings) {
            int value = Integer.parseInt(string);
            if(value > max){
                max = value;
            }
            if(value < min){
                min = value;
            }
        }

        sb.append(min + " ");
        sb.append(max);

        String answer = sb.toString();
        return answer;
    }
}
