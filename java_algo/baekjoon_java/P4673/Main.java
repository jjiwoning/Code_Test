package baekjoon_java.P4673;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= 10000; i++) {
            set.add(i);
        }

        for (int i = 1; i <= 10000; i++) {
            if (!set.contains(i)) {
                continue;
            }

            int make = makeSelfNumber(i);

            while (make <= 10000) {
                if (!set.contains(make)) {
                    break;
                }

                set.remove(make);
                make = makeSelfNumber(make);
            }

        }

        for (Integer integer : set) {
            System.out.println(integer);
        }
    }

    private static int makeSelfNumber(int target) {

        String targetString = String.valueOf(target);
        int selfNumber = target;

        for (int j = 0; j < targetString.length(); j++) {
            int num = targetString.charAt(j) - '0';
            selfNumber += num;
        }

        return selfNumber;
    }

}
