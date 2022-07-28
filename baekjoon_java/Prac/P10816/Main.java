package baekjoon_java.Prac.P10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Integer num = Integer.valueOf(st.nextToken());
            if(!map.containsKey(num)){
                map.put(num, 1);
            }else{
                map.put(num, map.get(num) + 1);
            }
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            if(map.containsKey(key)){
                sb.append(map.get(key) + " ");
            }else{
                sb.append("0 ");
            }

        }

        System.out.println(sb);

    }
}
