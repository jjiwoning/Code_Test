package Programmers_java.kakao_72412;

import java.util.*;

/**
 * 카카오 기출 - 순위 검색 -> 다시 풀어야됨
 */
public class Solution {

    List<Person> peopleList;
    Map<String, Set<Person>> languageMap;
    Map<String, Set<Person>> stackMap;
    Map<String, Set<Person>> careerMap;
    Map<String, Set<Person>> foodMap;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        peopleList = new ArrayList<>();

        initialMap();

        for (int i = 0; i < info.length; i++) {
            String[] s = info[i].split(" ");
            Person person = new Person(s[0], s[1], s[2], s[3], Integer.parseInt(s[4]));
            languageMap.get(s[0]).add(person);
            stackMap.get(s[1]).add(person);
            careerMap.get(s[2]).add(person);
            foodMap.get(s[3]).add(person);
            peopleList.add(person);
        }

        for (int i = 0; i < query.length; i++) {
            String[] queryInfo = query[i].split(" and ");
            int peopleCount = findPeople(queryInfo);
            answer[i] = peopleCount;
        }

        return answer;
    }

    private int findPeople(String[] queryInfo) {
        Set<Person> intersectSet = new HashSet<>(peopleList);
        if (!queryInfo[0].equals("-")) {
            intersectSet.retainAll(languageMap.get(queryInfo[0]));
        }
        if (!queryInfo[1].equals("-")) {
            intersectSet.retainAll(stackMap.get(queryInfo[1]));
        }
        if (!queryInfo[2].equals("-")) {
            intersectSet.retainAll(careerMap.get(queryInfo[2]));
        }
        String[] s = queryInfo[3].split(" ");
        if (!s[0].equals("-")) {
            intersectSet.retainAll(foodMap.get(s[0]));
        }

        int minScore = Integer.parseInt(s[1]);

        return binarySearch(intersectSet, minScore);
    }

    private int binarySearch(Set<Person> intersectSet, int minScore) {
        List<Person> personList = new ArrayList<>(intersectSet);
        personList.sort((o1, o2) -> o1.score - o2.score);

        int start = 0;
        int end = personList.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (personList.get(mid).score < minScore) {
                start = mid + 1;
            }
            if (personList.get(mid).score >= minScore) {
                end = mid - 1;
            }
        }

        System.out.println(personList.size());
        System.out.println(start);
        System.out.println(end);
        System.out.println("-------------");
        if (end == -1) {
            return 1;
        }
        return personList.size() - end - 1;
    }

    private void initialMap() {
        languageMap = new HashMap<>();
        stackMap = new HashMap<>();
        careerMap = new HashMap<>();
        foodMap = new HashMap<>();

        languageMap.put("cpp", new HashSet<>());
        languageMap.put("java", new HashSet<>());
        languageMap.put("python", new HashSet<>());

        stackMap.put("backend", new HashSet<>());
        stackMap.put("frontend", new HashSet<>());

        careerMap.put("junior", new HashSet<>());
        careerMap.put("senior", new HashSet<>());

        foodMap.put("chicken", new HashSet<>());
        foodMap.put("pizza", new HashSet<>());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"});
    }
}

class Person {
    String language;
    String stack;
    String career;
    String food;
    int score;

    public Person(String language, String stack, String career, String food, int score) {
        this.language = language;
        this.stack = stack;
        this.career = career;
        this.food = food;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return score == person.score && Objects.equals(language, person.language) && Objects.equals(stack, person.stack) && Objects.equals(career, person.career) && Objects.equals(food, person.food);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language, stack, career, food, score);
    }
}