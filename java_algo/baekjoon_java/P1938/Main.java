package baekjoon_java.P1938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {

    // 평지 사이즈
    static int n;
    // 평지 정보 배열
    static int[][] mapInfo;
    // 사방 탐색
    static int[] dx = new int[] {1, -1, 0, 0};
    static int[] dy = new int[] {0, 0, 1, -1};
    // 방문 체크용 Set
    static Set<Node> visitedSet = new HashSet<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        // Input initial
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        mapInfo = new int[n][n];

        // 기둥 정보 받아놓을 배열
        int[] inputXInfo = new int[3];
        int[] inputYInfo = new int[3];
        int index = 0;

        // 맵 배열 정보 저장
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                // start
                if (s.charAt(j) == 'B') {
                    inputXInfo[index] = i;
                    inputYInfo[index] = j;
                    index++;
                    continue;
                }
                // end
                if (s.charAt(j) == 'E') {
                    // -1로 초기화
                    mapInfo[i][j] = -1;
                    continue;
                }
                // wall
                mapInfo[i][j] = s.charAt(j) - '0';
            }
        }

        // 기둥 클래스 생성
        Node node = new Node(inputXInfo[0], inputYInfo[0], inputXInfo[1], inputYInfo[1], inputXInfo[2], inputYInfo[2], 0);

        // 정답 출력
        System.out.println(bfs(node));
    }

    // 탐색을 위한 bfs
    private static int bfs(Node node) {

        // bfs 탐색을 위한 큐 선언 + 시작 값 세팅
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visitedSet.add(node);

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            // 사방 탐색
            for (int i = 0; i < 4; i++) {
                // 위치 정보
                int mx1 = now.x1 + dx[i];
                int mx2 = now.x2 + dx[i];
                int mx3 = now.x3 + dx[i];
                int my1 = now.y1 + dy[i];
                int my2 = now.y2 + dy[i];
                int my3 = now.y3 + dy[i];

                // 이전에 방문한 노드라면 스킵
                if (visitedSet.contains(new Node(mx1, my1, mx2, my2, mx3, my3, 0))) {
                    continue;
                }

                // 범위 밖으로 나가면 스킵
                if (checkOutOfRange(mx1) || checkOutOfRange(mx2) || checkOutOfRange(my1) || checkOutOfRange(my2) || checkOutOfRange(mx3) || checkOutOfRange(my3)) {
                    continue;
                }

                // 움직였는데 벽이 있다면 스킵
                if (checkIsWall(mx1, my1) || checkIsWall(mx2, my2) || checkIsWall(mx3, my3)) {
                    continue;
                }

                // 목적지에 도착 했다면 정답 리턴
                if (mapInfo[mx1][my1] == -1 && mapInfo[mx2][my2] == -1 && mapInfo[mx3][my3] == -1) {
                    return now.count + 1;
                }

                // 다음 탐색
                Node nextNode = new Node(mx1, my1, mx2, my2, mx3, my3, now.count + 1);
                visitedSet.add(nextNode);
                queue.add(nextNode);
            }

            // 회전하는 경우
            if (now.isCanRotate(mapInfo, n)) {
                Node makeNode = now.rotate();
                // 이미 방문한 경우
                if (visitedSet.contains(makeNode)) {
                    continue;
                }
                // 도착지에 도착한 경우
                if (mapInfo[makeNode.x1][makeNode.y1] == -1 && mapInfo[makeNode.x2][makeNode.y2] == -1 && mapInfo[makeNode.x3][makeNode.y3] == -1) {
                    return now.count + 1;
                }
                // 큐에 넣기
                queue.add(makeNode);
            }
        }

        // 도착지에 도착 못하면 0 리턴
        return 0;
    }

    // 범위 체크 함수
    private static boolean checkOutOfRange(int point) {
        if (point < 0 || point >= n) {
            return true;
        }
        return false;
    }

    // 벽 체크 함수
    private static boolean checkIsWall(int x, int y) {
        if (mapInfo[x][y] == 1) {
            return true;
        }
        return false;
    }
}

// 기둥 클래스
class Node {

    // 위치 정보
    int x1;
    int y1;
    int x2;
    int y2;
    int x3;
    int y3;

    int count; // 얼마나 움직였는지

    // 생성자
    public Node(int x1, int y1, int x2, int y2, int x3, int y3, int count) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.count = count;
    }

    // 회전 체크 메서드
    public boolean isCanRotate(int[][] mapInfo, int n) {

        if (x1 == x2 && x2 == x3) {
            int check1 = x1 - 1;
            int check2 = x1 + 1;
            if (check1 < 0 || check1 >= n || check2 < 0 || check2 >= n) {
                return false;
            }
            if (mapInfo[check1][y1] == 1 || mapInfo[check2][y1] == 1 || mapInfo[check1][y2] == 1 || mapInfo[check2][y2] == 1 || mapInfo[check1][y3] == 1 || mapInfo[check2][y3] == 1) {
                return false;
            }
        }

        if (y1 == y2 && y2 == y3) {
            int check1 = y1 - 1;
            int check2 = y1 + 1;
            if (check1 < 0 || check1 >= n || check2 < 0 || check2 >= n) {
                return false;
            }
            if (mapInfo[x1][check1] == 1 || mapInfo[x1][check2] == 1 || mapInfo[x2][check1] == 1 || mapInfo[x2][check2] == 1 || mapInfo[x3][check1] == 1 || mapInfo[x3][check2] == 1) {
                return false;
            }
        }

        return true;
    }

    // 회전 메서드
    public Node rotate() {
        if (x1 == x2 && x2 == x3) {
            return new Node(x2 - 1, y2, x2, y2, x2 + 1, y2, count + 1);
        }

        if (y1 == y2 && y2 == y3) {
            return new Node(x2, y2 - 1, x2, y2, x2, y2 + 1, count + 1);
        }

        throw new IllegalArgumentException();
    }

    // HashSet에 넣기 위한 equals and hashCode
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x1;
        result = prime * result + x2;
        result = prime * result + x3;
        result = prime * result + y1;
        result = prime * result + y2;
        result = prime * result + y3;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (x1 != other.x1)
            return false;
        if (x2 != other.x2)
            return false;
        if (x3 != other.x3)
            return false;
        if (y1 != other.y1)
            return false;
        if (y2 != other.y2)
            return false;
        if (y3 != other.y3)
            return false;
        return true;
    }

}