package baekjoon_java.P1759;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int L;
    static int C;
    static char[] words;
    static List<String> result;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        words = new char[C];
        result = new LinkedList<>();

        for (int i = 0; i < C; i++) {
            words[i] = sc.next().charAt(0); // char 데이터 입력 받는 방법.
        }

        Arrays.sort(words); // 배열 정렬 함수

        dfs(-1, 0, 0, 0, ""); // index가 -1로 두려면 배열에 index 값을 넣는 상황이 안나와야한다.
        // 시작 지점을 간편하게 두려고 더미 데이터 사용, 이런 상황 아니면 안쓰는게 좋다.

        for (String o : result) {
            System.out.println(o);
        }

        sc.close();
    }

    public static void dfs(int index, int ja, int mo, int length, String pwd){
        // 1. 체크인 생략 가능
        // 2. 목적지
        if(length == L){
            // 정답 로직
            if(ja >= 2 && mo >= 1){
                result.add(pwd);
            }
        }else{
            // 3. 연결된 곳 확인
            for (int i = index + 1; i < C; i++) {
                // 4. 갈 수 있는가? -> 다 갈 수 있음
                // 5. 간다
                if(words[i] == 'a' || words[i] == 'e' || words[i] == 'i' || words[i] == 'o' || words[i] == 'u'){
                    dfs(i, ja, mo + 1, length + 1, pwd + words[i]);
                }else{
                    dfs(i, ja + 1, mo, length + 1, pwd + words[i]);
                }

            }
        }
        // 6. 체크아웃 생략 가능
    }

}