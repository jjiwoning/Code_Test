package Programmers_java.kakao_friend4block;

import java.util.Stack;

/**
 * 프로그래머스 - 카카오 프렌즈4블록
 */
public class Solution {

    static boolean[][] checked;

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] charBoard = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                charBoard[i][j] = board[i].charAt(j);
            }
        }

        boolean flag = true;

        while (flag) {
            checked = new boolean[m][n];
            flag = false;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {

                    if (charBoard[i][j] == '!') {
                        continue;
                    }

                    if (checkBlock(i, j, charBoard)) {
                        checked[i][j] = true;
                        checked[i + 1][j] = true;
                        checked[i + 1][j + 1] = true;
                        checked[i][j + 1] = true;
                        flag = true;
                    }
                }
            }

            answer += delete(m, n, charBoard);

        }

        return answer;
    }

    private boolean checkBlock(int i, int j, char[][] charBoard) {
        char find = charBoard[i][j];
        return find == charBoard[i + 1][j] && find == charBoard[i + 1][j + 1] && find == charBoard[i][j + 1];
    }

    private int delete(int m, int n, char[][] board) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (checked[i][j]) {
                    board[i][j] = '-';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < m; j++) {
                if (board[j][i] == '-') {
                    count++;
                } else {
                    stack.push(board[j][i]);
                }
            }
            int index = m - 1;
            while (!stack.isEmpty()) {
                board[index--][i] = stack.pop();
            }
            for (int j = index; j >= 0; j--) {
                board[j][i] = '!';
            }
        }

        return count;
    }
}
