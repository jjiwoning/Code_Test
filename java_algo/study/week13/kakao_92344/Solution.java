package study.week13.kakao_92344;

public class Solution {
    public int solution(int[][] board, int[][] skill) {

        int[][] skillBoard = new int[board.length + 1][board[0].length + 1]; // 누적합을 적용할 배열

        for (int[] now : skill) {

            // attack
            if (now[0] == 1) {
                castingSkill(now[1], now[2], now[3], now[4], now[5] * -1, skillBoard);
            }

            // recover
            if (now[0] == 2) {
                castingSkill(now[1], now[2], now[3], now[4], now[5], skillBoard);
            }
        }

        initSkillBoard(skillBoard);

        return findNotBrokenBuilding(board, skillBoard);
    }

    private void castingSkill(int r1, int c1, int r2, int c2, int skill, int[][] skillBoard) {
        skillBoard[r1][c1] += skill;
        skillBoard[r2 + 1][c1] -= skill;
        skillBoard[r1][c2 + 1] -= skill;
        skillBoard[r2 + 1][c2 + 1] += skill;
    }

    private void initSkillBoard(int[][] skillBoard) {
        // 누적합으로 skillBoard 최종 결과 산출

        // 좌 -> 우 누적합
        for (int i = 0; i < skillBoard.length; i++) {
            int sum = 0;
            for (int j = 0; j < skillBoard[0].length; j++) {
                skillBoard[i][j] += sum;
                sum = skillBoard[i][j];
            }
        }

        // 상 -> 하 누적합
        for (int i = 0; i < skillBoard[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < skillBoard.length; j++) {
                skillBoard[j][i] += sum;
                sum = skillBoard[j][i];
            }
        }
    }

    private int findNotBrokenBuilding(int[][] board, int[][] skillBoard) {
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] + skillBoard[i][j] > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
