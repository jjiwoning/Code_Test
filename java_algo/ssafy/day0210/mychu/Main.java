package ssafy.day0210.mychu;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Person> queue = new LinkedList<>();

        int personNumber = 1;
        int mychu = 20;
        queue.add(new Person(personNumber++, 1));

        while (true) {

            Person getMychuPerson = queue.poll();
            mychu -= getMychuPerson.mychuCount;
            getMychuPerson.addMychuCount();

            queue.add(getMychuPerson);

            if (mychu <= 0) {
                System.out.println(getMychuPerson.personNumber);
                break;
            }

            Person person = new Person(personNumber++, 1);
            queue.add(person);
        }
    }

    static class Person {
        int personNumber;
        int mychuCount;

        Person(int personNumber, int mychuCount) {
            this.personNumber = personNumber;
            this.mychuCount = mychuCount;
        }

        private void addMychuCount() {
            this.mychuCount++;
        }
    }
}
