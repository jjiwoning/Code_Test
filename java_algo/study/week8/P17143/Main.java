package study.week8.P17143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static Shark[][] sharkInfo;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        sharkInfo = new Shark[n][m];

        int totalSharkSize = 0;

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken()); // 속력
            int d = Integer.parseInt(st.nextToken()); // 방향
            int z = Integer.parseInt(st.nextToken()); // 크기
            sharkInfo[r - 1][c - 1] = new Shark(s, d, z);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (sharkInfo[j][i] != null) {
                    totalSharkSize += sharkInfo[j][i].z;
                    sharkInfo[j][i] = null;
                    break;
                }
            }
            moveShark();
        }

        System.out.println(totalSharkSize);
    }

    private static void moveShark() {

        Shark[][] afterShark = new Shark[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (sharkInfo[i][j] != null) {
                    findDestination(afterShark, i, j);
                }
            }
        }

        sharkInfo = afterShark;
    }

    private static void findDestination(Shark[][] afterShark, int x, int y) {
        Shark shark = sharkInfo[x][y];
        for (int i = 0; i < shark.s; i++) {
            if (x + dx[shark.d] < 0 || x + dx[shark.d] >= n || y + dy[shark.d] < 0 || y + dy[shark.d] >= m) {
                shark.changeD();
            }

            x += dx[shark.d];
            y += dy[shark.d];
        }

        if (afterShark[x][y] != null && afterShark[x][y].z > shark.z) {
            return;
        }
        afterShark[x][y] = shark;
    }

    static class Shark {
        int s;
        int d;
        int z;

        public Shark(int s, int d, int z) {
            this.s = s;
            this.d = d;
            this.z = z;
        }

        public void changeD() {
            if (this.d == 1 || this.d == 3) {
                this.d++;
                return;
            }
            this.d--;
        }
    }
}
