public class Main3enRalla {
    public static void main(String[] args) {
        String s =
                " | |o\n" +
                "x|o| \n" +
                " |x|x";

        Tablero t = new Tablero(s);
        System.out.println(t);

        System.out.println(t.guessWinner());
    }
}
