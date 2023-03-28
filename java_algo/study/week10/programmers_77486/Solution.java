package study.week10.programmers_77486;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    Map<Integer, Seller> map;
    Map<String, Integer> nameToIndexMap;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        map = new HashMap<>();
        nameToIndexMap = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            map.put(i, new Seller(i, enroll[i]));
            nameToIndexMap.put(enroll[i], i);
        }

        for (int i = 0; i < referral.length; i++) {
            if (referral[i].equals("-")) {
                continue;
            }

            map.get(i).setParent(map.get(nameToIndexMap.get(referral[i])));
        }

        for (int i = 0; i < seller.length; i++) {
            sellLogic(map.get(nameToIndexMap.get(seller[i])), 100 * amount[i]);
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = map.get(i).sell;
        }

        return answer;
    }

    private void sellLogic(Seller seller, int amount) {
        int div = amount / 10;
        seller.sell += amount - div;
        Seller parentSeller = seller.parent;
        if (parentSeller != null) {
            while (true) {

                if (div < 10) {
                    parentSeller.sell += div;
                    break;
                }
                parentSeller.sell += div - div / 10;
                div /= 10;

                if (parentSeller.parent == null) {
                    break;
                }

                parentSeller = parentSeller.parent;
            }
        }
    }
}

class Seller {
    int index;
    String name;
    Seller parent;
    int sell;

    public Seller(int index, String name) {
        this.index = index;
        this.name = name;
        sell = 0;
    }

    public void setParent(Seller parent) {
        this.parent = parent;
    }
}
