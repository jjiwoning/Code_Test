package Programmers_java.P176962;

import java.util.*;

import static java.util.Comparator.*;

public class Solution {
    public String[] solution(String[][] plans) {
        List<String> answerList = new ArrayList<>();

        PriorityQueue<Assignment> planQueue = new PriorityQueue<>(comparingInt(o -> o.startTime));
        Stack<Assignment> planStack = new Stack<>();

        for (String[] plan : plans) {
            planQueue.add(new Assignment(plan[0], plan[1], plan[2]));
        }

        while (!planQueue.isEmpty()) {
            Assignment nowAssign = planQueue.poll();
            if (planQueue.isEmpty()) {
                answerList.add(nowAssign.name);
                while (!planStack.isEmpty()) {
                    answerList.add(planStack.pop().name);
                }
                break;
            }

            if (nowAssign.startTime + nowAssign.remainingTime <= planQueue.peek().startTime) {
                answerList.add(nowAssign.name);
                int time = planQueue.peek().startTime - (nowAssign.startTime + nowAssign.remainingTime);

                while (time > 0) {
                    if (planStack.isEmpty()) {
                        break;
                    }
                    Assignment a1 = planStack.pop();
                    if (a1.remainingTime <= time) {
                        time -= a1.remainingTime;
                        answerList.add(a1.name);
                        continue;
                    }
                    if (a1.remainingTime > time) {
                        a1.remainingTime -= time;
                        planStack.add(a1);
                        break;
                    }
                }

                continue;
            }

            if (nowAssign.startTime + nowAssign.remainingTime > planQueue.peek().startTime) {
                nowAssign.remainingTime -= (planQueue.peek().startTime - nowAssign.startTime);
                planStack.add(nowAssign);
            }
        }

        return answerList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] solution = sol.solution(new String[][]{{"1", "00:00", "30"}, {"2", "00:10", "10"}, {"3", "00:30", "10"}, {"4", "00:50", "10"}});
        System.out.println(Arrays.toString(solution));
    }
}

class Assignment {
    String name;
    int startTime;
    int remainingTime;

    public Assignment(String name, String startTime, String remainingTime) {
        this.name = name;
        this.startTime = setTimeToMin(startTime);
        this.remainingTime = Integer.parseInt(remainingTime);
    }

    private int setTimeToMin(String startTime) {
        int[] time = Arrays.stream(startTime.split(":")).mapToInt(Integer::parseInt).toArray();
        int totalTimeMin = 0;
        totalTimeMin += time[0] * 60;
        totalTimeMin += time[1];
        return totalTimeMin;
    }
}
