package Containers2.Exercici2;

import java.util.PriorityQueue;
import java.util.Queue;

public class Car implements Comparable {
    private String brand;
    private int value;

    public Car(String brand, int value) {
        this.brand = brand;
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        Car c = (Car) o;

        int n = c.value;

        if (n == this.value) return 0;

        return (n > this.value) ? -1 : 1;
    }

    @Override
    public String toString() {
        return this.brand;
    }
}
