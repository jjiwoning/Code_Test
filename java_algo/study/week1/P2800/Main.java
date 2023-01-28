package study.week1.P2800;

import java.util.*;

public class Main {
    static String s;
    static boolean[] visited;
    static List<Pair> pairs;
    static Set<String> set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        s = sc.next();

        Stack<Integer> stack = new Stack<>(); // '(' 일때 push ')' 일때 pop
        pairs = new ArrayList<>(); // 괄호 쌍을 저장할 리스트
        visited = new boolean[s.length()]; // 괄호 쌍을 방문했는지 확인하는 용도의 배열
        set = new TreeSet<>(); // 정답을 저장할 Set -> TreeSet은 정렬이 되어 있음

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) + "").equals("(")) {
                stack.add(i); // 스택에는 index 값을 넣어준다.
                continue;
            }
            if ((s.charAt(i) + "").equals(")")) {
                Integer pop = stack.pop(); // 스택을 pop하고 pairs 리스트에 값을 넣어준다.
                pairs.add(new Pair(pop, i));
            }
        }

        dfs(0);

        set.remove(s);

        for (String s1 : set) {
            System.out.println(s1);
        }

    }

    private static void dfs(int level) { // 조합으로 해결 -> 1, 3과 3, 1이 같은 결과를 내므로
        if (level == pairs.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (!visited[i]) {
                    sb.append(s.charAt(i));
                }
            }
            set.add(sb.toString());
            return;
        }

        Pair pair = pairs.get(level); // 체크할 괄호 쌍

        visited[pair.index1] = true; // 제거 대상
        visited[pair.index2] = true;
        dfs(level + 1);

        visited[pair.index1] = false; // 안넣을 대상
        visited[pair.index2] = false;
        dfs(level + 1);
    }

    static class Pair { // 괄호 위치를 담아둘 클래스 선언
        int index1; // '(' index
        int index2; // ')' index

        public Pair(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }
}
