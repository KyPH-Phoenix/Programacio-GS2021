package Containers2.Exercici3;

import java.util.Comparator;

public class Person {
    private String name;
    private int birthDate;

    public String getName() {
        return name;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public Person(String name, int birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return this.name + " born in " + this.birthDate;
    }
}

class PersonBirthComparator implements Comparator {
    @Override
    public int compare(Object o, Object t1) {
        Person p1 = (Person) o;
        Person p2 = (Person) t1;

        if (p1.getBirthDate() == p2.getBirthDate()) return 0;
        return (p1.getBirthDate() > p2.getBirthDate()) ? 1 : -1;
    }
}

class PersonNameComparator implements Comparator {
    @Override
    public int compare(Object o, Object t1) {
        Person p1 = (Person) o;
        Person p2 = (Person) t1;

        if (p1.getName().equals(p2.getName())) return  0;
        return greater(p1.getName(), p2.getName());
    }

    private int greater(String name1, String name2) {
        for (int i = 0; i < name1.length() && i < name2.length(); i++) {
            char c1 = name1.charAt(i);
            char c2 = name2.charAt(i);

            if (c1 != c2) {
                return (c1 > c2) ? 1 : -1;
            }
        }

        if (name1.length() == name2.length()) return 0;
        return (name1.length() > name2.length()) ? 1 : -1;
    }
}