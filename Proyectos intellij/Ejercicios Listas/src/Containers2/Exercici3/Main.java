package Containers2.Exercici3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("John", 1990));
        persons.add(new Person("Mary", 1981));
        persons.add(new Person("Tom", 2000));
        persons.add(new Person("Elisabeth", 1999));
        Collections.sort(persons, new PersonBirthComparator());
        System.out.println(persons);
        Collections.sort(persons, new PersonNameComparator());
        System.out.println(persons);
    }
}
