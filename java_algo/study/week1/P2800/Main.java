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

        Stack<Integer> stack = new Stack<>();
        pairs = new ArrayList<>();
        visited = new boolean[s.length()];
        set = new TreeSet<>();

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) + "").equals("(")) {
                stack.add(i);
                continue;
            }
            if ((s.charAt(i) + "").equals(")")) {
                Integer pop = stack.pop();
                pairs.add(new Pair(pop, i));
            }
        }

        dfs(0);

        set.remove(s);

        for (String s1 : set) {
            System.out.println(s1);
        }

    }

    private static void dfs(int level) {
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

        Pair pair = pairs.get(level);
        visited[pair.index1] = true;
        visited[pair.index2] = true;
        dfs(level + 1);

        visited[pair.index1] = false;
        visited[pair.index2] = false;
        dfs(level + 1);
    }

    static class Pair {
        int index1;
        int index2;

        public Pair(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }
}
