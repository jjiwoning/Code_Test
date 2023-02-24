package baekjoon_java.P17135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.*;
import static java.lang.Math.abs;
import static java.util.Arrays.*;

public class Main {

    static int n; // n
    static int m; // m
    static int range; // 궁수 화살 범위
    static int[][] map; // 적 정보 담는 맵
    static boolean[][] visited; // 방문 여부 -> 한 사이클에 궁수들이 같은 적을 맞추는 경우를 위해 생성
    static List<int[]> killList; // 한 사이클이 끝나고 난 후 죽일 적들 목록 x, y 좌표 넣어두는 리스트
    static int answer; // 정답 출력 변수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        range = parseInt(st.nextToken());

        int[][] originMap = new int[n][m]; // 기존 맵

        for (int i = 0; i < n; i++) {
            originMap[i] = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        answer = 0;
        map = new int[n][m]; // 복사할 맵

        for (int i = 0; i < m - 2; i++) { // 궁수 위치 경우의 수 탐색
            for (int j = i + 1; j < m - 1; j++) {
                for (int k = j + 1; k < m; k++) {
                    for (int l = 0; l < n; l++) {
                        map[l] = Arrays.copyOf(originMap[l], m); // 메서드 활용해서 복사할 맵에 배열 저장해주기
                    }
                    visited = new boolean[n][m]; // 방문 여부도 다시 초기화
                    bfs(new int[]{i, j, k});
                }
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int[] archers) {
        int count = n; // 얼마나 돌릴지
        int killCount = 0; // 현재 경우의 수 킬 카운트

        while (count > 0) {
            killList = new ArrayList<>(); // 누구 죽는지 저장할 리스트
            for (int archer : archers) { // 궁수 별로 누구 죽여야되는지 탐색
                killCount += selectEnemy(archer); // 적 고르기
            }
            killEnemy(); // 다 탐색이 끝나면 적 죽이기
            moveEnemy(); // 적 이동
            count--; // 다음 탐색을 위해 count--
        }
        answer = max(answer, killCount); // 반복문 나가면 정답 초기화 해주기
    }

    private static int selectEnemy(int archer) {
        for (int minRange = 1; minRange <= range; minRange++) { // 문제 조건 1. 가장 가까운 적
            for (int y = 0; y < m; y++) { // 문제 조건 2. 가장 왼쪽에 있는 적부터
                for (int x = n - 1; x >= 0; x--) { // 이 정도 적었으면 이거는 이해 가능할거라 믿음
                    if (getDistance(archer, x, y) == minRange && map[x][y] == 1) { // 거리가 가장 가까우면서 적이 있는 경우
                        if (!visited[x][y]) { // 방문을 안했다면?
                            visited[x][y] = true; // 방문 하고
                            killList.add(new int[]{x, y}); // 죽일 적에 포함시키고
                            return 1; // 1 리턴 해주기
                        }
                        return 0; // 방문한 적이니 0 리턴 해주기
                        // 리턴하는 이유 -> 반복문 탈출하기 위해서
                    }
                }
            }
        }
        return 0; // 아예 없으면 0 리턴
    }

    private static void killEnemy() {
        for (int[] enemyInfo : killList) {
            map[enemyInfo[0]][enemyInfo[1]] = 0; // 0으로 적 없애기
        }
    }

    private static int getDistance(int archer, int x, int y) {
        return abs(n - x) + abs(archer - y); // 거리 구하기
    }

    private static void moveEnemy() { // 맵 정보랑 방문 정보 아래로 이동 시키기
        for (int i = n - 1; i > 0; i--) {
            map[i] = map[i - 1];
            visited[i] = visited[i - 1];
        }
        map[0] = new int[m];
        visited[0] = new boolean[m];
    }
}
