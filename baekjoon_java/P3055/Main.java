package baekjoon_java.P3055;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int R, C;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0 , 0, -1, 1};
    static char[][] map;
    static int[][] dp;
    static Queue<Point> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R][C];
        dp = new int[R][C];
        queue = new LinkedList<>(); // 자바에서 큐는 이거로 쓴다.
        int ansX = 0, ansY = 0;

        // 데이터 입력 로직
        Point st = null; // 고슴도치 위치를 저장해줄 객체 변수 미리 선언
        for (int i = 0; i < R; i++) {
            String s = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == '*'){
                    queue.add(new Point(j, i, '*')); // 물 위치를 먼저 넣어줘야 된다.
                }else if(map[i][j] == 'S'){
                    st = new Point(j, i, 'S'); // 고슴도치의 위치를 먼저 넣으면 안되기 때문에 미리 할당한 객체 변수에 넣어줌
                }else if(map[i][j] == 'D'){
                    ansY = i;
                    ansX = j;
                }
            }
        }

        queue.add(st); // 고슴도치 add -> 물, 고슴도치 순서로 잘 넣어짐

        bfs();

        if(dp[ansY][ansX] != 0){ // 답이 있는 경우
            System.out.println(dp[ansY][ansX]);
        }else{
            System.out.println("KAKTUS"); // 답이 없는 경우
        }

    }

    static void bfs(){
        while(!queue.isEmpty()){
            // 1. 큐에서 꺼냄 -> 나오는 데이터 : 'S', '*', '.', 'D'
            Point p = queue.poll();
            // 2. 목적지 인지 확인 -> 목적지 : 'D'
            if(p.type == 'D'){
                break;
            }
            // 3. 연결된 곳 순회 -> dx[0], dy[0] ~ 3까지 4방향
            for (int i = 0; i < 4; i++) {
                int mx = p.x + dx[i];
                int my = p.y + dy[i];
                // 4. 갈 수 있나 -> 이동할 위치가 . 인가 + 맵에서 안벗어나는가 (물을 큐에 먼저 넣어줘서 해당 조건은 무시해도 된다.)
                // 4. 갈 수 있나 (공통) : 맵 안에 들어오는가
                if(my >= 0 && my < R && mx >= 0 && mx < C){
                    if(p.type == 'S' || p.type == '.'){
                        // 4. 갈 수 있나 (고슴도치) : '.' + 'D'
                        if((map[my][mx] == '.' || map[my][mx] == 'D') && dp[my][mx] == 0){
                            // 5. 체크인 (고슴도치) -> dp[][] 배열에 이동거리 저장
                            dp[my][mx] = dp[p.y][p.x] + 1;
                            // 6. 큐에 넣음
                            queue.add(new Point(mx, my, map[my][mx]));
                        }
                    } else if (p.type == '*') {
                        // 4. 갈 수 있나 (물) : '.'
                        if(map[my][mx] == '.'|| map[my][mx] == 'S'){
                            // 5. 체크인 (물) -> map[][]에 방문한 '.' => '*' 로 변경
                            map[my][mx] = '*';
                            // 6. 큐에 넣음
                            queue.add(new Point(mx, my, '*'));
                        }
                    }
                }

            }

        }
    }

    static class Point{
        // 큐에 넣을 객체
        int x;
        int y;
        char type;

        public Point(int x, int y, char type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
