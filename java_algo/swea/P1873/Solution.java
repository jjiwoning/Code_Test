package swea.P1873;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int m;
    static char[][] map;
    static int commandCount;
    static int tankX;
    static int tankY;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new char[n][m];
            boolean flag = false;

            for (int i = 0; i < n; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    if (!flag && (map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<')) {
                        tankX = i;
                        tankY = j;
                        flag = true;
                    }
                }
            }

            commandCount = Integer.parseInt(br.readLine());
            String command = br.readLine();

            playGame(0, command);

            sb.append("#").append(testCase).append(" ");
            for (int i = 0; i < n; i++) {
                sb.append(String.valueOf(map[i])).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void playGame(int depth, String command) {
        if (depth == commandCount) {
            return;
        }

        char nowCommand = command.charAt(depth);
        doCommand(nowCommand);
        playGame(depth + 1, command);
    }

    private static void doCommand(char nowCommand) {
        if (nowCommand == 'U') {
            up();
            return;
        }
        if (nowCommand == 'D') {
            down();
            return;
        }
        if (nowCommand == 'L') {
            left();
            return;
        }
        if (nowCommand == 'R') {
            right();
            return;
        }
        if (nowCommand == 'S') {
            shoot();
            return;
        }
        throw new IllegalArgumentException("doCommand(): 유효하지 않은 입력값");
    }

    private static void up() {
        map[tankX][tankY] = '^';
        if (tankX - 1 >= 0 && map[tankX - 1][tankY] == '.') {
            map[tankX - 1][tankY] = '^';
            map[tankX][tankY] = '.';
            tankX--;
        }
    }

    private static void down() {
        map[tankX][tankY] = 'v';
        if (tankX + 1 < n && map[tankX + 1][tankY] == '.') {
            map[tankX + 1][tankY] = 'v';
            map[tankX][tankY] = '.';
            tankX++;
        }
    }

    private static void left() {
        map[tankX][tankY] = '<';
        if (tankY - 1 >= 0 && map[tankX][tankY - 1] == '.') {
            map[tankX][tankY - 1] = '<';
            map[tankX][tankY] = '.';
            tankY--;
        }
    }

    private static void right() {
        map[tankX][tankY] = '>';
        if (tankY + 1 < m && map[tankX][tankY + 1] == '.') {
            map[tankX][tankY + 1] = '>';
            map[tankX][tankY] = '.';
            tankY++;
        }
    }

    private static void shoot() {
        char direction = map[tankX][tankY];
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        int directionInt = directionToInt(direction);

        int shootX = tankX;
        int shootY = tankY;
        while (true) {
            shootX += dx[directionInt];
            shootY += dy[directionInt];
            if (shootX < 0 || shootX >= n || shootY < 0 || shootY >= m) {
                break;
            }
            if (map[shootX][shootY] == '*') {
                map[shootX][shootY] = '.';
                break;
            }
            if (map[shootX][shootY] == '#') {
                break;
            }
        }
    }

    private static int directionToInt(char direction) {
        if (direction == 'v') {
            return 0;
        }
        if (direction == '^') {
            return 1;
        }
        if (direction == '>') {
            return 2;
        }
        if (direction == '<') {
            return 3;
        }
        throw new IllegalArgumentException("directionToInt(): 유효하지 않은 입력값");
    }
}

//        문자	동작
//        U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
//        D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
//        L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
//        R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
//        S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.