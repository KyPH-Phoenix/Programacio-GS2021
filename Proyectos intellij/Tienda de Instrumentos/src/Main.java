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

        Instrumento fenderStratocaster = new Instrumento(especificacion);
        fenderStratocaster.setnSerie(123456);

        inventario.añadirInstrumentos(fenderStratocaster);

        Especificacion especificacion2 = new Especificacion();
        especificacion2.añadirEsp("Tipo", "Bajo");
        especificacion2.añadirEsp("Número de cuerdas", 6);
        especificacion2.añadirEsp("Marca", "Fender");
        especificacion2.añadirEsp("Modelo", "Stratocaster");
        especificacion2.añadirEsp("Precio", 10000);

        inventario.buscar(especificacion);
    }
}
