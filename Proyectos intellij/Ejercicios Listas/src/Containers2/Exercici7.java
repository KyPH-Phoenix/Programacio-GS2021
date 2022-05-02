package Containers2;

import java.util.ArrayList;
import java.util.List;

public class Exercici7 {
    public static void main(String[] args) {
        List<Object> li = new ArrayList<>();

        li.add(new Dog());
        li.add(new Cat());
        li.add(new Dog());
        li.add(new Cat());

        int i = 0;

        for (Object o : li) {
            i++;
            String s = "El tipus del " + i + "º es ";
            if (o instanceof Cat) s += "Cat";
            else s += "Dog";

            System.out.println(s);
        }
    }
}

class Dog {}

class Cat {}
