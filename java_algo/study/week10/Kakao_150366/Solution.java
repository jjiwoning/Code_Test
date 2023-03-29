package study.week10.Kakao_150366;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<String> list = new ArrayList<>();
    int[][] parent = new int[50][50];
    String[][] cell = new String[50][50];

    public String[] solution(String[] commands) {

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                parent[i][j] = i * 50 + j;
            }
        }

        for (String command : commands) {
            String[] s = command.split(" ");
            if (s[0].equals("UPDATE")) {
                if (s.length == 4) {
                    updateIndex(s);
                    continue;
                }
                if (s.length == 3) {
                    updateValue(s);
                    continue;
                }
            }

            if (s[0].equals("MERGE")) {
                mergeCell(s);
                continue;
            }

            if (s[0].equals("UNMERGE")) {
                unmergeCell(s);
                continue;
            }

            if (s[0].equals("PRINT")) {
                printCell(s);
            }

        }
        return list.toArray(new String[0]);
    }

    private void printCell(String[] s) {
        int x = Integer.parseInt(s[1]) - 1;
        int y = Integer.parseInt(s[2]) - 1;
        int value = find(x * 50 + y);
        if (cell[value / 50][value % 50] == null) {
            list.add("EMPTY");
            return;
        }
        list.add(cell[value / 50][value % 50]);
    }

    private void unmergeCell(String[] s) {
        int x = Integer.parseInt(s[1]) - 1;
        int y = Integer.parseInt(s[2]) - 1;
        int value = x * 50 + y;
        int parentVal = find(value);
        String fix = cell[parentVal / 50][parentVal % 50];
        cell[x][y] = fix;
        List<int[]> deleteList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (i == x && j == y) {
                    continue;
                }
                if (isSameParent(value, i * 50 + j)) {
                    deleteList.add(new int[]{i, j});
                    cell[i][j] = null;
                }
            }
        }
        for (int[] ints : deleteList) {
            parent[ints[0]][ints[1]] = ints[0] * 50 + ints[1];
        }
        parent[x][y] = x * 50 + y;
    }

    private void mergeCell(String[] s) {
        int x1 = Integer.parseInt(s[1]) - 1;
        int y1 = Integer.parseInt(s[2]) - 1;
        int value1 = x1 * 50 + y1;

        int x2 = Integer.parseInt(s[3]) - 1;
        int y2 = Integer.parseInt(s[4]) - 1;
        int value2 = x2 * 50 + y2;

        if (isSameParent(value1, value2)) {
            return;
        }

        union(value1, value2);

    }

    private void updateValue(String[] s) {
        String target = s[1];
        String change = s[2];
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (target.equals(cell[i][j])) {
                    cell[i][j] = change;
                }
            }
        }
    }

    private void updateIndex(String[] s) {
        int x = Integer.parseInt(s[1]) - 1;
        int y = Integer.parseInt(s[2]) - 1;
        String change = s[3];
        int parentVal = find(x * 50 + y);
        cell[parentVal / 50][parentVal % 50] = change;
    }

    private int find(int value) {
        int x = value / 50;
        int y = value % 50;
        if (parent[x][y] == value) {
            return value;
        }
        return parent[x][y] = find(parent[x][y]);
    }

    private void union(int value1, int value2) {
        value1 = find(value1);
        value2 = find(value2);

        if (cell[value1 / 50][value1 % 50] == null) {
            parent[value1 / 50][value1 % 50] = value2;
            return;
        }
        if (cell[value2 / 50][value2 % 50] == null) {
            parent[value2 / 50][value2 % 50] = value1;
            return;
        }
        parent[value2 / 50][value2 % 50] = value1;
        cell[value2 / 50][value2 % 50] = null;
    }

    private boolean isSameParent(int value1, int value2) {
        return find(value1) == find(value2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"});
    }
}
