package baekjoon_java.Prac.P1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /**
     * 2개의 번호를 합쳐 M으로 만들어야 된다. -> 투 포인터 알고리즘
     * 재료의 번호가 무작위로 주어진다. -> sort를 해주는게 좋다.
     */
    public static void main(String[] args) throws IOException {
        // 입력 부분 설계
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 변수 입력
        int N = Integer.parseInt(st.nextToken()); // 재료의 갯수
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 원하는 갑옷 번호 합
        int[] arr = new int[N]; // 갑옷 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬 하기
        Arrays.sort(arr);

        // 투 포인터 알고리즘 사용하기
        int end = N - 1;
        int start = 0;

        int answer = findCount(M, arr, end, start);

        System.out.println(answer);

    }

    private static int findCount(int M, int[] arr, int end, int start) {
        int count = 0; // M == sum 일때 증가시키는 값
        int sum; // 갑옷 무게의 합
        while(start < end){
            sum = arr[start] + arr[end];
            if(sum > M){
                end--;
            } else if (sum == M) {
                count++;
                start++;
            }else{
                start++;
            }
        }
        return count;
    }
}
