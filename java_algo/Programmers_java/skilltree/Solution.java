package Programmers_java.skilltree;

import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 - 스킬트리
 */
public class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<String, Integer> skillMap = new HashMap<>();
        for (int i = 0; i < skill.length(); i++) {
            skillMap.put(skill.charAt(i) + "", i);
        }

        for (String skillTree : skill_trees) {
            int checkIdx = 0;
            boolean checked = true;
            for (int i = 0; i < skillTree.length(); i++) {
                if (skillMap.containsKey(skillTree.charAt(i) + "")) {
                    if (checkIdx == skillMap.get(skillTree.charAt(i) + "")) {
                        checkIdx++;
                    } else {
                        checked = false;
                        break;
                    }
                }
            }
            if (checked) {
                answer++;
            }
        }

        return answer;
    }
}
