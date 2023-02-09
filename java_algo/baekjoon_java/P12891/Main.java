package baekjoon_java.P12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    
    static Map<String, Integer> map;
    static int[] needs;
    static String[] strings = new String[]{"A", "C", "G", "T"};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] s1 = br.readLine().split(" ");
        String dnaString = br.readLine();
        needs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int stringLength = Integer.parseInt(s1[0]);
        int makeLength = Integer.parseInt(s1[1]);
        int answer = 0;

        map = new HashMap<>();

        for (int i = 0; i < makeLength; i++) {
            String s = dnaString.charAt(i) + "";
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        if (checkDna()) {
            answer++;
        }

        for (int i = makeLength; i < stringLength; i++) {
            String deleteString = dnaString.charAt(i - makeLength) + "";
            String addString = dnaString.charAt(i) + "";
            map.put(deleteString, map.get(deleteString) - 1);
            map.put(addString, map.getOrDefault(addString, 0) + 1);
            if (checkDna()) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean checkDna() {
        for (int i = 0; i < 4; i++) {
            if (needs[i] == 0) {
                continue;
            }
            if (map.getOrDefault(strings[i], 0) < needs[i]) {
                return false;
            }
        }
        return true;
    }
}
