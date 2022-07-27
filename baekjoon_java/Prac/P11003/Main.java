package baekjoon_java.Prac.P11003;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력 한 번에 내보내기 위해서 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Node> deque = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());

            while(!deque.isEmpty() && deque.getLast().value > value){
                deque.removeLast();
            }

            deque.addLast(new Node(i, value));

            if(deque.getFirst().index <= i - L){
                deque.removeFirst();
            }
            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node{
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
