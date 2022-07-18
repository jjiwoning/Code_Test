package baekjoon_java.P1062;

import java.util.Scanner;

public class Main {

    static int N;
    static int K;
    static String[] words;
    static int answer = 0;
    static int count = 0;
    static boolean[] check = new boolean[26];

    public static void main(String[] args){
        //System.setIn(new FileInputStream("src/Day1/P1062/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        words = new String[N];

        for (int i = 0; i < N ; i++) {
            words[i] = sc.next().replaceAll("[antic]]", "");
        }

        // 아스키 코드 연산
        check['a'-'a']=true;
        check['c'-'a']=true;
        check['i'-'a']=true;
        check['n'-'a']=true;
        check['t'-'a']=true;


        // k < 5 이면 0개가 나올 수 밖에 없음
        if(K < 5){
            System.out.println(0);
            sc.close();
            return;
        } else if (K == 26) {
            System.out.println(N);
            sc.close();
            return;
        }else{

            count = 5;
            answer = countWord();

            for (int i = 0; i < 26; i++) {
                if(check[i] == false){
                    dfs(i);
                }
            }
            System.out.println(answer);
        }

        sc.close();
    }

    static void dfs(int start){
        // 1. 체크인
        check[start] = true;
        count++;
        // 2. 목적지 : depth가 어디까지 내려 왔는가 -> k번째 depth가 됐는가? -> selectedCount == K
        if(count == K){
            answer = Math.max(answer, countWord());
        }else{
            // 3. 연결된 곳 : start + 1 ~ 25 번째 인덱스
            for (int i = start + 1; i < 26; i++) {
                // 4. 갈 수 있는지 : check[] 값이 false인 배열만 갈 수 있다.
                if(check[i] == false){
                    // 5. 가기 : dfs()
                    dfs(i);
                }
            }
        }
        // 6. 체크아웃
        check[start] = false;
        count--;
    }

    static int countWord(){
        int counter = 0;

        for (int i = 0; i < N; i++) {
            boolean isPossible = true;
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if(check[word.charAt(j) - 'a'] == false){
                    isPossible = false;
                    break;
                }
            }
            if(isPossible){ counter++; }

        }
        return counter;
    }

}
