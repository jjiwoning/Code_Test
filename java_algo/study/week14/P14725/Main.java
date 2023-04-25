package study.week14.P14725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 정답 출력을 위한 상수
    private static final String STRING_CONST = "--";
    private static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 최상위 노드 선언
        Node node = new Node(0, null);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            // 시작 노드 = 최상위 노드
            Node startNode = node;
            for (int j = 0; j < count; j++) {
                String name = st.nextToken();
                // 만약에 현재 노드에 해당 값이 있다면 -> 그냥 그 노드로 넘어가기
                if (startNode.nodeMap.containsKey(name)) {
                    startNode = startNode.nodeMap.get(name);
                    continue;
                }
                // 현재 노드에 해당 값이 없다면
                Node newNode = new Node(j + 1, name);
                // 새 노드 만들어서 map에 넣어주기
                startNode.nodeMap.put(name, newNode);
                // 현재 노드를 다시 설정
                startNode = newNode;
            }
        }

        answer = new StringBuilder();
        // 트리 탐색 -> dfs
        dfs(node);
        System.out.println(answer);
    }

    private static void dfs(Node node) {
        // 최상위 노드는 값을 출력하면 안된다.
        if (node.level == 0) {
            for (String s : node.nodeMap.keySet()) {
                dfs(node.nodeMap.get(s));
            }
            return;
        }

        // 순차적으로 정답에 넣어주기
        String depth = STRING_CONST.repeat(node.level - 1);
        answer.append(depth);
        answer.append(node.value);
        answer.append("\n");
        // 현재 노드의 자식들로 탐색 진행하기
        if (!node.nodeMap.isEmpty()) {
            for (String s : node.nodeMap.keySet()) {
                dfs(node.nodeMap.get(s));
            }
        }
    }
}

class Node {
    int level;
    String value;
    // 문자열 정렬 필요 -> TreeMap으로 Key 값 자동 정렬되게 설정
    Map<String, Node> nodeMap = new TreeMap<>();

    public Node(int level, String value) {
        this.level = level;
        this.value = value;
    }
}
