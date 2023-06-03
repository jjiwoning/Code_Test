package baekjoon_java.P1071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_cant {

    static int n;
    static int[] arr;
    static int[] findArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        findArr = new int[n];

        Arrays.sort(arr);

        Arrays.stream(findArr).forEach(o1 -> System.out.print(o1 + " "));
    }
}
