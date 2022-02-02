public class Person {
    String name;
    int age;

    Person (String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        Person p = (Person) o;

        if (p.name.equals(this.name) && p.age == this.age)
            return true;

        return false;
    }
}
