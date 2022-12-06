package Programmers_java.visitlength;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {

    public int solution(String dirs) {
        int answer = 0;
        Set<SaveDir> checked = new HashSet<>();

        int x = 0;
        int y = 0;

        char[] dirsArray = dirs.toCharArray();

        for (char dir : dirsArray) {
            if (dir == 'U') {
                int mx = x;
                int my = y + 1;
                if (my > 5) {
                    continue;
                }
                checked.add(new SaveDir(x, y, mx, my));
                x = mx;
                y = my;
            } else if (dir == 'D') {
                int mx = x;
                int my = y - 1;
                if (my < -5) {
                    continue;
                }
                checked.add(new SaveDir(mx, my, x, y));
                x = mx;
                y = my;
            } else if (dir == 'R') {
                int mx = x + 1;
                int my = y;
                if (mx > 5) {
                    continue;
                }
                checked.add(new SaveDir(x, y, mx, my));
                x = mx;
                y = my;
            } else {
                int mx = x - 1;
                int my = y;
                if (mx < -5) {
                    continue;
                }
                checked.add(new SaveDir(mx, my, x, y));
                x = mx;
                y = my;
            }
        }
        answer = checked.size();
        return answer;
    }
}

class SaveDir {
    int x;
    int y;
    int dx;
    int dy;

    public SaveDir(int x, int y, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaveDir saveDir = (SaveDir) o;
        if (x == saveDir.dx && y == saveDir.dy && dx == saveDir.x && dy == saveDir.y) {
            return true;
        }
        return x == saveDir.x && y == saveDir.y && dx == saveDir.dx && dy == saveDir.dy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, dx, dy);
    }
}
