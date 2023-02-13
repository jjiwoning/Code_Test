package swea.P1228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    static List<String> list;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 1; testCase <= 10; testCase++) {

            int n = Integer.parseInt(br.readLine());

            list = new LinkedList<>();
            list.addAll(Arrays.asList(br.readLine().split(" ")));

            int commandCount = Integer.parseInt(br.readLine());
            String[] command = br.readLine().split("I ");

            for (int i = 1; i < commandCount + 1; i++) {
                String[] command2 = command[i].split(" ");
                doCommand(Integer.parseInt(command2[0]), Arrays.copyOfRange(command2, 2, command2.length));
            }

            sb = new StringBuilder();
            sb.append("#").append(testCase);
            for (int i = 0; i < 10; i++) {
                sb.append(" ").append(list.get(i));
            }

            System.out.println(sb);
        }
    }

    private static void doCommand(int index, String[] strings) {
        list.addAll(index, Arrays.asList(strings));
    }
}
