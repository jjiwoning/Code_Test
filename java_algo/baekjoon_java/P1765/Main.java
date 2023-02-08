package baekjoon_java.P1765;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static int[] friends;
    static List<List<Integer>> lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        friends = new int[n + 1];
        friends[0] = -100;
        lists = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            friends[i] = i;
        }

        for (int i = 0; i < n + 1; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[1]);
            int y = Integer.parseInt(s[2]);
            if (s[0].equals("E")) {
                lists.get(x).add(y);
                lists.get(y).add(x);
            }
            if (s[0].equals("F")) {
                friendsUnion(x, y);
            }
        }

        for (List<Integer> list : lists) {
            if (list.size() < 2) {
                continue;
            }
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    friendsUnion(list.get(i), list.get(j));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            friendsFind(i);
        }

        Set<Integer> set = new HashSet<>();

        for (int friend : friends) {
            set.add(friend);
        }

        System.out.println(set.size() - 1);
    }

    private static int friendsFind(int num) {
        if (num == friends[num]) {
            return num;
        }

        return friends[num] = friendsFind(friends[num]);
    }

    private static void friendsUnion(int x, int y) {
        x = friendsFind(x);
        y = friendsFind(y);
        if (x != y) {
            // 부모가 다른 경우
            // x, y 중 더 작은 값을 부모로 두어야 한다.
            if (x < y) {
                friends[y] = x;
            }
            if (x > y) {
                friends[x] = y;
            }
        }
    }
}
