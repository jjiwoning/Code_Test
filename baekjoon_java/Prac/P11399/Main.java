package baekjoon_java.Prac.P11399;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] sumArr = new int[N];
        for (int i = 0; i <N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int insert_index = i;
            int insert_value = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i]){
                    insert_index = j + 1;
                    break;
                }
                if(j == 0){
                    insert_index = 0;
                }
            }
            for (int j = i; j > insert_index; j--) {
                arr[j] = arr[j - 1];
            }
            arr[insert_index] = insert_value;
        }
        sumArr[0] = arr[0];
        for (int i = 1; i < N; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum = sum + sumArr[i];
        }

        System.out.println(sum);
    }
}
