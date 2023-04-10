package baekjoon_java.P16919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        char[][] firstMap = new char[n][m]; // 초기 맵
        char[][] fullMap = new char[n][m];

        for (int i = 0; i < n; i++) {
            firstMap[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                fullMap[i][j] = 'O';
            }
        }

        if (time == 1) {
            printMap(firstMap);
            return;
        }

        if (time % 2 == 0) {
            printMap(fullMap);
            return;
        }

        if (time % 4 == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (firstMap[i][j] == 'O') {
                        bomb(i, j, fullMap);
                    }
                }
            }
            printMap(fullMap);
            return;
        }

        if (time % 4 == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (firstMap[i][j] == 'O') {
                        bomb(i, j, fullMap);
                    }
                }
            }
            firstMap = fullMap.clone();
            fullMap = new char[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    fullMap[i][j] = 'O';
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (firstMap[i][j] == 'O') {
                        bomb(i, j, fullMap);
                    }
                }
            }
            printMap(fullMap);
        }

    }

    private static void bomb(int x, int y, char[][] map) {
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        map[x][y] = '.';

        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx < 0 || mx >= n || my < 0 || my >= m) {
                continue;
            }
            map[mx][my] = '.';
        }
    }

    private static void printMap(char[][] map) {
        for (int i = 0; i < n; i++) {
            System.out.println(new String(map[i]));
        }
    }
}
