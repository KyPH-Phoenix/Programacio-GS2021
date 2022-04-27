import java.util.Objects;

public class Hash {
    public static void main(String[] args) {
        Car c1 = new Car("Opel Corsa", "1234ABC", "White");
        Car c2 = new Car("Opel Corsa", "1234ABC", "White");

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c1.equals(c2));
    }
}

class Car {
    String marca;
    String matricula;
    String color;

    public Car(String marca, String matricula, String color) {
        this.marca = marca;
        this.matricula = matricula;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(marca, car.marca) && Objects.equals(matricula, car.matricula) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, matricula, color);
    }
}