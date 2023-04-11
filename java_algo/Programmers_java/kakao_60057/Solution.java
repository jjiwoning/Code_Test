package Programmers_java.kakao_60057;

public class Solution {
    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            String find = s.substring(0, i);
            StringBuilder makeString = new StringBuilder();
            int sameCount = 1;
            boolean[] visited = new boolean[s.length()];
            for (int j = 0; j < i; j++) {
                visited[j] = true;
            }
            for (int j = i; j < s.length() - i + 1; j += i) {
                String now = s.substring(j, j + i);
                for (int k = j; k < j + i; k++) {
                    visited[k] = true;
                }
                if (find.equals(now)) {
                    sameCount++;
                }
                if (!find.equals(now)) {
                    if (sameCount > 1) {
                        makeString.append(sameCount).append(find);
                    }
                    if (sameCount == 1) {
                        makeString.append(find);
                    }
                    sameCount = 1;
                    find = now;
                }
            }
            if (sameCount > 1) {
                makeString.append(sameCount).append(find);
            }
            if (sameCount == 1) {
                makeString.append(find);
            }
            for (int j = 0; j < s.length(); j++) {
                if (!visited[j]) {
                    makeString.append(s.charAt(j));
                }
            }
            System.out.println(makeString);
            answer = Math.min(answer, makeString.length());
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution("ababcdcdababcdcd");
        System.out.println(answer);
    }
}
