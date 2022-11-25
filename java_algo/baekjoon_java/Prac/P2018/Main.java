package baekjoon_java.Prac.P2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int sum = 1;
        int start = 1;
        int end = 1;
        int answer = 1;

        while(end != N){
            if(sum == N){
                answer++;
                end++;
                sum = sum + end;
            } else if (sum > N) {
                sum = sum - start;
                start++;
            }else{
                end++;
                sum = sum + end;
            }
        }

        System.out.println(answer);

    }

}
