package Programmers_java.kakao258712;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {

	private Map<String, Person> people;

	public int solution(String[] friends, String[] gifts) {
		int answer = 0;
		people = new HashMap<>();

		for (String friend : friends) {
			people.put(friend, new Person(friend));
		}

		for (String gift : gifts) {
			String[] info = gift.split(" ");
			people.get(info[0]).giveGift(people.get(info[1]));
		}

		for (String friend : friends) {
			Person person = people.get(friend);

			int count = 0;

			for (String otherName : friends) {
				if (person.getName().equals(otherName)) {
					continue;
				}
				Person other = people.get(otherName);
				Integer cnt1 = person.getGivenGifts().getOrDefault(other, 0);
				Integer cnt2 = other.getGivenGifts().getOrDefault(person, 0);

				if (cnt1 > cnt2) {
					count++;
				}

				if (Objects.equals(cnt1, cnt2) && person.getGiftScore() > other.getGiftScore()) {
					count++;
				}
			}

			answer = Math.max(answer, count);
		}

		return answer;
	}

}

class Person {

	private String name;

	private int giftScore;

	private Map<Person, Integer> givenGifts;

	public Person(String name) {
		this.name = name;
		this.giftScore = 0;
		this.givenGifts = new HashMap<>();
	}

	public void giveGift(Person other) {
		this.giftScore++;
		other.giftScore--;
		this.givenGifts.put(other, this.givenGifts.getOrDefault(other, 0) + 1);
	}

	public String getName() {
		return name;
	}

	public int getGiftScore() {
		return giftScore;
	}

	public Map<Person, Integer> getGivenGifts() {
		return givenGifts;
	}
}
