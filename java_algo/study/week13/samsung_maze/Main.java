package study.week13.samsung_maze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static List<Person> personList;
    static int[][] maze;
    static Exit exit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        maze = new int[n][n];
        personList = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            maze[x][y] = -2; // human Info
            personList.add(new Person(x, y, 0));
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;
        maze[x][y] = -1 ; // exit Info
        exit = new Exit(x, y);

        for (int i = 0; i < k; i++) {
            if (personList.isEmpty()) {
                break;
            }
            for (Person person : personList) {
                int moveIndex = exit.canMove(person, n, maze);
                if (moveIndex >= 0) {
                    maze[person.x][person.y] = 0;
                    person.move(moveIndex);
                    answer++;
                }
            }
            List<Person> removeList = new ArrayList<>();
            for (Person person : personList) {
                if (person.x == exit.x && person.y == exit.y) {
                    removeList.add(person);
                    continue;
                }
                maze[person.x][person.y] = -2;
            }
            personList.removeAll(removeList);
            rotate(getRotateArea());
        }

        System.out.println(answer);
        System.out.println(exit.toString());
    }

    private static int[] getRotateArea() {
        int[] rotateArea = new int[]{0, 0, 0}; // 0: start X, 1: start Y, 2: size
        for (int areaRange = 1; areaRange < n; areaRange++) {
            for (int r = 0; r < n - areaRange; r++) {
                for (int c = 0; c < n - areaRange; c++) {
                    if (!(r <= exit.x && exit.x <= r + areaRange && c <= exit.y && exit.y <= c + areaRange)) {
                        continue;
                    }

                    for (Person person : personList) {
                        if (person.x == exit.x && person.y == exit.y) {
                            continue;
                        }
                        if (r <= person.x && person.x <= r + areaRange && c <= person.y && person.y <= c + areaRange) {
                            return new int[]{r, c, areaRange + 1};
                        }
                    }

                }
            }
        }
        return rotateArea;
    }

    private static void rotate(int[] rotateArea) {
        int startX = rotateArea[0];
        int startY = rotateArea[1];
        int size = rotateArea[2];
        int[][] rotateMap = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotateMap[i][j] = maze[i][j];
            }
        }
        List<Person> editPersonList = new ArrayList<>();
        List<int[]> editPersonIndex = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int num = maze[startX + i][startY + j] - 1;
                if (num == -2) {
                    exit.x = startX + j;
                    exit.y = startY + size - i - 1;
                    rotateMap[startX + j][startY + size - i - 1] = -1;
                    continue;
                }

                if (num == -3) {
                    for (Person person : personList) {
                        if (person.x == startX + i && person.y == startY + j) {
                            editPersonList.add(person);
                            editPersonIndex.add(new int[]{startX + j, startY + size - i - 1});
                            rotateMap[startX + j][startY + size - i - 1] = -2;
                        }
                    }
                    continue;
                }
                rotateMap[startX + j][startY + size - i - 1] = Math.max(0, num);

            }
        }

        for (int i = 0; i < editPersonList.size(); i++) {
            Person person = editPersonList.get(i);
            person.x = editPersonIndex.get(i)[0];
            person.y = editPersonIndex.get(i)[1];
        }

        maze = rotateMap;
    }
}

class Person {
    int x;
    int y;
    int moveCount;

    public Person(int x, int y, int moveCount) {
        this.x = x;
        this.y = y;
        this.moveCount = moveCount;
    }

    public void move(int moveIndex) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        this.x += dx[moveIndex];
        this.y += dy[moveIndex];
        this.moveCount++;
    }
}

class Exit {
    int x;
    int y;

    public Exit(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDistance(Person person) {
        return Math.abs(this.x - person.x) + Math.abs(this.y - person.y);
    }

    public int getDistance(int x, int y) {
        return Math.abs(this.x - x) + Math.abs(this.y - y);
    }

    public int canMove(Person person, int n, int[][] maze) {

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int nowDistance = getDistance(person);

        for (int i = 0; i < 4; i++) {
            // up, down, right, left check
            int mx = person.x + dx[i];
            int my = person.y + dy[i];

            if (mx < 0 || mx >= n || my < 0 || my >= n) {
                continue;
            }

            if (maze[mx][my] > 0) {
                continue;
            }

            if (nowDistance > getDistance(mx, my)) {
                return i;
            }
        }
        return -1; // can not move
    }

    @Override
    public String toString() {
        return (x + 1) + " " + (y + 1);
    }
}
