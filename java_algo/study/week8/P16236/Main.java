package study.week8.P16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
 * 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
 * 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
 * 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
 * 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
 */
public class Main {

    static int n;
    static int[][] map;
    static List<int[]> canEatFishList;
    static Shark shark;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st;

        shark = new Shark(-1, -1, 0, 0, 0);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 9) {
                    shark = new Shark(i, j, 2, 0, 0);
                    continue;
                }
                map[i][j] = a;
            }
        }

        findCanEatFish();

        System.out.println(shark.moveCount);
    }

    private static void findCanEatFish() {

        while (true) {
            canEatFishList = new ArrayList<>();

            bfs();

            if (canEatFishList.size() == 0) {
                break;
            }

            int distance = Integer.MAX_VALUE;
            int x = -1;
            int y = -1;

            for (int[] fish : canEatFishList) {
                if (fish[3] < distance) {
                    x = fish[0];
                    y = fish[1];
                    distance = fish[3];
                }

                if (fish[3] == distance) {
                    if (x > fish[0]) {
                        x = fish[0];
                        y = fish[1];
                    }
                    if (x == fish[0] && y > fish[1]) {
                        y = fish[1];
                    }
                }
            }

            shark.eat();
            shark.moveCount += distance;
            shark.x = x;
            shark.y = y;
            map[x][y] = 0;
        }
    }

    private static void bfs() {
        int x = shark.x;
        int y = shark.y;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        visited[x][y] = true;
        queue.add(new int[]{x, y, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = now[0] + dx[i];
                int my = now[1] + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= n) {
                    continue;
                }

                if (visited[mx][my]) {
                    continue;
                }

                if (map[mx][my] > shark.size) {
                    continue;
                }

                visited[mx][my] = true;

                if (map[mx][my] < shark.size && map[mx][my] != 0) {
                    canEatFishList.add(new int[]{mx, my, map[mx][my], now[2] + 1});
                }

                queue.add(new int[]{mx, my, now[2] + 1});
            }
        }
    }

    private static class Shark {
        int x;
        int y;
        int size;
        int eatCount;
        int moveCount;

        public Shark(int x, int y, int size, int eatCount, int moveCount) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.eatCount = eatCount;
            this.moveCount = moveCount;
        }

        public void eat() {
            eatCount++;
            if (eatCount == size) {
                eatCount = 0;
                size++;
            }
        }
    }

}
