package study.week3.P17129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static Queue<int[]> queue;
    static int[][] map;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        map = new int[n][m];

        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String s1 = br.readLine();
            for (int j = 0; j < m; j++) {
                int input = s1.charAt(j) - '0';
                if (input == 2) {
                    map[i][j] = 0;
                    queue.add(new int[]{i, j}); // 시작점을 큐에 넣어준다.
                    continue;
                }

                if (input >= 3) {
                    map[i][j] = input * -1; // 음수로 값을 넣어줘서 map 배열에 visited 설정 및 얼마나 갔는지 설정할 수 있게하기
                    continue;
                }

                if (input == 1) {
                    map[i][j] = -1;
                    continue;
                }

                map[i][j] = input; // 0

            }
        }

        int answer = bfs();

        if (answer == -1) {
            System.out.println("NIE");
        } else {
            System.out.println("TAK");
            System.out.println(answer);
        }
    }

    private static int bfs() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int mx = now[0] + dx[i];
                int my = now[1] + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    continue;
                }

                if (map[mx][my] == -1) {
                    continue;
                }

                if (map[mx][my] <= -3) {
                    return map[now[0]][now[1]] + 1; // 3 4 5 에 접근하는 순간이 답이다.
                }

                if (map[mx][my] == 0) {
                    map[mx][my] = map[now[0]][now[1]] + 1; // 0이면 방문 x -> 이동
                    queue.add(new int[]{mx, my});
                }
            }
        }

        return -1;
    }
}
