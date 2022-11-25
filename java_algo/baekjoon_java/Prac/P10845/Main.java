package baekjoon_java.Prac.P10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();

        int num = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(s.equals("push")){
                num = Integer.parseInt(st.nextToken());
                queue.add(num);
                continue;
            }

            if(s.equals("pop")){
                if(queue.isEmpty()){
                    System.out.println(-1);
                }else {
                    System.out.println(queue.poll());
                }
                continue;
            }

            if(s.equals("size")){
                System.out.println(queue.size());
                continue;
            }

            if(s.equals("empty")){
                if(queue.isEmpty()){
                    System.out.println(1);
                }else {
                    System.out.println(0);
                }
                continue;
            }

            if(s.equals("front")){
                if(queue.isEmpty()){
                    System.out.println(-1);
                }else {
                    System.out.println(queue.peek());
                }
                continue;
            }

            if(s.equals("back")){
                if(queue.isEmpty()){
                    System.out.println(-1);
                }else {
                    System.out.println(num);
                }
                continue;
            }
        }

    }
}
