package baekjoon_java.P5373;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    static char[][][] cube;
    static char[] color = new char[]{'w', 'y', 'r', 'o', 'g', 'b'};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            setCube(); // 0: 위, 1: 아래, 2: 앞, 3: 뒤, 4: 왼, 5: 오른
            br.readLine();
            String[] commands = br.readLine().split(" ");
            for (String command : commands) {
                doCommand(command);
            }

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.print(cube[0][j][k]);
                }
                System.out.println();
            }
        }
    }

    private static void setCube() {
        cube = new char[6][3][3];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    cube[i][j][k] = color[i];
                }
            }
        }

    }

    private static void doCommand(String command) {
        if ("U+".equals(command)) {
            uClockwiseTurning();
            return;
        }
        if ("U-".equals(command)) {
            uCounterclockwiseTurning();
            return;
        }
        if ("D+".equals(command)) {
            dClockwiseTurning();
            return;
        }
        if ("D-".equals(command)) {
            dCounterclockwiseTurning();
            return;
        }
        if ("F+".equals(command)) {
            fClockwiseTurning();
            return;
        }
        if ("F-".equals(command)) {
            fCounterclockwiseTurning();
            return;
        }
        if ("B+".equals(command)) {
            bClockwiseTurning();
            return;
        }
        if ("B-".equals(command)) {
            bCounterclockwiseTurning();
            return;
        }
        if ("L+".equals(command)) {
            lClockwiseTurning();
            return;
        }
        if ("L-".equals(command)) {
            lCounterclockwiseTurning();
            return;
        }
        if ("R+".equals(command)) {
            rClockwiseTurning();
            return;
        }
        if ("R-".equals(command)) {
            rCounterclockwiseTurning();
            return;
        }
    }


    private static void uClockwiseTurning() {
        // 0: 위, 1: 아래, 2: 앞, 3: 뒤, 4: 왼, 5: 오른
        LinkedList<Character> list = new LinkedList<>();
        int[] inputCycle = new int[]{3, 5, 2, 4};
        for (int i : inputCycle) {
            for (int j = 2; j > -1; j--) {
                list.add(cube[i][0][j]);
            }
        }
        for (int i = 0; i < 3; i++) {
            list.addFirst(list.pollLast());
        }
        for (int i : inputCycle) {
            for (int j = 2; j > -1; j--) {
                cube[i][0][j] = list.poll();
            }
        }
        turnMySide(0, 1);
    }

    private static void uCounterclockwiseTurning() {
        // 0: 위, 1: 아래, 2: 앞, 3: 뒤, 4: 왼, 5: 오른
        LinkedList<Character> list = new LinkedList<>();
        int[] inputCycle = new int[]{3, 4, 2, 5};
        for (int i : inputCycle) {
            for (int j = 0; j < 3; j++) {
                list.add(cube[i][0][j]);
            }
        }
        for (int i = 0; i < 3; i++) {
            list.addFirst(list.pollLast());
        }
        for (int i : inputCycle) {
            for (int j = 0; j < 3; j++) {
                cube[i][0][j] = list.poll();
            }
        }
        turnMySide(0, 2);
    }

    private static void dClockwiseTurning() {
        // 0: 위, 1: 아래, 2: 앞, 3: 뒤, 4: 왼, 5: 오른
        LinkedList<Character> list = new LinkedList<>();
        int[] inputCycle = new int[]{3, 4, 2, 5};
        for (int i : inputCycle) {
            for (int j = 0; j < 3; j++) {
                list.add(cube[i][2][j]);
            }
        }
        for (int i = 0; i < 3; i++) {
            list.addFirst(list.pollLast());
        }
        for (int i : inputCycle) {
            for (int j = 0; j < 3; j++) {
                cube[i][2][j] = list.poll();
            }
        }
        turnMySide(1, 1);
    }
    private static void dCounterclockwiseTurning() {
        // 0: 위, 1: 아래, 2: 앞, 3: 뒤, 4: 왼, 5: 오른
        LinkedList<Character> list = new LinkedList<>();
        int[] inputCycle = new int[]{3, 5, 2, 4};
        for (int i : inputCycle) {
            for (int j = 2; j > -1; j--) {
                list.add(cube[i][2][j]);
            }
        }
        for (int i = 0; i < 3; i++) {
            list.addFirst(list.pollLast());
        }
        for (int i : inputCycle) {
            for (int j = 2; j > -1; j--) {
                cube[i][2][j] = list.poll();
            }
        }
        turnMySide(1, 2);
    }

    private static void fClockwiseTurning() {
        // 0: 위, 1: 아래, 2: 앞, 3: 뒤, 4: 왼, 5: 오른
        LinkedList<Character> list = new LinkedList<>();
        int[] inputCycle = new int[]{0, 5, 1, 4};
        for (int i : inputCycle) {
            if (i == 0) {
                for (int j = 0; j < 3; j++) {
                    list.add(cube[i][2][j]);
                }
            }
            if (i == 5) {
                for (int j = 0; j < 3; j++) {
                    list.add(cube[i][j][0]);
                }
            }
            if (i == 1) {
                for (int j = 0; j < 3; j++) {
                    list.add(cube[i][2][j]);
                }
            }
            if (i == 4) {
                for (int j = 2; j > -1; j--) {
                    list.add(cube[i][j][2]);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            list.addFirst(list.pollLast());
        }
        for (int i : inputCycle) {
            if (i == 0) {
                for (int j = 0; j < 3; j++) {
                    cube[i][2][j] = list.poll();
                }
            }
            if (i == 5) {
                for (int j = 0; j < 3; j++) {
                    cube[i][j][0] = list.poll();
                }
            }
            if (i == 1) {
                for (int j = 0; j < 3; j++) {
                    cube[i][2][j] = list.poll();
                }
            }
            if (i == 4) {
                for (int j = 2; j > -1; j--) {
                    cube[i][j][2] = list.poll();
                }
            }
        }
        turnMySide(2, 1);
    }

    private static void fCounterclockwiseTurning() {
        // 0: 위, 1: 아래, 2: 앞, 3: 뒤, 4: 왼, 5: 오른
        LinkedList<Character> list = new LinkedList<>();
        int[] inputCycle = new int[]{0, 4, 1, 5};
        for (int i : inputCycle) {
            if (i == 0) {
                for (int j = 2; j > -1; j--) {
                    list.add(cube[i][2][j]);
                }
            }
            if (i == 5) {
                for (int j = 2; j > -1; j--) {
                    list.add(cube[i][j][0]);
                }
            }
            if (i == 1) {
                for (int j = 2; j > -1; j--) {
                    list.add(cube[i][2][j]);
                }
            }
            if (i == 4) {
                for (int j = 0; j < 3; j++) {
                    list.add(cube[i][j][2]);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            list.addFirst(list.pollLast());
        }
        for (int i : inputCycle) {
            if (i == 0) {
                for (int j = 2; j > -1; j--) {
                    cube[i][2][j] = list.poll();
                }
            }
            if (i == 5) {
                for (int j = 2; j > -1; j--) {
                    cube[i][j][0] = list.poll();
                }
            }
            if (i == 1) {
                for (int j = 2; j > -1; j--) {
                    cube[i][2][j] = list.poll();
                }
            }
            if (i == 4) {
                for (int j = 0; j < 3; j++) {
                    cube[i][j][2] = list.poll();
                }
            }
        }
        turnMySide(2, 2);
    }

    private static void bClockwiseTurning() {
        // 0: 위, 1: 아래, 2: 앞, 3: 뒤, 4: 왼, 5: 오른
        LinkedList<Character> list = new LinkedList<>();
        int[] inputCycle = new int[]{0, 4, 1, 5};
        for (int i : inputCycle) {
            if (i == 0) {
                for (int j = 2; j > -1; j--) {
                    list.add(cube[i][0][j]);
                }
            }
            if (i == 5) {
                for (int j = 2; j > -1; j--) {
                    list.add(cube[i][j][2]);
                }
            }
            if (i == 1) {
                for (int j = 2; j > -1; j--) {
                    list.add(cube[i][0][j]);
                }
            }
            if (i == 4) {
                for (int j = 0; j < 3; j++) {
                    list.add(cube[i][j][0]);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            list.addFirst(list.pollLast());
        }
        for (int i : inputCycle) {
            if (i == 0) {
                for (int j = 2; j > -1; j--) {
                    cube[i][0][j] = list.poll();
                }
            }
            if (i == 5) {
                for (int j = 2; j > -1; j--) {
                    cube[i][j][2] = list.poll();
                }
            }
            if (i == 1) {
                for (int j = 2; j > -1; j--) {
                    cube[i][0][j] = list.poll();
                }
            }
            if (i == 4) {
                for (int j = 0; j < 3; j++) {
                    cube[i][j][0] = list.poll();
                }
            }
        }
        turnMySide(3, 1);
    }

    private static void bCounterclockwiseTurning() {
        // 0: 위, 1: 아래, 2: 앞, 3: 뒤, 4: 왼, 5: 오른
        LinkedList<Character> list = new LinkedList<>();
        int[] inputCycle = new int[]{0, 5, 1, 4};
        for (int i : inputCycle) {
            if (i == 0) {
                for (int j = 0; j < 3; j++) {
                    list.add(cube[i][0][j]);
                }
            }
            if (i == 5) {
                for (int j = 0; j < 3; j++) {
                    list.add(cube[i][j][2]);
                }
            }
            if (i == 1) {
                for (int j = 0; j < 3; j++) {
                    list.add(cube[i][0][j]);
                }
            }
            if (i == 4) {
                for (int j = 2; j > -1; j--) {
                    list.add(cube[i][j][0]);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            list.addFirst(list.pollLast());
        }
        for (int i : inputCycle) {
            if (i == 0) {
                for (int j = 0; j < 3; j++) {
                    cube[i][0][j] = list.poll();
                }
            }
            if (i == 5) {
                for (int j = 0; j < 3; j++) {
                    cube[i][j][2] = list.poll();
                }
            }
            if (i == 1) {
                for (int j = 0; j < 3; j++) {
                    cube[i][0][j] = list.poll();
                }
            }
            if (i == 4) {
                for (int j = 2; j > -1; j--) {
                    cube[i][j][0] = list.poll();
                }
            }
        }
        turnMySide(3, 2);
    }

    private static void lClockwiseTurning() {
        // 0: 위, 1: 아래, 2: 앞, 3: 뒤, 4: 왼, 5: 오른
        LinkedList<Character> list = new LinkedList<>();
        int[] inputCycle = new int[]{0, 2, 1, 3};
        for (int i : inputCycle) {
            if (i == 0) {
                for (int j = 0; j < 3; j++) {
                    list.add(cube[i][j][0]);
                }
            }
            if (i == 2) {
                for (int j = 0; j < 3; j++) {
                    list.add(cube[i][j][0]);
                }
            }
            if (i == 1) {
                for (int j = 2; j > -1; j--) {
                    list.add(cube[i][j][2]);
                }
            }
            if (i == 3) {
                for (int j = 2; j > -1; j--) {
                    list.add(cube[i][j][2]);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            list.addFirst(list.pollLast());
        }
        for (int i : inputCycle) {
            if (i == 0) {
                for (int j = 0; j < 3; j++) {
                    cube[i][j][0] = list.poll();
                }
            }
            if (i == 2) {
                for (int j = 0; j < 3; j++) {
                    cube[i][j][0] = list.poll();
                }
            }
            if (i == 1) {
                for (int j = 2; j > -1; j--) {
                    cube[i][j][2] = list.poll();
                }
            }
            if (i == 3) {
                for (int j = 2; j > -1; j--) {
                    cube[i][j][2] = list.poll();
                }
            }
        }
        turnMySide(4, 1);
    }

    private static void lCounterclockwiseTurning() {
        // 0: 위, 1: 아래, 2: 앞, 3: 뒤, 4: 왼, 5: 오른
        LinkedList<Character> list = new LinkedList<>();
        int[] inputCycle = new int[]{0, 3, 1, 2};
        for (int i : inputCycle) {
            if (i == 0) {
                for (int j = 2; j > -1; j--) {
                    list.add(cube[i][j][0]);
                }
            }
            if (i == 2) {
                for (int j = 2; j > -1; j--) {
                    list.add(cube[i][j][0]);
                }
            }
            if (i == 1) {
                for (int j = 0; j < 3; j++) {
                    list.add(cube[i][j][2]);
                }
            }
            if (i == 3) {
                for (int j = 0; j < 3; j++) {
                    list.add(cube[i][j][2]);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            list.addFirst(list.pollLast());
        }
        for (int i : inputCycle) {
            if (i == 0) {
                for (int j = 2; j > -1; j--) {
                    cube[i][j][0] = list.poll();
                }
            }
            if (i == 2) {
                for (int j = 2; j > -1; j--) {
                    cube[i][j][0] = list.poll();
                }
            }
            if (i == 1) {
                for (int j = 0; j < 3; j++) {
                    cube[i][j][2] = list.poll();
                }
            }
            if (i == 3) {
                for (int j = 0; j < 3; j++) {
                    cube[i][j][2] = list.poll();
                }
            }
        }
        turnMySide(4, 2);
    }

    private static void rClockwiseTurning() {
        // 0: 위, 1: 아래, 2: 앞, 3: 뒤, 4: 왼, 5: 오른
        LinkedList<Character> list = new LinkedList<>();
        int[] inputCycle = new int[]{0, 3, 1, 2};
        for (int i : inputCycle) {
            if (i == 0) { // 위
                for (int j = 2; j > -1; j--) {
                    list.add(cube[i][j][2]);
                }
            }
            if (i == 2) { // 앞
                for (int j = 2; j > -1; j--) {
                    list.add(cube[i][j][2]);
                }
            }
            if (i == 1) { // 아래
                for (int j = 0; j < 3; j++) {
                    list.add(cube[i][j][0]);
                }
            }
            if (i == 3) { // 뒤
                for (int j = 0; j < 3; j++) {
                    list.add(cube[i][j][0]);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            list.addFirst(list.pollLast());
        }
        for (int i : inputCycle) {
            if (i == 0) {
                for (int j = 2; j > -1; j--) {
                    cube[i][j][2] = list.poll();
                }
            }
            if (i == 2) {
                for (int j = 2; j > -1; j--) {
                    cube[i][j][2] = list.poll();
                }
            }
            if (i == 1) {
                for (int j = 0; j < 3; j++) {
                    cube[i][j][0] = list.poll();
                }
            }
            if (i == 3) {
                for (int j = 0; j < 3; j++) {
                    cube[i][j][0] = list.poll();
                }
            }
        }
        turnMySide(5, 1);
    }

    private static void rCounterclockwiseTurning() {
        // 0: 위, 1: 아래, 2: 앞, 3: 뒤, 4: 왼, 5: 오른
        LinkedList<Character> list = new LinkedList<>();
        int[] inputCycle = new int[]{0, 2, 1, 3};
        for (int i : inputCycle) {
            if (i == 0) {
                for (int j = 0; j < 3; j++) {
                    list.add(cube[i][j][2]);
                }
            }
            if (i == 2) {
                for (int j = 0; j < 3; j++) {
                    list.add(cube[i][j][2]);
                }
            }
            if (i == 1) {
                for (int j = 2; j > -1; j--) {
                    list.add(cube[i][j][0]);
                }
            }
            if (i == 3) {
                for (int j = 2; j > -1; j--) {
                    list.add(cube[i][j][0]);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            list.addFirst(list.pollLast());
        }
        for (int i : inputCycle) {
            if (i == 0) {
                for (int j = 0; j < 3; j++) {
                    cube[i][j][2] = list.poll();
                }
            }
            if (i == 2) {
                for (int j = 0; j < 3; j++) {
                    cube[i][j][2] = list.poll();
                }
            }
            if (i == 1) {
                for (int j = 2; j > -1; j--) {
                    cube[i][j][0] = list.poll();
                }
            }
            if (i == 3) {
                for (int j = 2; j > -1; j--) {
                    cube[i][j][0] = list.poll();
                }
            }
        }
        turnMySide(5, 2);
    }

    private static void turnMySide(int type, int clock) {
        LinkedList<Character> list = new LinkedList<>();
        list.add(cube[type][0][0]);
        list.add(cube[type][0][1]);
        list.add(cube[type][0][2]);
        list.add(cube[type][1][2]);
        list.add(cube[type][2][2]);
        list.add(cube[type][2][1]);
        list.add(cube[type][2][0]);
        list.add(cube[type][1][0]);
        if (clock == 1) {
            list.addFirst(list.pollLast());
            list.addFirst(list.pollLast());
        }
        if (clock == 2) {
            list.addLast(list.pollFirst());
            list.addLast(list.pollFirst());
        }
        cube[type][0][0] = list.poll();
        cube[type][0][1] = list.poll();
        cube[type][0][2] = list.poll();
        cube[type][1][2] = list.poll();
        cube[type][2][2] = list.poll();
        cube[type][2][1] = list.poll();
        cube[type][2][0] = list.poll();
        cube[type][1][0] = list.poll();
    }
}
