public class Variables {
    public static void main(String[] args) {
        int numeroAlumnesLiceu;
        numeroAlumnesLiceu = 500;
        int numeroAlumnesMarratxi = numeroAlumnesLiceu * 6;
        System.out.println(numeroAlumnesMarratxi);

        // Variables "final" no pueden cambiar
        final int telefono = 684572456;
        final String s = "hello";
    }
    public static void func2() {
        // Las variables no se guardan entre bloques.
    }
}
