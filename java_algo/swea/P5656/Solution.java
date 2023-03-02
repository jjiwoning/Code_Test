package swea.P5656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int n; // 구슬 몇 개 던지는지
    static int x;
    static int y;
    static int[][] map; // 구슬 정보 저장
    static boolean[][] visited; // 방문 체크
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder output = new StringBuilder();

        for (int testCase = 1; testCase < t + 1; testCase++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            map = new int[x][y];

            for (int i = 0; i < x; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            answer = Integer.MAX_VALUE;

            visited = new boolean[x][y];

            dfs(0);

            output.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        System.out.println(output);
    }

    private static void dfs(int depth) {
        if (depth == n) { // 구슬을 다 던졌으면
            getAnswer(); // 몇 개 남았는지 확인하기
            return;
        }

        for (int i = 0; i < y; i++) {
            int[][] rememberMap = map; // 기억을 해둬야 다음 dfs할 때 문제 발생 안 함.
            findBreakMarblePoint(i); // 어디서부터 구슬을 박살낼지 찾는 메서드
            dfs(depth + 1); // 다음 탐색
            map = rememberMap; // 맵 정보 원상 복구
        }
    }

    private static void getAnswer() {
        int count = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (map[i][j] > 0) { // 이 경우 구슬이 살아있음
                    count++;
                }
            }
        }
        answer = Math.min(answer, count); // 더 작은 값으로 초기화
    }

    private static void findBreakMarblePoint(int startY) {

        int startX = -1; // 시작 점 찾기

        for (int i = 0; i < x; i++) {
            if (map[i][startY] > 0) {
                startX = i; // 시작 점 찾음
                break; // 탈출
            }
        }

        if (startX == -1) { // 여기 구슬은 다 박살난 상태 -> 리턴 해준다
            return;
        }

        breakMarble(new Marble(startX, startY, map[startX][startY])); // 시작 점 기준으로 구슬 박살내기
    }

    private static void breakMarble(Marble marble) {
        Queue<Marble> queue = new LinkedList<>();
        queue.add(marble); // 큐에 시작 점 넣어주기
        visited[marble.x][marble.y] = true; // 방문 체크

        while (!queue.isEmpty()) {
            Marble now = queue.poll();
            for (int i = 0; i < 4; i++) { // 상하좌우로
                for (int j = 1; j < now.range; j++) { // 구슬에 적힌 범위 만큼 박살
                    int mx = now.x + j * dx[i];
                    int my = now.y + j * dy[i];

                    if (mx < 0 || mx >= x || my < 0 || my >= y) { // 맵 벗어나는지 체크
                        continue;
                    }

                    if (visited[mx][my]) { // 방문 했으면 넘어감
                        continue;
                    }

                    visited[mx][my] = true; // 방문 체크
                    if (map[mx][my] > 1) {
                        queue.add(new Marble(mx, my, map[mx][my])); // 구슬이 1이면 혼자 터지지만 1을 넘어가면 다른 구슬을 터트림
                    }
                }
            }
        }

        clearMap(); // 박살난 구슬을 바탕으로 맵 정리하기
    }

    private static void clearMap() {

        int[][] newMap = new int[x][y]; // 다시 생성할 맵

        for (int i = 0; i < y; i++) {
            int index = x - 1;
            for (int j = x - 1; j >= 0; j--) {
                if (map[j][i] != 0 && !visited[j][i]) {
                    newMap[index--][i] = map[j][i]; // 배열 아래서부터 차곡차곡 쌓기
                }
            }
        }

        map = newMap; // map에 다시 생성한 맵 넣어주기
        visited = new boolean[x][y]; // 방문체크도 다시 초기화
    }

    private static class Marble { // 구슬 클래스
        int x;
        int y;
        int range; // 터지는 범위

        public Marble(int x, int y, int range) {
            this.x = x;
            this.y = y;
            this.range = range;
        }
    }
}
