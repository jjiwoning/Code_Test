package Programmers_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class sds1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cycle = sc.nextInt(); // 몇 번 사이클 도는지 변수
        long [] answer = new long[cycle];

        for (int i = 0; i < cycle; i++) {
            List<Integer> list = new ArrayList<>(); // ArrayList로 일차원으로 받기.
            answer[i] = 0; // 초기화
            int n = sc.nextInt(); // 세로
            int m = sc.nextInt(); // 가로
            int d = sc.nextInt(); // 일 수
            for(int j = 0; j < n*m; j ++){
                list.add(sc.nextInt());
            }
            Collections.sort(list, Collections.reverseOrder());
            for(int k = 0; k < d; k++){
                int dOil = sc.nextInt();
                int total = 0;
                for(int a = 0; a < dOil; a++){
                    total += (list.remove(a) - 1);
                    list.add(1);
                }
                
            }

        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println("#" + (i + 1) + " " + answer[i]);
        }

        sc.close();
    }
    

}
