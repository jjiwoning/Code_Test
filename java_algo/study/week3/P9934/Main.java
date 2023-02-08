package study.week3.P9934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int[] arr;
    static int level;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int startIndex = ((int)Math.pow(2, k)) / 2 - 1;

        String[] s = br.readLine().split(" ");
        arr = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        level = (int)Math.pow(2, k - 2);

        inorder(startIndex);
    }

    static void inorder(int... index) {
        List<Integer> list = new ArrayList<>();
        for (int i : index) {
            System.out.print(arr[i] + " ");
            list.add(i - level);
            list.add(i + level);
        }
        System.out.println();
        if (level == 0) {
            return;
        }
        level /= 2;
        inorder(list.stream().mapToInt(o1 -> o1).toArray());
    }

    //4
    //1 2 1 3 1 2 1 4 1 2 1 3 1 2 1

}
