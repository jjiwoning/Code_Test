package study.week2.P7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static Queue<int[]> queue; // bfs를 실행할 큐
    static int[][] box;
    static int[] dx = new int[]{1, -1, 0, 0}; // 상하좌우
    static int[] dy = new int[]{0, 0, 1, -1};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[1]);
        m = Integer.parseInt(s[0]);

        box = new int[n][m];
        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int tomato = Integer.parseInt(s1[j]);
                if (tomato == 1) {
                    queue.add(new int[]{i, j}); // 값이 1인 지점에서 bfs를 돌아야한다. -> 미리 큐에 인덱스 값을 넣어둔다.
                }
                box[i][j] = tomato;
            }
        }

        bfs();

        System.out.println(getAnswer());
    }

    private static int getAnswer() {
        int answer = 0;
        boolean check = true;

        for (int[] ints : box) {
            for (int i : ints) {
                if (i == 0) { // 박스에 0이 있는 경우 -> 모든 토마토가 익지 않은 상태 -> 답이 -1이 나와야 한다.
                    answer = 0;
                    check = false; // check 필드에 false를 주어 for문 탈출할 수 있게 세팅
                    break;
                }
                answer = Math.max(answer, i); // 토마토가 익는데 며칠이 걸리는지 구하려면 최대값을 구해야 된다.
            }
            if (!check) {
                break;
            }
        }
        return --answer; // bfs에서 값을 더해주는 과정을 0에서 시작하지 않고 1에서 시작했기 때문에 값에서 1을 빼줘야 한다.
    }

    private static void bfs() {
        while (!queue.isEmpty()) { // 탈출 조건: 큐에 값이 없으면 탈출
            int[] index = queue.poll(); // 큐의 맨 앞의 값을 꺼낸다.
            int x = index[0];
            int y = index[1];

            for (int i = 0; i < 4; i++) { // 상하좌우 탐색
                int mx = x + dx[i];
                int my = y + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= m) { // 박스 범위에 벗어나는 경우 탈출
                    continue;
                }

                if (box[mx][my] == 0) { // 이 경우 토마토가 익어야 한다.
                    queue.add(new int[]{mx, my});
                    box[mx][my] = box[x][y] + 1; // 이전 토마토에서 1 더한 값을 넣어줘야 한다.
                }
            }
        }
    }
}
