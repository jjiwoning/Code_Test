package baekjoon_java.Prac.P1377;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        mData[] arr = new mData[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new mData(Integer.parseInt(st.nextToken()), i);
        }

        Arrays.sort(arr);

        int Max = 0;

        for (int i = 0; i < N; i++) {
            if(Max < arr[i].index - i){
                // 현재 인덱스와 원래 인덱스 비교 후 값이 크면 맥스로 설정
                Max = arr[i].index - i;
            }
        }

        System.out.println(Max + 1); // 정렬이 끝난 상태에서의 루프 1 추가

    }

    // 배열의 정보를 담을 클래스 생성
    static class mData implements Comparable<mData>{

        int value;
        int index;

        public mData(int value, int index) {
            super();
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(mData o) {
            // 내 데이터 (this)와 비교 데이터(o)를 비교
            // 내 데이터가 더 큰 경우 +가 리턴됨 -> value 기준 오름차순 정렬
            return this.value - o.value;
        }
    }
}
