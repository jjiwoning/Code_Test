package Programmers_java.kakao_columnsandbeams;

/**
 * 프로그래머스 - 카카오 기둥과 보
 */
public class Solution {

    static boolean[] columns;
    static boolean[] beams;

    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        int[][] building = new int[n + 1][n + 1]; // 1: 기둥, 2: 보, 3: 기둥 보 연결

        for (int[] build : build_frame) {
            int x = build[0];
            int y = build[1];
            int type = build[2];
            int isInstall = build[3];

            // 기둥
            if (type == 0) {
                if (isInstall == 0) {
                    // 삭제
                    continue;
                }

                if (isInstall == 1) {
                    // 설치
                    continue;
                }
            }

            if (type == 1) {
                // 보
                if (isInstall == 0) {
                    // 삭제
                    continue;
                }

                if (isInstall == 1) {
                    // 설치
                    continue;
                }
            }
        }

        return answer;
    }



}
