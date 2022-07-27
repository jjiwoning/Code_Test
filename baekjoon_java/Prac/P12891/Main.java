package baekjoon_java.Prac.P12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 처음 부분 문자열을 한 번에 받고 문자를 하나씩 빼고 더하는 과정에서 비교를 해서 답을 구한다.
     */
    //아래 변수들은 함수에 들어갈 변수라 static으로 선언해서 파라미터로 안받고 공유할 수 있게 설정
    static int[] ACGT;
    static int[] nowACGT;
    static int check; // 4가지 알파벳이 원하는 값에 충족했는지 여부 -> 4일때 최대

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        char[] DNA = new char[N]; //DNA 전체 정보 저장하는 배열
        DNA = st.nextToken().toCharArray();
        int answer = 0; // 정답 출력할 변수

        st = new StringTokenizer(br.readLine());
        ACGT = new int[4]; // 원하는 값
        nowACGT = new int[4]; // 현재 값
        for (int i = 0; i < 4; i++) {
            ACGT[i] = Integer.parseInt(st.nextToken()); // 원하는 값 입력
            if(ACGT[i] == 0){ // 원하는 값이 0이면
                check++; // check 1 더해줌 -> 무조건 만족하기 때문에
            }
        }

        for (int i = 0; i < M; i++) {
            add(DNA[i]); // 함수로 분리
        }
        if(check == 4){
            answer++;
        }

        for (int i = M; i < N; i++) {
            int j = i - M;
            add(DNA[i]);
            remove(DNA[j]);
            if(check == 4){
                answer++;
            }
        }

        System.out.println(answer);

    }

    private static void add(char c){
        switch (c){
            case 'A':
                nowACGT[0]++;
                if(nowACGT[0] == ACGT[0]){ // 둘이 같아지는 순간 조건 충족
                    check++; // 더해줌
                }
                break;
            case 'C':
                nowACGT[1]++;
                if(nowACGT[1] == ACGT[1]){
                    check++;
                }
                break;
            case 'G':
                nowACGT[2]++;
                if(nowACGT[2] == ACGT[2]){
                    check++;
                }
                break;
            case 'T':
                nowACGT[3]++;
                if(nowACGT[3] == ACGT[3]){
                    check++;
                }
                break;
        }
    }

    private static void remove(char c){
        switch (c){
            case 'A':
                if(nowACGT[0] == ACGT[0]){ // 둘이 같을 때 하나 빠지면 조건을 불만족하게 됨
                    check--; // 감소
                }
                nowACGT[0]--;
                break;
            case 'C':
                if(nowACGT[1] == ACGT[1]){
                    check--;
                }
                nowACGT[1]--;
                break;
            case 'G':
                if(nowACGT[2] == ACGT[2]){
                    check--;
                }
                nowACGT[2]--;
                break;
            case 'T':
                if(nowACGT[3] == ACGT[3]){
                    check--;
                }
                nowACGT[3]--;
                break;
        }
    }
}
