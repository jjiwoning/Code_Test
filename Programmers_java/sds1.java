package Programmers_java;

import java.util.*;

public class sds1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cycle = sc.nextInt(); // 몇 번 사이클 도는지 변수
        long [] answer = new long[cycle];

        for (int i = 0; i < cycle; i++) {
            answer[i] = 0; // 초기화
            int n = sc.nextInt(); // 세로
            int m = sc.nextInt(); // 가로
            int d = sc.nextInt(); // 일 수
            Integer [] arr = new Integer[n*m];
            for(int j = 0; j < n*m; j ++){
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr ,Collections.reverseOrder());
            int idx = 0;
            for(int k = 0; k < d; k++){
                int dOil = sc.nextInt();
                for(int b = 0; b < arr.length; b++){
                    arr[b] += 1;
                }
                int total = 0;
                
                for(int a = 0; a < dOil; a++){
                    total += arr[idx] - 1;
                    arr[idx] = 1;
                    idx++;
                    if(idx >= arr.length){
                        idx = 0;
                    }
                }
                answer[i] += total * (k + 1);
                }
                
            }

        for (int i = 0; i < answer.length; i++) {
            System.out.println("#" + (i + 1) + " " + answer[i]);
        }
        sc.close();
    }
}
