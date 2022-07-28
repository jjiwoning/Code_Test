package baekjoon_java.Prac.P17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] answer = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            answer[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                // 스택이 비어있지 않으면서 현재 arr의 값이 스택의 제일 위의 값보다 큰 경우
                answer[stack.pop()] = arr[i]; // 오큰수 저장
            }
            stack.push(i);
        }

        StringBuffer sb = new StringBuffer();
        for (int i : answer) {
            sb.append(i + " ");
        }

        System.out.println(sb);

    }

}
