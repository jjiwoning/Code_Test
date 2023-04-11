package Programmers_java.kakao_42889;

import java.util.Arrays;

public class Solution {
    public int[] solution(int n, int[] stages) {
        int[] answer = new int[n];

        Stage[] stageInfo = new Stage[n + 1];

        stageInfo[0] = new Stage(0, 0, 0);
        stageInfo[0].setFailRate(-99999);

        for (int i = 1; i <= n; i++) {
            stageInfo[i] = new Stage(i, 0, 0);
        }

        for (int stage : stages) {

            if (stage == n + 1) {
                for (int i = 1; i <= n; i++) {
                    stageInfo[i].addPlayerCount();
                }
                continue;
            }

            for (int i = 1; i <= stage; i++) {
                stageInfo[i].addPlayerCount();
            }

            stageInfo[stage].addCanNotClearPlayerCount();
        }

        for (int i = 1; i <= n; i++) {
            stageInfo[i].setFailRate();
        }

        Arrays.sort(stageInfo, (o1, o2) -> {
            if (o2.getFailRate() > o1.getFailRate()) {
                return 1;
            }
            if (o2.getFailRate() == o1.getFailRate()) {
                return o1.getStageNumber() - o2.getStageNumber();
            }
            return -1;
        });

        for (int i = 0; i < n; i++) {
            answer[i] = stageInfo[i].getStageNumber();
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
    }
}

class Stage {
    private int stageNumber;
    private int playerCount;
    private int canNotClearPlayerCount;
    private double failRate;

    public Stage(int stageNumber, int playerCount, int canNotClearPlayerCount) {
        this.stageNumber = stageNumber;
        this.playerCount = playerCount;
        this.canNotClearPlayerCount = canNotClearPlayerCount;
    }

    public int getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber(int stageNumber) {
        this.stageNumber = stageNumber;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public int getCanNotClearPlayerCount() {
        return canNotClearPlayerCount;
    }

    public void setCanNotClearPlayerCount(int canNotClearPlayerCount) {
        this.canNotClearPlayerCount = canNotClearPlayerCount;
    }

    public void addPlayerCount() {
        this.playerCount++;
    }

    public void addCanNotClearPlayerCount() {
        this.canNotClearPlayerCount++;
    }

    public double getFailRate() {
        return failRate;
    }

    public void setFailRate() {
        if (this.playerCount == 0) {
            this.failRate = 0;
            return;
        }
        this.failRate = ((double) this.canNotClearPlayerCount / (double) this.playerCount);
    }

    public void setFailRate(double failRate) {
        this.failRate = failRate;
    }
}
