package study.week10.P19238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.*;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static Map<Integer, int[]> destinationMap;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        int fuel = parseInt(st.nextToken());

        map = new int[n][n];
        destinationMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        st = new StringTokenizer(br.readLine());

        Driver driver = new Driver(parseInt(st.nextToken()) - 1, parseInt(st.nextToken()) - 1, fuel);

        for (int i = 2; i < 2 + m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = parseInt(st.nextToken());
            int y1 = parseInt(st.nextToken());
            int x2 = parseInt(st.nextToken());
            int y2 = parseInt(st.nextToken());
            map[x1 - 1][y1 - 1] = i;
            destinationMap.put(i, new int[]{x2 - 1, y2 - 1});
        }

        for (int i = 0; i < m; i++) {
            visited = new boolean[n][n];
            if (!choiceCustomer(driver)) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(driver.fuel);
    }

    private static boolean choiceCustomer(Driver driver) {
        int x = driver.x;
        int y = driver.y;

        List<Customer> info = new ArrayList<>();

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});

        int count = 0;

        if (map[x][y] >= 2) {
            info.add(new Customer(x, y, map[x][y], 0));
            count++;
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = now[0] + dx[i];
                int my = now[1] + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= n) {
                    continue;
                }

                if (visited[mx][my] || map[mx][my] == 1) {
                    continue;
                }

                visited[mx][my] = true;

                if (map[mx][my] >= 2) {
                    info.add(new Customer(mx, my, map[mx][my], now[2] + 1));
                    count++;
                }

                if (count == m) {
                    break;
                }

                queue.add(new int[]{mx, my, now[2] + 1});
            }

        }

        if (info.size() == 0) {
            return false;
        }

        info.sort(Comparator.comparing(Customer::getDistance).thenComparing(Customer::getX).thenComparing(Customer::getY));
        return moveTaxi(info.get(0), driver);
    }

    private static boolean moveTaxi(Customer customer, Driver driver) {

        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n][n];
        queue.add(new int[]{customer.x, customer.y, 0});
        int[] destination = destinationMap.get(customer.number);
        map[customer.x][customer.y] = 0;
        visited[customer.x][customer.y] = true;

        int distance = -1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = now[0] + dx[i];
                int my = now[1] + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= n) {
                    continue;
                }

                if (visited[mx][my] || map[mx][my] == 1) {
                    continue;
                }

                visited[mx][my] = true;

                if (mx == destination[0] && my == destination[1]) {
                    distance = now[2] + 1;
                    break;
                }

                queue.add(new int[]{mx, my, now[2] + 1});
            }

        }

        if (distance == -1 || distance + customer.getDistance() > driver.fuel) {
            return false;
        }

        driver.fuel = driver.fuel - distance - customer.getDistance() + 2 * distance;
        driver.x = destination[0];
        driver.y = destination[1];

        return true;
    }
}

class Customer {
    int x;
    int y;
    int number;
    int distance;

    public Customer(int x, int y, int number, int distance) {
        this.x = x;
        this.y = y;
        this.number = number;
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance() {
        return distance;
    }
}

class Driver {
    int x;
    int y;
    int fuel;

    public Driver(int x, int y, int fuel) {
        this.x = x;
        this.y = y;
        this.fuel = fuel;
    }
}
