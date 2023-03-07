package algo_sample_code;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 코드 출처: https://codingnojam.tistory.com/66
public class TopologicalSortSample {

    public static void main(String[] args) throws IOException {
        // 위상정렬 결과를 출력할 객체
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 위상정렬에 사용할 진입차수 저장 배열
        // 길이가 9인 이유는 인덱스를 1부터 사용하기 위해서입니다.
        int[] edgeCount =new int[9];

        // 위상정렬에 사용할 그래프 2차원 리스트로 구현
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 각 노드별 인접한 노드정보 초기화
        graph.get(1).add(2);
        graph.get(1).add(4);
        graph.get(2).add(5);
        graph.get(2).add(6);
        graph.get(3).add(6);
        graph.get(4).add(2);
        graph.get(4).add(8);
        graph.get(7).add(3);
        graph.get(8).add(6);

        // 진입차수 테이블 초기화
        edgeCount[2] = 2;
        edgeCount[3] = 1;
        edgeCount[4] = 1;
        edgeCount[5] = 1;
        edgeCount[6] = 3;
        edgeCount[8] = 1;

        // 위상정렬에 사용할 큐
        Queue<Integer> q = new LinkedList<>();

        // 진입차수가 0인 값 큐에 넣기
        for (int i = 1; i < edgeCount.length; i++) {
            if (edgeCount[i] == 0) {
                q.offer(i);
            }
        }

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            // 큐에서 노드번호 꺼내기
            int nodeNo = q.poll();

            // 꺼낸 노드번호 정렬 결과값에 저장
            bw.write(String.valueOf(nodeNo) + " ");

            // 꺼낸 노드의 인접한 노드들 찾기
            List<Integer> list = graph.get(nodeNo);

            // 인접한 노드의 개수만큼 반복문 실행
            for (int i = 0; i < list.size(); i++) {
                // 인접한 노드 진입차수 갱신
                edgeCount[list.get(i)] -- ;
                // 갱신된 노드의 진입차수가 0이면 큐에 노드 넣기
                if (edgeCount[list.get(i)] == 0) {
                    q.offer(list.get(i));
                }
            }
        }

        // 위상정렬 수행 결과 값 출력
        bw.flush();
    }

}
