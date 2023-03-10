package Programmers_java.P160585;

public class Solution {

    int oCount;
    int xCount;

    public int solution(String[] board) {
        if (isCan(board)) {
            return 1;
        }
        return 0;
    }

    private boolean isCan(String[] board) {

        if (countCheck(board)){
            return false;
        }

        if (gameEndCheck(board)) {
            return false;
        }

        return true;
    }

    private boolean gameEndCheck(String[] board) {
        boolean oEnd = false;
        boolean xEnd = false;

        char[][] charBoard = new char[3][3];
        charBoard[0] = board[0].toCharArray();
        charBoard[1] = board[1].toCharArray();
        charBoard[2] = board[2].toCharArray();

        if (checkEnd(charBoard, 'O')) {
            oEnd = true;
        }

        if (checkEnd(charBoard, 'X')) {
            xEnd = true;
        }

        if (oEnd && !xEnd) {
            if (oCount <= xCount) {
                return true;
            }
        }

        if (xEnd && !oEnd) {
            if (oCount > xCount) {
                return true;
            }
        }

        return oEnd && xEnd;
    }

    private boolean checkEnd(char[][] charBoard, char wanted) {

        for (int i = 0; i < 3; i++) {
            if (charBoard[i][0] == wanted && charBoard[i][1] == wanted && charBoard[i][2] == wanted) {
                return true;
            }

            if (charBoard[0][i] == wanted && charBoard[1][i] == wanted && charBoard[2][i] == wanted) {
                return true;
            }
        }

        if (charBoard[0][0] == wanted && charBoard[1][1] == wanted && charBoard[2][2] == wanted) {
            return true;
        }

        if (charBoard[0][2] == wanted && charBoard[1][1] == wanted && charBoard[2][0] == wanted) {
            return true;
        }

        return false;
    }

    private boolean countCheck(String[] board) {
        oCount = 0;
        xCount = 0;

        for (String s : board) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == 'O') {
                    oCount++;
                }

                if (c == 'X') {
                    xCount++;
                }
            }
        }

        if (oCount < xCount) {
            return true;
        }

        if (oCount - xCount > 1) {
            return true;
        }

        return false;
    }
}
