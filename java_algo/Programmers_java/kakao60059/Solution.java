package Programmers_java.kakao60059;

/**
 * 카카오 기출 - 자물쇠와 열쇠
 */
public class Solution {

    public boolean solution(int[][] key, int[][] lock) {
        int length = lock.length + 2 * key.length - 2;
        int[][] locks = new int[length][length];

        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                locks[i + key.length - 1][j + key.length - 1] = lock[i][j];
            }
        }

        for (int i = 0; i < 4; i++) {
            if (canOpenByKey(key, lock, length, locks)) {
                return true;
            }
            key = rotateKey(key);
        }

        return false;
    }

    private boolean canOpenByKey(int[][] key, int[][] lock, int length, int[][] locks) {
        for (int i = 0; i < length - key.length + 1; i++) {
            for (int j = 0; j < length - key.length + 1; j++) {

                for (int k = 0; k < key.length; k++) {
                    for (int l = 0; l < key.length; l++) {
                        locks[i + k][j + l] += key[k][l];
                    }
                }

                boolean check = true;

                for (int x = key.length - 1; x < lock.length + key.length - 1; x++) {
                    for (int y = key.length - 1; y < lock.length + key.length - 1; y++) {
                        if (locks[x][y] != 1) {
                            check = false;
                            break;
                        }
                    }
                }

                for (int k = 0; k < key.length; k++) {
                    for (int l = 0; l < key.length; l++) {
                        locks[i + k][j + l] -= key[k][l];
                    }
                }

                if (check) {
                    return true;
                }

            }
        }

        return false;
    }

    private int[][] rotateKey(int[][] key) {
        int[][] rotateKey = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                rotateKey[j][key.length - i - 1] = key[i][j];
            }
        }
        return rotateKey;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});
    }
}
