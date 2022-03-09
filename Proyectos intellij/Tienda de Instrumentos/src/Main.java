import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        Especificacion especificacion = new Especificacion();
        especificacion.añadirEsp("Tipo", "Guitarra");
        especificacion.añadirEsp("Color", "Azul");
        especificacion.añadirEsp("Número de cuerdas", 6);
        especificacion.añadirEsp("Marca", "Fender");
        especificacion.añadirEsp("Modelo", "Stratocaster");
        especificacion.añadirEsp("Es eléctrica", true);
        especificacion.añadirEsp("Precio", 10000);

        Intstrumento fenderStratocaster = new Intstrumento(especificacion);
        fenderStratocaster.setnSerie(123456);

        inventario.añadirInstrumentos(fenderStratocaster);
        System.out.println(inventario);
    }
}
