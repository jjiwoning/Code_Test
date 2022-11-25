package baekjoon_java.Prac.P1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /**
     * 백준 1253 좋다
     * 정렬 + 투 포인터 활용
     * 주의할 점 : 같은 수라도 인덱스가 다른 위치에 있다면 다른 수로 판단한다. -> 값으로 비교를 하면 안되고 해당 인덱스로 비교를 해야 된다.
     * 즉 iter로 풀기보다는 순수한 for문으로 푸는 것이 답이다.
     */
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr); // 배열 정렬 nlog(n)

        int count = 0; // 좋은 수 카운트

        for (int k = 0; k < N; k ++) {
            // k 값마다 start, end index 초기화 해줘야 된다.
            long findNum = arr[k];
            int start = 0;
            int end = N - 1;
            while(start < end){ // 이 조건 넘어가면 더 볼 이유 없음 -> 탈출
                if(arr[start] + arr[end] == findNum){
                    // 서로 다른 수 인지 확인해야 된다.
                    if(start != k && end != k){
                        // 둘 다 k가 아니므로 답이 되야하는 값
                        count++;
                        break; // 하나만 찾으면 되니 바로 탈출 -> 좋은 수 임을 알기만 하면 다음 조건들은 알 필요 없음
                    }else if(start == k){
                        // 자기 자신을 쓰면 안됨
                        start++;
                    } else if (end == k) {
                        end--;
                    }
                } else if (arr[start] + arr[end] < findNum) {
                    // k를 찾기 위해서는 start 값을 증가시켜야 된다.
                    start++;
                }else{
                    // k를 찾기 위해서는 end 값을 감소시켜야 된다.
                    end--;
                }
            }
        }

        System.out.println(count);

    }
}
