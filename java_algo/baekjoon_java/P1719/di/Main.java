package baekjoon_java.P1719.di;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st = null;
    public static int n, m;
    public static class Cor {
        int next;
        int dis;

        Cor (int next, int dis) {
            this.next = next;
            this.dis = dis;
        }

    }

    public static Integer [][] dist;
    public static int [][] startArrays;

    public static void dikstra(int start) {
        PriorityQueue<Cor> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dis));
        pq.add(new Cor(start, 0));
        boolean[] visited = new boolean[n+1];
        dist[start][start] = 0;

        for (int i = 0 ; i< graph.get(start).size() ; i++) {
            // 맨 처음 start node에서 인접한 node에 대해서 pq에 넣어주고 dist 값 + startArrays 값 초기화 해주기
            pq.add(new Cor(graph.get(start).get(i).next, graph.get(start).get(i).dis));
            startArrays[start][graph.get(start).get(i).next] = graph.get(start).get(i).next; // 인접한 node가 첫 방문 노드
            dist[start][graph.get(start).get(i).next] = graph.get(start).get(i).dis; // 거리도 넣어주기
        }

        while (!pq.isEmpty()) {
            Cor temp = pq.poll();

            if (visited[temp.next]) {
                continue; // 이미 방문한 노드이면 나가기
            }

            visited[temp.next] = true; // 방문 체크

            if (dist[start][temp.next] < temp.dis) continue; // 현재 노드의 거리가 더 길면 나가기

            for (int i = 0 ; i< graph.get(temp.next).size() ; i++) {
                Cor next = graph.get(temp.next).get(i);
                if (dist[start][next.next] > dist[start][temp.next] + next.dis) { // 거리가 더 짧은 경우
                    dist[start][next.next] = (dist[start][temp.next] + next.dis);
                    pq.add(new Cor(next.next, dist[start][next.next])); // 큐에 넣기

                    if (temp.next == start) { // temp.next가 start일 경우 startArrays 초기화 해주면 안 됨 -> startArrays[start][start] = 0 이기 때문에
                        continue;
                    }

                    startArrays[start][next.next] = startArrays[start][temp.next]; // startArrays 값 넣어주기
                }
            }
        }
    }

    public static ArrayList<ArrayList<Cor>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        st =new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new Integer[n+1][n+1];
        startArrays = new int[n+1][n+1];

        for (int i = 0 ; i<= n ; i++) {
            Arrays.fill(dist[i], 1000000);
        }
        for (int i = 0 ; i<= n ; i++) {
            dist[i][i] = 0;
        }

        for (int i = 0 ; i<= n ; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i =0 ; i< m ; i++) {
            int a,b,c;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Cor(b, c));
            graph.get(b).add(new Cor(a, c));
        }

        // dikstra 돌리기
        for (int i = 1; i<=n ; i++) {
            dikstra(i);
        }

        for (int i = 1; i<= n ; i++) {
            for (int j = 1; j<= n ; j++) {
                if (i==j) System.out.print("- ");
                else System.out.print(startArrays[i][j] + " ");
            }
            System.out.println();
        }
    }
}
