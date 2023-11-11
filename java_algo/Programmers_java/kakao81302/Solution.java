package Programmers_java.kakao81302;

import java.util.*;

public class Solution {
	public int[] solution(String[][] places) {
		int[] answer = new int[places.length];

		for (int i = 0; i < places.length; i++) {
			answer[i] = isNotCorona(places[i]);
		}

		return answer;
	}

	public int isNotCorona(String[] place) {
		List<Person> people = initPeople(place);

		for (int firstIndex = 0; firstIndex < people.size() - 1; firstIndex++) {
			for (int secondIndex = firstIndex + 1; secondIndex < people.size(); secondIndex++) {
				if (isNotCorrectPosition(place, people.get(firstIndex), people.get(secondIndex))) {
					return 0;
				}
			}
		}

		return 1;
	}

	public boolean isNotCorrectPosition(String[] place, Person person, Person otherPerson) {
		if (person.getDistance(otherPerson) > 2) {
			return false;
		}
		if (person.getDistance(otherPerson) <= 1) {
			return true;
		}

		if (person.x == otherPerson.x || person.y == otherPerson.y) {
			return place[(person.x + otherPerson.x) / 2].charAt((person.y + otherPerson.y) / 2) != 'X';
		}

		return place[person.x].charAt(otherPerson.y) != 'X' || place[otherPerson.x].charAt(person.y) != 'X';
	}

	private List<Person> initPeople(String[] place) {
		List<Person> people = new ArrayList<>();

		for (int x = 0; x < place.length; x++) {
			for (int y = 0; y < place[x].length(); y++) {
				if(place[x].charAt(y) == 'P') {
					people.add(new Person(x, y));
				}
			}
		}

		return people;
	}
}

class Person {
	int x;
	int y;

	public Person(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getDistance(Person otherPerson) {
		return Math.abs(this.x - otherPerson.x) + Math.abs(this.y - otherPerson.y);
	}
}
