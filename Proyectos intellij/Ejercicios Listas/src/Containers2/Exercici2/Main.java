package Containers2.Exercici2;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Car> pq = new PriorityQueue<>();

        pq.offer(new Car("Audi", 10));
        pq.offer(new Car("Renault", 15));
        pq.offer(new Car("Fiat", 5));
        pq.offer(new Car("Mercedes",25));
        pq.offer(new Car("Volkswagen", 20));

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

}
