package Programmers_java.kakao_columnsandbeams;

/**
 * 프로그래머스 - 카카오 기둥과 보
 */
public class Solution {

    static boolean[][] columns; // 기둥
    static boolean[][] beams; // 보

    public int[][] solution(int n, int[][] build_frame) {
        columns = new boolean[n + 2][n + 2];
        beams = new boolean[n + 2][n + 2];
        int count = 0;

        for (int[] build : build_frame) {
            int x = build[0];
            int y = build[1];
            int type = build[2];
            int isInstall = build[3];

            // 기둥
            if (type == 0) {
                if (isInstall == 0) {
                    // 삭제
                    columns[x][y] = false;
                    if (!canDelete(x, y)) {
                        columns[x][y] = true;
                        continue;
                    }
                    count--;
                    continue;
                }

                if (isInstall == 1) {
                    // 설치
                    if (checkCol(x, y)) {
                        columns[x][y] = true;
                        count++;
                    }
                    continue;
                }
            }

            // 보
            if (type == 1) {
                if (isInstall == 0) {
                    // 삭제
                    beams[x][y] = false;
                    if (!canDelete(x, y)) {
                        beams[x][y] = true;
                        continue;
                    }
                    count--;
                    continue;
                }

                if (isInstall == 1) {
                    // 설치
                    if (checkBeam(x, y)) {
                        beams[x][y] = true;
                        count++;
                    }
                    continue;
                }
            }
        }
        int[][] answer = new int[count][3];
        count = 0;
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (columns[x][y]) {
                    answer[count][0] = x;
                    answer[count][1] = y;
                    answer[count][2] = 0;
                    count++;
                }

                if (beams[x][y]) {
                    answer[count][0] = x;
                    answer[count][1] = y;
                    answer[count][2] = 1;
                    count++;
                }
            }
        }
        return answer;
    }

    private boolean canDelete(int x, int y) {
        for (int i = Math.max(0, x - 1); i <= x + 1; i++) {
            for (int j = y; j <= y + 1; j++) {
                if (columns[i][j] && !checkCol(i, j)) {
                    return false;
                }
                if (beams[i][j] && !checkBeam(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkBeam(int x, int y) {
        if (y > 0 && columns[x][y - 1]) {
            return true;
        }

        if (y > 0 && columns[x + 1][y - 1]) {
            return true;
        }

        if (x > 0 && beams[x - 1][y] && beams[x + 1][y]) {
            return true;
        }

        return false;
    }

    private boolean checkCol(int x, int y) {
        if (y == 0) {
            return true;
        }

        if (columns[x][y - 1]) {
            return true;
        }

        if (x > 0 && beams[x - 1][y]) {
            return true;
        }

        if (beams[x][y]) {
            return true;
        }

        return false;
    }


}
