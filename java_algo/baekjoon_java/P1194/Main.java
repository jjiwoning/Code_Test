package baekjoon_java.P1194;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[64][n][m];

        int x = -1;
        int y = -1;

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '0') {
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println(bfs(x, y));
    }

    private static int bfs(int startX, int startY) {
        Queue<Person> queue = new LinkedList<>();
        queue.add(new Person(startX, startY, 0, 0));
        visited[0][startX][startY] = true;

        while (!queue.isEmpty()) {
            Person person = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = person.x + dx[i];
                int my = person.y + dy[i];
                int keyBit = person.keyBit;

                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    continue;
                }

                if (visited[person.keyBit][mx][my]) {
                    continue;
                }

                if (map[mx][my] == '#') {
                    continue;
                }

                if (map[mx][my] == '1') {
                    return person.count + 1;
                }

                if (map[mx][my] >= 'a' && map[mx][my] <= 'f') {
                    keyBit |= (1 << map[mx][my] - 'a');
                }

                if (map[mx][my] >= 'A' && map[mx][my] <= 'F') {
                    if ((keyBit & (1 << map[mx][my] - 'A')) == 0) {
                        continue;
                    }
                }

                visited[keyBit][mx][my] = true;
                queue.add(new Person(mx, my, person.count + 1, keyBit));
            }
        }

        return -1;
    }

    static class Person {
        int x;
        int y;
        int count;
        int keyBit;

        public Person(int x, int y, int count, int keyBit) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.keyBit = keyBit;
        }
    }
}
