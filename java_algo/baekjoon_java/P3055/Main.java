package baekjoon_java.P3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int r;
    static int c;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] visited;
    static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        queue = new LinkedList<>();

        Point point = null;
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == '*'){
                    queue.add(new Point(i, j, '*', 0));
                }
                if(map[i][j] == 'S'){
                    point = new Point(i, j, 'S', 0);
                }
            }
        }

        queue.add(point);

        int answer = bfs();

        if (answer == -1) {
            System.out.println("KAKTUS");
            return;
        }
        System.out.println(answer);

    }

    private static int bfs(){
        while(!queue.isEmpty()){

            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = p.x + dx[i];
                int my = p.y + dy[i];

                if (mx < 0 || mx >= r || my < 0 || my >= c) {
                    continue;
                }

                if (p.type == 'S' || p.type == '.') {

                    if (map[mx][my] == 'D') {
                        return p.cost + 1;
                    }

                    if (map[mx][my] == '.' && !visited[mx][my]) {
                        visited[mx][my] = true;
                        queue.add(new Point(mx, my, p.type, p.cost + 1));
                    }
                }

                if (p.type == '*') {
                    if (map[mx][my] == '.' || map[mx][my] == 'S') {
                        map[mx][my] = '*';
                        queue.add(new Point(mx, my, '*', p.cost));
                    }
                }

            }

        }

        return -1;
    }

    private static class Point{
        int x;
        int y;
        char type;
        int cost;

        public Point(int x, int y, char type, int cost) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.cost = cost;
        }
    }
}
