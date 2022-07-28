package baekjoon_java.Prac.P1874;

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
        int []arr = new int[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuffer bf = new StringBuffer(); // 정답 넣어둘 변수 설정
        int num = 1;
        boolean result = true; // 결과가 출력 되는 지 확인하기 위한 boolean 변수

        for (int i = 0; i < arr.length; i++) {
            int want = arr[i];
            if(want >= num){
                // 현재 수열의 값 >= 오름차순 자연수 -> 값이 같아질때까지 스택에 push 하기
                while(want >= num){
                    stack.push(num++); // num은 문장이 실행되고 ++ 연산이 된다. (기본 문법)
                    bf.append("+\n");
                }
                // want == num 이므로 pop해줘야 된다.
                stack.pop();
                bf.append("-\n");
            }else{
                // 햔재 수열의 값 < 오름차순 자연수 -> pop을 해서 스택의 원소 값을 봐야됨
                int n = stack.pop();
                if(n > want){
                    System.out.println("NO"); // 스택의 수가 원하는 값보다 크면 수열 출력 불가
                    result = false;
                    break;
                }else{
                    bf.append("-\n");
                }
            }
        }

        if(result) System.out.println(bf.toString());

    }

}
