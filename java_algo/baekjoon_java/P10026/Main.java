package baekjoon_java.P10026;

import java.util.Scanner;

// 다른 사람의 풀이: 사람 dfs -> color R -> G로 변경후 다시 dfs
// 내 풀이: 사람 dfs, 색맹 dfs 따로 메서드 생성
public class Main {

    static boolean[][] checked;
    static boolean[][] rgChecked;
    static char[][] color;
    static char[] type = {'R', 'G', 'B'};
    static int n;
    static int count;
    static int rgCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        checked = new boolean[n][n];
        rgChecked = new boolean[n][n];
        color = new char[n][n];
        count = 0;
        rgCount = 0;

        for (int i = 0; i < n; i++) {
            String next = sc.next();
            color[i] = next.toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (char c : type) {
                    if (dfs(c, i, j)) {
                        count++;
                    }
                    if (rgDfs(c, i, j)) {
                        rgCount++;
                    }
                }
            }
        }

        System.out.println(count + " " + rgCount);
    }

    private static boolean rgDfs(char type, int x, int y) {
        // 적록색약 -> 빨간색 == 초록색
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }

        if (!rgChecked[x][y]) {
            if ((type == 'R' || type == 'G') && (color[x][y] == 'R' || color[x][y] == 'G')) {
                rgChecked[x][y] = true;
                rgDfs(type, x + 1, y);
                rgDfs(type, x - 1, y);
                rgDfs(type, x, y + 1);
                rgDfs(type, x, y - 1);
                return true;
            }
            if (color[x][y] == type) {
                rgChecked[x][y] = true;
                rgDfs(type, x + 1, y);
                rgDfs(type, x - 1, y);
                rgDfs(type, x, y + 1);
                rgDfs(type, x, y - 1);
                return true;
            }
        }

        return false;
    }

    private static boolean dfs(char type, int x, int y) {
        // 적록색약 -> 빨간색 == 초록색
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }

        if (!checked[x][y] && color[x][y] == type) {
            checked[x][y] = true;
            dfs(type, x + 1, y);
            dfs(type, x - 1, y);
            dfs(type, x, y + 1);
            dfs(type, x, y - 1);
            return true;
        }

        return false;
    }
}
